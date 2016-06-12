package com.app.i.business;

import javax.servlet.http.HttpServletRequest;

import com.app.dal.exceptions.TipsDaoException;

public interface I_Tips {

	public void add(HttpServletRequest request) throws TipsDaoException;
}
