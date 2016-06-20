package com.app.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.business.X_Loans;
import com.app.dal.exceptions.BusinessPartnerDaoException;
import com.app.dal.exceptions.LoansDaoException;
import com.app.i.business.I_Loans;

/**
 * Servlet implementation class savePayback
 */
@WebServlet("/savePayback")
public class savePayback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public savePayback() {
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
		I_Loans business=new X_Loans();
		try {
				business.addNew(request);
			response.getWriter().write("Data saved");
		} catch (LoansDaoException | BusinessPartnerDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.getWriter().write("[Error] cause :"+e.getMessage());
		}
		
	}

}
