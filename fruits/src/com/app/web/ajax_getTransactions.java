package com.app.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.business.X_Invoices;
import com.app.dal.exceptions.InvoiceVwDaoException;
import com.app.i.business.I_Invoice;

/**
 * Servlet implementation class ajax_getTransactions
 */
@WebServlet("/ajax_getTransactions")
public class ajax_getTransactions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ajax_getTransactions() {
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
		I_Invoice business=new X_Invoices();
		try {
			String x=business.ajax_getTransaction(request);
			response.getWriter().write(x);
		} catch (InvoiceVwDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
