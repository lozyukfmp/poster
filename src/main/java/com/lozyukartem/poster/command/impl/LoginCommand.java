package com.lozyukartem.poster.command.impl;

import com.lozyukartem.poster.command.Command;
import com.lozyukartem.poster.command.CommandName;
import com.lozyukartem.poster.command.CommandUtil;
import com.lozyukartem.poster.dao.UserDao;
import com.lozyukartem.poster.dao.impl.UserDaoImpl;
import com.lozyukartem.poster.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCommand implements Command {

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String USER = "user";

    @Override
    public String execute(HttpServletRequest request) {

        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);

        UserDao userDao = new UserDaoImpl();

        User user = userDao.getUser(login, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute(USER, user);

            return CommandUtil.convertCommandName(CommandName.GET_HOME_PAGE);
        } else {
            return CommandUtil.convertCommandName(CommandName.GET_LOGIN_PAGE);
        }
    }
}
