package com.app.business;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.app.dal.dto.Salary;
import com.app.dal.exceptions.SalaryDaoException;
import com.app.dal.factory.SalaryDaoFactory;
import com.app.i.business.I_Salary;

public class X_Salary implements I_Salary {

	@Override
	public void salaryPaid(HttpServletRequest request) throws SalaryDaoException {
		// TODO Auto-generated method stub
		Salary dto=new Salary();
		dto.setAmount(Double.parseDouble(request.getParameter("amount")));
		dto.setDate(new Date());
		dto.setBpId(Integer.parseInt(request.getParameter("bpId")));
		SalaryDaoFactory.create().insert(dto);

	}

}
