package com.app.i.business;

import javax.servlet.http.HttpServletRequest;

import com.app.dal.dto.InvoiceVw;
import com.app.dal.exceptions.BusinessPartnerDaoException;
import com.app.dal.exceptions.InvoiceLineDaoException;
import com.app.dal.exceptions.InvoiceVwDaoException;
import com.app.dal.exceptions.InvoicesDaoException;

public interface I_Invoice {

	public void newInvoice(HttpServletRequest request) throws InvoicesDaoException;
	public void newInvoiceLine(HttpServletRequest request) throws InvoiceLineDaoException;
	public InvoiceVw[] previousInvoices(HttpServletRequest request) throws NumberFormatException, InvoiceVwDaoException;
	public String ajax_previousInvoices(HttpServletRequest request) throws NumberFormatException, InvoiceVwDaoException;
	public void deletePurchase(HttpServletRequest request) throws InvoiceLineDaoException;
	public InvoiceVw[] getLastDateInvoice(HttpServletRequest request) throws NumberFormatException, InvoiceVwDaoException;
	public String ajax_getLastDateInvoice(HttpServletRequest request) throws NumberFormatException, InvoiceVwDaoException;
	public InvoiceVw[] getTransaction(HttpServletRequest request) throws InvoiceVwDaoException;
	public String ajax_getTransaction(HttpServletRequest request) throws InvoiceVwDaoException;
	public void updateBalance(int bpId,double amount) throws BusinessPartnerDaoException;
}
