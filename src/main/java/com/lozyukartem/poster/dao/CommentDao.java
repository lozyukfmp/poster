package com.lozyukartem.poster.dao;

import com.lozyukartem.poster.entity.Comment;

import java.util.List;

public interface CommentDao {

    List<Comment> getComments(int postId);

    Comment addComment(Comment comment);

    Comment getComment(int commentId);

    Comment editComment(int commentId);

    Comment deleteComment(int commentId);
}
