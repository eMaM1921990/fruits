package com.app.i.business;

import javax.servlet.http.HttpServletRequest;

import com.app.dal.dto.TrayVw;
import com.app.dal.exceptions.TrayDaoException;
import com.app.dal.exceptions.TrayVwDaoException;

public interface I_Tray {
	public void add(HttpServletRequest request) throws TrayDaoException;
	public void update(HttpServletRequest request) throws TrayDaoException;
	public TrayVw[] transaction(HttpServletRequest request) throws TrayVwDaoException;
	public String ajax_transaction(HttpServletRequest request) throws TrayVwDaoException;

}
