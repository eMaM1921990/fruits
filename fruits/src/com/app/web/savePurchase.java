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
import com.app.business.X_Items;
import com.app.dal.exceptions.InvoicesDaoException;
import com.app.dal.exceptions.ItemsDaoException;
import com.app.i.business.I_Invoice;
import com.app.i.business.I_Items;

/**
 * Servlet implementation class savePurchase
 */
@WebServlet("/savePurchase")
public class savePurchase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public savePurchase() {
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
		I_Items ibusiness=new X_Items();
		try {
			
			business.newInvoice(request);
			try {
				ibusiness.update(request);
			} catch (ItemsDaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.getWriter().write("Data saved successfuly");
		} catch (InvoicesDaoException | JRException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.getWriter().write("Error during save cause :- "+e.getMessage());
		}
	}

}
