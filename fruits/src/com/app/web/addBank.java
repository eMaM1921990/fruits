package com.app.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.business.X_BP;
import com.app.dal.exceptions.BusinessPartnerDaoException;
import com.app.i.business.I_BP;

/**
 * Servlet implementation class addBank
 */
@WebServlet("/addBank")
public class addBank extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addBank() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		view(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		view(request, response);
	}
	protected void view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String defaultURL="/purchase/addBank.jsp";
		I_BP business=new X_BP();
		try {
			request.setAttribute("purchaseData", business.purchaser(request));
		} catch (BusinessPartnerDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher(defaultURL).include(request, response);
	}

}
