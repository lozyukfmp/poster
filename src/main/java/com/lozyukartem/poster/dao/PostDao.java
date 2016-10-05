package com.lozyukartem.poster.dao;

import com.lozyukartem.poster.entity.Post;

import java.util.List;

public interface PostDao {

    List<Post> getPosts(int userId);

    Post getPost(int postId);

    Post addPost(Post post);

    void deletePost(int postId);

    void editPost(Post post);
}
