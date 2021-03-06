package com.lozyukartem.poster.command.impl;

import com.lozyukartem.poster.command.Command;
import com.lozyukartem.poster.command.PageUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }

        return PageUtil.LOGIN_PAGE;
    }
}
