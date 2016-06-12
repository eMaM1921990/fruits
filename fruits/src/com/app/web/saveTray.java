package com.app.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.business.X_Tray;
import com.app.dal.exceptions.TrayDaoException;
import com.app.i.business.I_Tray;

/**
 * Servlet implementation class saveTray
 */
@WebServlet("/saveTray")
public class saveTray extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public saveTray() {
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
			business.add(request);
			response.getWriter().write("Tray saved");
		} catch (TrayDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.getWriter().write("[Error] cause :- "+e.getMessage());
		}
	}

}
