package com.lozyukartem.poster.dao.impl;

import com.lozyukartem.poster.dao.UserDao;
import com.lozyukartem.poster.entity.User;
import com.lozyukartem.poster.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    private static final String GET_USER_QUERY = "SELECT * FROM user_credentials WHERE user_login = ? AND user_password = ?";
    private static final String ADD_USER_QUERY = "INSERT INTO users_credentials VALUES(NULL, ?, ?)";

    @Override
    public User getUser(String login, String password) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = null;
        try {
            connection = ConnectionPool.getConnection();
            statement = connection.prepareStatement(GET_USER_QUERY);
            statement.setString(1, login);
            statement.setString(2, password);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt(1));
                user.setLogin(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
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

        return user;
    }

    @Override
    public User addUser(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getConnection();
            statement = connection.prepareStatement(ADD_USER_QUERY);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());

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

        return user;
    }
}
