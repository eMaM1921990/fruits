package com.app.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.business.X_BP;
import com.app.business.X_Items;
import com.app.dal.dto.Items;
import com.app.dal.exceptions.BusinessPartnerDaoException;
import com.app.dal.exceptions.ItemsDaoException;
import com.app.i.business.I_BP;
import com.app.i.business.I_Items;
import com.google.gson.Gson;

/**
 * Servlet implementation class tokenEntery
 */
@WebServlet("/tokenEntery")
public class tokenEntery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tokenEntery() {
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
		String defaultURL="/sales/TokenEntry.jsp";
		I_Items business=new X_Items();
		try {
			Items[] data=business.list(request);
			request.setAttribute("ItemData", data);
			request.setAttribute("ItemDataJSON", new Gson().toJson(data));
		} catch (ItemsDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		I_BP bp_business=new X_BP();
		try {
			request.setAttribute("customer", bp_business.seller(request));
		} catch (BusinessPartnerDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		request.getRequestDispatcher(defaultURL).include(request, response);
	}

}
