package com.app.i.business;

import javax.servlet.http.HttpServletRequest;

import com.app.dal.dto.Stock;
import com.app.dal.exceptions.StockDaoException;

public interface I_Stock {

	public void add(HttpServletRequest request) throws StockDaoException;
	public void update(HttpServletRequest request) throws StockDaoException;
	public void delete(HttpServletRequest request) throws StockDaoException;
	public Stock[] list(HttpServletRequest request) throws StockDaoException;
}
