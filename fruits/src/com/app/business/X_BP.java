package com.app.business;

import javax.servlet.http.HttpServletRequest;

import com.app.dal.dto.BusinessPartner;
import com.app.dal.dto.BusinessPartnerPk;
import com.app.dal.exceptions.BusinessPartnerDaoException;
import com.app.dal.factory.BusinessPartnerDaoFactory;
import com.app.i.business.I_BP;
import com.google.gson.Gson;

public class X_BP implements I_BP{

	@Override
	public void add(HttpServletRequest request) throws BusinessPartnerDaoException {
		// TODO Auto-generated method stub
		BusinessPartner dto=new BusinessPartner();
		dto.setBpName(request.getParameter("bpName"));
		dto.setBpAddress(request.getParameter("bpAddress"));
		dto.setBpPhone(request.getParameter("bpPhone"));
		dto.setIsCustomer((short)(request.getParameter("isCustomer")==null?0:1));
		dto.setIsEmployee((short)(request.getParameter("isEmployee")==null?0:1));
		dto.setIsSupplier((short)(request.getParameter("isSupplier")==null?0:1));
		dto.setBalance(Double.parseDouble(request.getParameter("bpBalance")));
		BusinessPartnerDaoFactory.create().insert(dto);
		
	}

	@Override
	public void update(HttpServletRequest request) throws BusinessPartnerDaoException {
		// TODO Auto-generated method stub
		BusinessPartner dto=new BusinessPartner();
		dto.setBpName(request.getParameter("bpName"));
		dto.setBpAddress(request.getParameter("bpAddress"));
		dto.setBpPhone(request.getParameter("bpPhone"));
		dto.setIsCustomer((short)(request.getParameter("isCustomer")==null?0:1));
		dto.setIsEmployee((short)(request.getParameter("isEmployee")==null?0:1));
		dto.setIsSupplier((short)(request.getParameter("isSupplier")==null?0:1));
		dto.setId(Integer.parseInt(request.getParameter("id")));
		BusinessPartnerDaoFactory.create().update(dto.createPk(), dto);
		
	}

	@Override
	public void delete(HttpServletRequest request) throws BusinessPartnerDaoException {
		// TODO Auto-generated method stub
		BusinessPartnerPk pk=new BusinessPartnerPk(Integer.parseInt(request.getParameter("id")));
		BusinessPartnerDaoFactory.create().delete(pk);
		
	}

	@Override
	public BusinessPartner[] list(HttpServletRequest request) throws BusinessPartnerDaoException {
		// TODO Auto-generated method stub
		BusinessPartner[] data=BusinessPartnerDaoFactory.create().findAll();
		return data;
	}

	@Override
	public BusinessPartner[] seller(HttpServletRequest request) throws BusinessPartnerDaoException {
		// TODO Auto-generated method stub
		BusinessPartner[] data=BusinessPartnerDaoFactory.create().findByDynamicWhere("is_customer=?", new Object[]{1});
		return data;
	}

	@Override
	public BusinessPartner[] purchaser(HttpServletRequest request)
			throws BusinessPartnerDaoException {
		// TODO Auto-generated method stub
		BusinessPartner[] data=BusinessPartnerDaoFactory.create().findByDynamicWhere("is_supplier=?", new Object[]{1});
		return data;
	}

	@Override
	public BusinessPartner[] sellerAndPurchaser(HttpServletRequest request)
			throws BusinessPartnerDaoException {
		// TODO Auto-generated method stub
		BusinessPartner[] data=BusinessPartnerDaoFactory.create().findByDynamicWhere("is_supplier=? or is_customer=?", new Object[]{1,1});
		return data;
	}

	@Override
	public BusinessPartner[] employee(HttpServletRequest request)
			throws BusinessPartnerDaoException {
		// TODO Auto-generated method stub
		BusinessPartner[] data=BusinessPartnerDaoFactory.create().findByDynamicWhere("is_employee=?", new Object[]{1});
		return data;
		
	}

	@Override
	public BusinessPartner[] getSellerBalance(HttpServletRequest request) throws BusinessPartnerDaoException {
		// TODO Auto-generated method stub
		BusinessPartner[] data=BusinessPartnerDaoFactory.create().findWhereIsCustomerEquals((short)1);
		return data;
	}

	@Override
	public BusinessPartner[] getPuchaserBalance(HttpServletRequest request) throws BusinessPartnerDaoException {
		// TODO Auto-generated method stub
		BusinessPartner[] data=BusinessPartnerDaoFactory.create().findWhereIsSupplierEquals((short)1);
		return data;
	}

	@Override
	public String ajax_getSellerBalance(HttpServletRequest request)
			throws BusinessPartnerDaoException {
		// TODO Auto-generated method stub
		return new Gson().toJson(getSellerBalance(request));
	}

	@Override
	public String ajax_getPuchaserBalance(HttpServletRequest request)
			throws BusinessPartnerDaoException {
		// TODO Auto-generated method stub
		return new Gson().toJson(getPuchaserBalance(request));
	}

}
