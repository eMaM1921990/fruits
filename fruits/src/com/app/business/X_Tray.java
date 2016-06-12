package com.app.business;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.app.business.utils.dateFormatter;
import com.app.dal.dto.Tray;
import com.app.dal.dto.TrayVw;
import com.app.dal.exceptions.TrayDaoException;
import com.app.dal.exceptions.TrayVwDaoException;
import com.app.dal.factory.TrayDaoFactory;
import com.app.dal.factory.TrayVwDaoFactory;
import com.app.i.business.I_Tray;
import com.google.gson.Gson;

public class X_Tray implements I_Tray {

	@Override
	public void add(HttpServletRequest request) throws TrayDaoException {
		// TODO Auto-generated method stub
		Tray dto=new Tray();
		dto.setBpId(Integer.parseInt(request.getParameter("bpId")));
		dto.setCreatedAt(new Date());
		dto.setNumberOfTray(Integer.parseInt(request.getParameter("numberOfTray")));
		dto.setName(request.getParameter("name"));
		TrayDaoFactory.create().insert(dto);

	}

	@Override
	public void update(HttpServletRequest request) throws TrayDaoException {
		// TODO Auto-generated method stub
		Tray dto=new Tray();
		dto.setBpId(Integer.parseInt(request.getParameter("bpId")));
		dto.setCreatedAt(new Date());
		dto.setNumberOfTray(Integer.parseInt(request.getParameter("numberOfTray")));
		dto.setId(Integer.parseInt(request.getParameter("id")));
		dto.setName(request.getParameter("name"));
		TrayDaoFactory.create().update(dto.createPk(), dto);

	}

	@Override
	public TrayVw[] transaction(HttpServletRequest request) throws TrayVwDaoException {
		// TODO Auto-generated method stub
		TrayVw[] data=TrayVwDaoFactory.create().findByDynamicWhere("created_at between ? and ? order by created_at desc", new Object[]{dateFormatter.getSQLDate(request.getParameter("datefrom")),dateFormatter.getSQLDate(request.getParameter("dateto"))});
		return data;
	}

	@Override
	public String ajax_transaction(HttpServletRequest request)
			throws TrayVwDaoException {
		// TODO Auto-generated method stub
		return new Gson().toJson(transaction(request));
	}

}
