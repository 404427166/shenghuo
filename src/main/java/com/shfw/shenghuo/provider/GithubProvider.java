package com.shfw.shenghuo.provider;

import com.alibaba.fastjson.JSON;
import com.shfw.shenghuo.dto.AccesssTokenDTO;
import com.shfw.shenghuo.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * ClassName:GitHubProvider
 * Package:com.shfw.shenghuo.provider
 * Description:
 *
 * @Date:2020/2/12 16:56
 * @Author:404427166@qq.com
 */
@Component
public class GithubProvider {
    public String getAccessToken(AccesssTokenDTO accesssTokenDTO) {
        MediaType mediaType
                = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accesssTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {

            String string = response.body().string();
            String token = string.split("&")[0].split("=")[1];
            return token;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public GithubUser getUser(String accessToken) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token=" + accessToken)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            GithubUser githubUser = JSON.parseObject(string,GithubUser.class);
            return githubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
