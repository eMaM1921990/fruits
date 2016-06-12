package com.app.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.business.X_Bank;
import com.app.dal.exceptions.BanksDaoException;
import com.app.i.business.I_Banks;

/**
 * Servlet implementation class saveBank
 */
@WebServlet("/saveBank")
public class saveBank extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public saveBank() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		I_Banks business=new X_Bank();
		try {
			business.add(request);
			response.getWriter().write("Data saved");
		} catch (BanksDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.getWriter().write("[Error] cause :"+e.getMessage());
		}
	}

}
