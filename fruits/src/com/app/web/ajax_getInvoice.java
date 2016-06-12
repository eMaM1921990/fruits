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
 * Servlet implementation class ajax_getInvoice
 */
@WebServlet("/ajax_getInvoice")
public class ajax_getInvoice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ajax_getInvoice() {
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
			response.getWriter().write(business.ajax_previousInvoices(request));
		} catch (NumberFormatException | InvoiceVwDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
