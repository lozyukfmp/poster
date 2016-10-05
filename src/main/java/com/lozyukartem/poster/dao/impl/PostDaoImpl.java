package com.lozyukartem.poster.dao.impl;

import com.lozyukartem.poster.dao.PostDao;
import com.lozyukartem.poster.entity.Post;
import com.lozyukartem.poster.entity.User;
import com.lozyukartem.poster.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostDaoImpl implements PostDao {

    public static final String GET_POSTS_QUERY = "SELECT * FROM posts WHERE user_id = ?";
    public static final String GET_POST_QUERY = "SELECT * FROM posts WHERE post_id = ?";
    public static final String ADD_POST_QUERY = "INSERT INTO posts VALUES(NULL, ?, ?, ?)";
    public static final String EDIT_POST_QUERY = "UPDATE posts SET post_text = ? WHERE post_id = ?";
    public static final String DELETE_POST_QUERY = "DELETE FROM posts WHERE post_id = ?";

    @Override
    public List<Post> getPosts(int userId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = null;
        List resultList = new ArrayList<>();
        try {
            connection = ConnectionPool.getConnection();
            statement = connection.prepareStatement(GET_POSTS_QUERY);
            statement.setInt(1, userId);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Post post = new Post();
                post.setId(resultSet.getInt(1));
                post.setUserId(resultSet.getInt(2));
                post.setDate(resultSet.getDate(3));
                post.setText(resultSet.getString(4));

                resultList.add(post);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return resultList;
    }

    @Override
    public Post getPost(int postId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Post post = null;
        try {
            connection = ConnectionPool.getConnection();
            statement = connection.prepareStatement(GET_POST_QUERY);
            statement.setInt(1, postId);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                post = new Post();
                post.setId(resultSet.getInt(1));
                post.setUserId(resultSet.getInt(2));
                post.setDate(resultSet.getDate(3));
                post.setText(resultSet.getString(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return post;
    }

    @Override
    public Post addPost(Post post) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getConnection();
            statement = connection.prepareStatement(ADD_POST_QUERY);
            statement.setInt(1, post.getUserId());
            statement.setDate(2, post.getDate());
            statement.setString(3, post.getText());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return post;
    }

    @Override
    public void deletePost(int postId) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getConnection();
            statement = connection.prepareStatement(DELETE_POST_QUERY);
            statement.setInt(1, postId);
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void editPost(Post post) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getConnection();
            statement = connection.prepareStatement(EDIT_POST_QUERY);
            statement.setString(1, post.getText());
            statement.setInt(2, post.getId());

            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
