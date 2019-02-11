package com.htp.stock.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface CommandInterface {

    String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException, IOException;
}