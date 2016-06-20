package com.app.i.business;

import javax.servlet.http.HttpServletRequest;

import com.app.dal.dto.BusinessPartner;
import com.app.dal.exceptions.BusinessPartnerDaoException;

public interface I_BP {

	public void add(HttpServletRequest request) throws BusinessPartnerDaoException;
	public void update(HttpServletRequest request) throws BusinessPartnerDaoException;
	public void delete(HttpServletRequest request) throws BusinessPartnerDaoException;
	public BusinessPartner[] list(HttpServletRequest request) throws BusinessPartnerDaoException; 
	public BusinessPartner[] seller(HttpServletRequest request) throws BusinessPartnerDaoException;
	public BusinessPartner[] purchaser(HttpServletRequest request) throws BusinessPartnerDaoException;
	public BusinessPartner[] sellerAndPurchaser(HttpServletRequest request) throws BusinessPartnerDaoException;
	public BusinessPartner[] employee(HttpServletRequest request) throws BusinessPartnerDaoException;
	public BusinessPartner[] getSellerBalance(HttpServletRequest request) throws BusinessPartnerDaoException;
	public BusinessPartner[] getPuchaserBalance(HttpServletRequest request) throws BusinessPartnerDaoException;
	public String ajax_getSellerBalance(HttpServletRequest request) throws BusinessPartnerDaoException;
	public String ajax_getPuchaserBalance(HttpServletRequest request) throws BusinessPartnerDaoException;
	
}
