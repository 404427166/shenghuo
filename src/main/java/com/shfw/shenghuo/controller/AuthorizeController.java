package com.shfw.shenghuo.controller;

import com.shfw.shenghuo.dto.AccesssTokenDTO;
import com.shfw.shenghuo.dto.GithubUser;
import com.shfw.shenghuo.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ClassName:AuthorizeController
 * Package:com.shfw.shenghuo.controller
 * Description:
 *
 * @Date:2020/2/12 16:36
 * @Author:404427166@qq.com
 */
@Controller
public class AuthorizeController {

    @Autowired
    public GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect.uri}")
    private String redirectUri;

    @RequestMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state) {
        AccesssTokenDTO accesssTokenDTO = new AccesssTokenDTO();
        accesssTokenDTO.setClient_id(clientId);
        accesssTokenDTO.setCode(code);
        accesssTokenDTO.setClient_secret(clientSecret);
        accesssTokenDTO.setRedirect_uri(redirectUri);
        accesssTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accesssTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }
}
