package com.app.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;

import com.app.business.X_Invoices;
import com.app.i.business.I_Invoice;

/**
 * Servlet implementation class ajax_printInvoice
 */
@WebServlet("/ajax_printInvoice")
public class ajax_printInvoice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ajax_printInvoice() {
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
			String pdf=business.printPDF(Integer.parseInt(request.getParameter("invoiceId")), "sale_bill", request);
			response.getWriter().write(pdf);
		} catch (NumberFormatException | JRException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
