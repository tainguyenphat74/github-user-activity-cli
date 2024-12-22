package com.github.model;

public enum Type {
    CREATE_EVENT("CreateEvent"),
    PUSH_EVENT("PushEvent"),
    FOLK_EVENT("FolkEvent"),
    PULL_REQUEST_EVENT("PullRequestEvent"),
    PULL_REQUEST_REVIEW_COMMENT_EVENT("PullRequestReviewCommentEvent"),
    PULL_REQUEST_REVIEW_EVENT("PullRequestReviewEvent"),
    WATCH_EVENT("WatchEvent"),
    ISSUE_COMMENT_EVENT("IssueCommentEvent"),
    ISSUES_EVENT("IssuesEvent"),
    PUBLIC_EVENT("PublicEvent");

    private final String type;

    Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static Type getType(String type) {
        for (Type t : Type.values()) {
            if (t.type.equals(type)) {
                return t;
            }
        }
        return null;
    }
}
