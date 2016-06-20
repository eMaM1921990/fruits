package com.app.business;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.app.dal.dto.Loans;
import com.app.dal.exceptions.BusinessPartnerDaoException;
import com.app.dal.exceptions.LoansDaoException;
import com.app.dal.factory.LoansDaoFactory;
import com.app.i.business.I_Loans;

public class X_Loans implements I_Loans{

	@Override
	public void addNew(HttpServletRequest request) throws LoansDaoException, BusinessPartnerDaoException {
		// TODO Auto-generated method stub
		Loans dto=new Loans();
		dto.setBpId(Integer.parseInt(request.getParameter("bpId")));
		dto.setNeedToPay(Double.parseDouble(request.getParameter("needToPay")));
		dto.setPaid(Double.parseDouble(request.getParameter("paid")));
		dto.setPayDate(new Date());
		LoansDaoFactory.create().insert(dto);
		
		X_Invoices invoice=new X_Invoices();
		invoice.updateBalance(dto.getBpId(), dto.getPaid()*-1);
	}

}
