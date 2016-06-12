package com.app.i.business;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface I_Users {

	public void login(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException;
}
