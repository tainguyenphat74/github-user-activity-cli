package com.github.model;

import java.util.Objects;

public class Organization {
    private String id;
    private String login;
    private String gravatar_id;
    private String url;
    private String avatar_url;

    public Organization() {}

    public Organization(String id, String login, String gravatar_id, String url, String avatar_url) {
        this.id = id;
        this.login = login;
        this.gravatar_id = gravatar_id;
        this.url = url;
        this.avatar_url = avatar_url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getGravatar_id() {
        return gravatar_id;
    }

    public void setGravatar_id(String gravatar_id) {
        this.gravatar_id = gravatar_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(id, that.id) && Objects.equals(login, that.login) && Objects.equals(gravatar_id, that.gravatar_id) && Objects.equals(url, that.url) && Objects.equals(avatar_url, that.avatar_url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, gravatar_id, url, avatar_url);
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id='" + id + '\'' +
                ", login='" + login + '\'' +
                ", gravatar_id='" + gravatar_id + '\'' +
                ", url='" + url + '\'' +
                ", avatar_url='" + avatar_url + '\'' +
                '}';
    }
}
