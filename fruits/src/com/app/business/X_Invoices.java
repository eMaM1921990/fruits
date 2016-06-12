package com.app.business;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import com.app.business.utils.dateFormatter;
import com.app.dal.dto.InvoiceLine;
import com.app.dal.dto.InvoiceLinePk;
import com.app.dal.dto.InvoiceVw;
import com.app.dal.dto.Invoices;
import com.app.dal.dto.InvoicesPk;
import com.app.dal.exceptions.InvoiceLineDaoException;
import com.app.dal.exceptions.InvoiceVwDaoException;
import com.app.dal.exceptions.InvoicesDaoException;
import com.app.dal.factory.InvoiceLineDaoFactory;
import com.app.dal.factory.InvoiceVwDaoFactory;
import com.app.dal.factory.InvoicesDaoFactory;
import com.app.i.business.I_Invoice;
import com.google.gson.Gson;

public class X_Invoices implements I_Invoice{

	@Override
	public void newInvoice(HttpServletRequest request) throws InvoicesDaoException {
		// TODO Auto-generated method stub
		Invoices dto=new Invoices();
		dto.setBpId(Integer.parseInt(request.getParameter("bpId")));
		dto.setDate(new Date());
		dto.setEmpIdNull(true);
		dto.setGrandTotal(request.getParameter("grandTotal"));
		dto.setIsTrx(Short.parseShort(request.getParameter("isTrx")));
		
		InvoicesPk pk=InvoicesDaoFactory.create().insert(dto);
		if(pk!=null){
			request.setAttribute("pk", pk); 
			
			try {
				newInvoiceLine(request);
			} catch (InvoiceLineDaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void newInvoiceLine(HttpServletRequest request) throws InvoiceLineDaoException {
		// TODO Auto-generated method stub
		
		System.out.println(request.getParameter("data"));
		JSONArray arr=new JSONArray(request.getParameter("data"));
		for(int i=0;i<arr.length();i++){
			JSONObject obj=arr.getJSONObject(i);
			InvoiceLine dto=new InvoiceLine();
			dto.setInvoiceId(((InvoicesPk)request.getAttribute("pk")).getId());
			dto.setItemId(obj.getInt("itemId"));
			dto.setPrice(obj.getDouble("price"));
			dto.setQuantity(obj.getDouble("quantity"));
			InvoiceLineDaoFactory.create().insert(dto);
		}
		
	}

	@Override
	public InvoiceVw[] previousInvoices(HttpServletRequest request) throws NumberFormatException, InvoiceVwDaoException {
		// TODO Auto-generated method stub
		InvoiceVw[] data=InvoiceVwDaoFactory.create().findByDynamicWhere("date=? and bp_id=? and is_trx=?", new Object[]{dateFormatter.getSQLDate(request.getParameter("date")),Integer.parseInt(request.getParameter("bpId")),Integer.parseInt(request.getParameter("isTrx"))});
		return data;
	}

	@Override
	public String ajax_previousInvoices(HttpServletRequest request)
			throws NumberFormatException, InvoiceVwDaoException {
		// TODO Auto-generated method stub
		return new Gson().toJson(previousInvoices(request));
	}

	@Override
	public void deletePurchase(HttpServletRequest request) throws InvoiceLineDaoException {
		// TODO Auto-generated method stub
		InvoiceLinePk pk=new InvoiceLinePk(Integer.parseInt(request.getParameter("id")));
		InvoiceLineDaoFactory.create().delete(pk);
		
	}

	@Override
	public InvoiceVw[] getLastDateInvoice(HttpServletRequest request) throws NumberFormatException, InvoiceVwDaoException {
		// TODO Auto-generated method stub
		InvoiceVw[] data=InvoiceVwDaoFactory.create().findByDynamicWhere(" bp_id=? and is_trx=? group by date having MAX(date)", new Object[]{Integer.parseInt(request.getParameter("bpId")),Integer.parseInt(request.getParameter("isTrx"))});
		return data;
	}

	@Override
	public String ajax_getLastDateInvoice(HttpServletRequest request)
			throws NumberFormatException, InvoiceVwDaoException {
		// TODO Auto-generated method stub
		return new Gson().toJson(getLastDateInvoice(request));
	}

	@Override
	public InvoiceVw[] getTransaction(HttpServletRequest request) throws InvoiceVwDaoException {
		// TODO Auto-generated method stub
		InvoiceVw[] data=InvoiceVwDaoFactory.create().findByDynamicWhere(" date between ? and ? order by date desc", new Object[]{dateFormatter.getSQLDate(request.getParameter("datefrom")),dateFormatter.getSQLDate(request.getParameter("dateto"))});
		return data;
	}

	@Override
	public String ajax_getTransaction(HttpServletRequest request)
			throws InvoiceVwDaoException {
		// TODO Auto-generated method stub
		return new Gson().toJson(getTransaction(request));
	}

}
