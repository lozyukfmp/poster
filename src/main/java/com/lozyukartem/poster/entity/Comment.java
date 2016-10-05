package com.lozyukartem.poster.entity;

import java.sql.Date;

public class Comment {
    private int id;
    private int userId;
    private int postId;
    private Date date;
    private String text;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (getId() != comment.getId()) return false;
        if (getUserId() != comment.getUserId()) return false;
        if (getPostId() != comment.getPostId()) return false;
        if (getDate() != null ? !getDate().equals(comment.getDate()) : comment.getDate() != null) return false;
        return getText() != null ? getText().equals(comment.getText()) : comment.getText() == null;

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getUserId();
        result = 31 * result + getPostId();
        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        result = 31 * result + (getText() != null ? getText().hashCode() : 0);
        return result;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
