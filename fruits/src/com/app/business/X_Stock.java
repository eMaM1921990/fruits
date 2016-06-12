package com.app.business;

import javax.servlet.http.HttpServletRequest;

import com.app.dal.dto.Stock;
import com.app.dal.dto.StockPk;
import com.app.dal.exceptions.StockDaoException;
import com.app.dal.factory.StockDaoFactory;
import com.app.i.business.I_Stock;

public class X_Stock implements I_Stock {

	@Override
	public void add(HttpServletRequest request) throws StockDaoException {
		// TODO Auto-generated method stub
		Stock dto=new Stock();
		dto.setStockName(request.getParameter("stockName").trim());
		StockDaoFactory.create().insert(dto);

	}

	@Override
	public void update(HttpServletRequest request) throws StockDaoException {
		// TODO Auto-generated method stub
		Stock dto=new Stock();
		dto.setId(Integer.parseInt(request.getParameter("id")));
		dto.setStockName(request.getParameter("stockName").trim());
		StockDaoFactory.create().update(dto.createPk(), dto);

	}

	@Override
	public void delete(HttpServletRequest request) throws StockDaoException {
		// TODO Auto-generated method stub
		StockPk pk=new StockPk(Integer.parseInt(request.getParameter("id")));
		StockDaoFactory.create().delete(pk);

	}

	@Override
	public Stock[] list(HttpServletRequest request) throws StockDaoException {
		// TODO Auto-generated method stub
		Stock[] data=StockDaoFactory.create().findAll();
		return data;
	}

}
