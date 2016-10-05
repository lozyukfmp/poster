package com.lozyukartem.poster.command.impl;

import com.lozyukartem.poster.command.Command;
import com.lozyukartem.poster.command.PageUtil;

import javax.servlet.http.HttpServletRequest;

public class GetPostPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return PageUtil.POST_PAGE;
    }
}
