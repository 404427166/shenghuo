package com.shfw.shenghuo.dto;

/**
 * ClassName:GithubUser
 * Package:com.shfw.shenghuo.dto
 * Description:
 *
 * @Date:2020/2/12 19:03
 * @Author:404427166@qq.com
 */
public class GithubUser {
    private String name;
    private Long id;
    private String bio;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
