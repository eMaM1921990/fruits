package com.app.business;

import javax.servlet.http.HttpServletRequest;

import com.app.dal.dto.Banks;
import com.app.dal.exceptions.BanksDaoException;
import com.app.dal.factory.BanksDaoFactory;
import com.app.i.business.I_Banks;

public class X_Bank implements I_Banks {

	@Override
	public void add(HttpServletRequest request) throws BanksDaoException {
		// TODO Auto-generated method stub

		Banks dto=new Banks();
		dto.setAccountNumber(request.getParameter("accountNumber"));
		dto.setBankName(request.getParameter("bankName"));
		dto.setBranch(request.getParameter("branch"));
		dto.setBpId(Integer.parseInt(request.getParameter("bpId")));
		BanksDaoFactory.create().insert(dto);
	}

}
