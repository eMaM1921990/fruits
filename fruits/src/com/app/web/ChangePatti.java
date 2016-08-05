package com.app.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.business.X_Invoices;
import com.app.business.X_Items;
import com.app.dal.dto.Items;
import com.app.dal.exceptions.ItemsDaoException;
import com.app.dal.exceptions.PattiDaoException;
import com.app.i.business.I_Invoice;
import com.app.i.business.I_Items;
import com.google.gson.Gson;

/**
 * Servlet implementation class ChangePatti
 */
@WebServlet("/ChangePatti")
public class ChangePatti extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePatti() {
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
		String defaultURL="/purchase/ChangePatti.jsp";
		I_Invoice business=new X_Invoices();
		try {
			request.setAttribute("patti", business.listPatti(request));
			
		} catch (PattiDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		I_Items i_business=new X_Items();
		try {
			Items[] data=i_business.list(request);
			request.setAttribute("ItemDataJSON", new Gson().toJson(data));
		} catch (ItemsDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher(defaultURL).include(request, response);
	}
}
