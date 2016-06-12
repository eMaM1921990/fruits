package com.app.business;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.i.business.I_Users;

public class X_Users implements I_Users{

	@Override
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String defaultURL="home";
		String username=request.getParameter("username").trim();
		String password=request.getParameter("password").trim();
		if(!username.equals("admin") && !password.equals("admin")){
			defaultURL="login";
			request.setAttribute("msg", "[Error message ] Username or password not valid");
		}else{
			HttpSession session=request.getSession();
			session.setAttribute("login_session", username);
		}
		request.getRequestDispatcher(defaultURL).include(request, response);
		
	}

}
