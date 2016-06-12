package com.app.business;

import javax.servlet.http.HttpServletRequest;

import com.app.dal.dto.Tips;
import com.app.dal.exceptions.TipsDaoException;
import com.app.dal.factory.TipsDaoFactory;
import com.app.i.business.I_Tips;

public class X_Tips implements I_Tips {

	@Override
	public void add(HttpServletRequest request) throws TipsDaoException {
		// TODO Auto-generated method stub
		Tips dto=new Tips();
		dto.setBpId(Integer.parseInt(request.getParameter("bpId")));
		dto.setTipsType(request.getParameter("tipsType"));
		if(dto.getTipsType()=="Amount"){
			dto.setAmountType("Rupee");
		}else{
			dto.setItemName(request.getParameter("itemName"));
		}
		dto.setWorth(Double.parseDouble(request.getParameter("worth")));
		TipsDaoFactory.create().insert(dto);

	}

}
