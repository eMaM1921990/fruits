package com.app.business;

import javax.servlet.http.HttpServletRequest;

import com.app.dal.dto.Items;
import com.app.dal.dto.ItemsPk;
import com.app.dal.exceptions.ItemsDaoException;
import com.app.dal.factory.ItemsDaoFactory;
import com.app.i.business.I_Items;

public class X_Items implements I_Items{

	@Override
	public void add(HttpServletRequest request) throws ItemsDaoException {
		// TODO Auto-generated method stub
		Items dto=new Items();
		dto.setName(request.getParameter("name"));
		if(request.getParameter("quantity").equals(null) || request.getParameter("quantity").trim().length()==0){
			dto.setQuantityNull(true);
		}else{
			dto.setQuantity(Double.parseDouble(request.getParameter("quantity")));
		}
		dto.setStockId(Integer.parseInt(request.getParameter("stockId")));
		ItemsDaoFactory.create().insert(dto);
		
		
	}

	@Override
	public void update(HttpServletRequest request) throws ItemsDaoException {
		// TODO Auto-generated method stub
		Items dto=new Items();
		dto.setName(request.getParameter("name"));
		if(request.getParameter("quantity").equals(null) || request.getParameter("quantity").trim().length()==0){
			dto.setQuantityNull(true);
		}else{
			dto.setQuantity(Double.parseDouble(request.getParameter("quantity")));
		}
		dto.setStockId(Integer.parseInt(request.getParameter("stockId")));
		dto.setId(Integer.parseInt(request.getParameter("id")) );
		ItemsDaoFactory.create().update(dto.createPk(), dto);
		
	}

	@Override
	public void delete(HttpServletRequest request) throws ItemsDaoException {
		// TODO Auto-generated method stub
		ItemsPk pk=new ItemsPk(Integer.parseInt(request.getParameter("id")));
		ItemsDaoFactory.create().delete(pk);
		
	}

	@Override
	public Items[] list(HttpServletRequest request) throws ItemsDaoException {
		// TODO Auto-generated method stub
		Items [] data=ItemsDaoFactory.create().findAll();
		return data;
	}

}
