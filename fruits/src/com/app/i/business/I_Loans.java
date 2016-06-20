package com.app.i.business;

import javax.servlet.http.HttpServletRequest;

import com.app.dal.exceptions.BusinessPartnerDaoException;
import com.app.dal.exceptions.LoansDaoException;

public interface I_Loans {

	public void addNew(HttpServletRequest request) throws LoansDaoException, BusinessPartnerDaoException;
}
