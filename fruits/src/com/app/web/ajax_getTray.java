package com.app.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.business.X_Tray;
import com.app.dal.exceptions.TrayVwDaoException;
import com.app.i.business.I_Tray;

/**
 * Servlet implementation class ajax_getTray
 */
@WebServlet("/ajax_getTray")
public class ajax_getTray extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ajax_getTray() {
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
		I_Tray business=new X_Tray();
		try {
			System.out.println(business.ajax_transaction(request));
			response.getWriter().write(business.ajax_transaction(request));
		} catch (TrayVwDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
