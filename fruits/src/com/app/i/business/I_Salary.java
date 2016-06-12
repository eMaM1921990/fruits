package com.app.i.business;

import javax.servlet.http.HttpServletRequest;

import com.app.dal.exceptions.SalaryDaoException;

public interface I_Salary {

	public void salaryPaid(HttpServletRequest request) throws SalaryDaoException;
}
