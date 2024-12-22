package com.github.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import java.util.Objects;

public class Activity {
    private String id;
    private String type;
    private Object actor;
    private Repository repo;
    private Object payload;
    @JsonProperty("public")
    private boolean publish;
    @JsonProperty("created_at")
    private OffsetDateTime createdAt;
    private Organization org;

    public Activity() {}

    public Activity(String id, String type, Object actor, Repository repo, Object payload, boolean publish, OffsetDateTime createdAt, Organization org) {
        this.id = id;
        this.type = type;
        this.actor = actor;
        this.repo = repo;
        this.payload = payload;
        this.publish = publish;
        this.createdAt = createdAt;
        this.org = org;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getActor() {
        return actor;
    }

    public void setActor(Object actor) {
        this.actor = actor;
    }

    public Repository getRepo() {
        return repo;
    }

    public void setRepo(Repository repo) {
        this.repo = repo;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

    public boolean isPublish() {
        return publish;
    }

    public void setPublish(boolean publish) {
        this.publish = publish;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public Organization getOrg() {
        return org;
    }

    public void setOrg(Organization org) {
        this.org = org;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return publish == activity.publish && Objects.equals(id, activity.id) && Objects.equals(type, activity.type) && Objects.equals(actor, activity.actor) && Objects.equals(repo, activity.repo) && Objects.equals(payload, activity.payload) && Objects.equals(createdAt, activity.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, actor, repo, payload, publish, createdAt, org);
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", actor=" + actor +
                ", repo=" + repo +
                ", payload=" + payload +
                ", publish=" + publish +
                ", createdAt=" + createdAt +
                ", org=" + org +
                '}';
    }
}
