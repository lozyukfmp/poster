package com.lozyukartem.poster.controller;

import com.lozyukartem.poster.command.Command;
import com.lozyukartem.poster.command.CommandName;
import com.lozyukartem.poster.command.CommandUtil;
import com.lozyukartem.poster.command.CommandFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    private static final String COMMAND = "command";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commandParameter = req.getParameter(COMMAND);
        CommandName commandName = CommandUtil.convertCommandParameter(commandParameter);
        CommandFactory factory = CommandFactory.getInstance();
        Command command = factory.getCommand(commandName);

        String url = command.execute(req);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(req.getContextPath() + url);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commandParameter = req.getParameter(COMMAND);
        CommandName commandName = CommandUtil.convertCommandParameter(commandParameter);
        CommandFactory factory = CommandFactory.getInstance();
        Command command = factory.getCommand(commandName);

        String url = command.execute(req);

        resp.sendRedirect(req.getContextPath() + "/Controller?command=" + url);
    }
}
