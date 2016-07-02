package com.app.i.business;

import javax.servlet.http.HttpServletRequest;

import com.app.dal.dto.Items;
import com.app.dal.exceptions.ItemsDaoException;

public interface I_Items {
	public void add(HttpServletRequest request) throws ItemsDaoException;
	public void update(HttpServletRequest request) throws ItemsDaoException;
	public void delete(HttpServletRequest request) throws ItemsDaoException;
	public Items[] list(HttpServletRequest request) throws ItemsDaoException;
	public String setCode(String purhcase,String name,String type);

}
