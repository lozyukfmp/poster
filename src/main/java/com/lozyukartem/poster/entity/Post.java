package com.lozyukartem.poster.entity;

import java.sql.Date;

public class Post {

    private int id;
    private int userId;
    private Date date;
    private String text;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (getId() != post.getId()) return false;
        if (getUserId() != post.getUserId()) return false;
        if (getDate() != null ? !getDate().equals(post.getDate()) : post.getDate() != null) return false;
        return getText() != null ? getText().equals(post.getText()) : post.getText() == null;

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getUserId();
        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        result = 31 * result + (getText() != null ? getText().hashCode() : 0);
        return result;
    }
}
