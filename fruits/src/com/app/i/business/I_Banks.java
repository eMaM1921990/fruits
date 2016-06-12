package com.app.i.business;

import javax.servlet.http.HttpServletRequest;

import com.app.dal.exceptions.BanksDaoException;

public interface I_Banks {

	public void add(HttpServletRequest request) throws BanksDaoException;
}
