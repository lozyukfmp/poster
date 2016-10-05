package com.lozyukartem.poster.command.impl;

import com.lozyukartem.poster.command.Command;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return null;
    }
}
