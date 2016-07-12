package com.app.i.business;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import net.sf.jasperreports.engine.JRException;

import com.app.dal.dto.InvoiceLine;
import com.app.dal.dto.InvoiceVw;
import com.app.dal.dto.Invoices;
import com.app.dal.dto.Patti;
import com.app.dal.dto.PattiLines;
import com.app.dal.exceptions.BusinessPartnerDaoException;
import com.app.dal.exceptions.InvoiceLineDaoException;
import com.app.dal.exceptions.InvoiceVwDaoException;
import com.app.dal.exceptions.InvoicesDaoException;
import com.app.dal.exceptions.PattiDaoException;
import com.app.dal.exceptions.PattiLinesDaoException;

public interface I_Invoice {

	public String newInvoice(HttpServletRequest request) throws InvoicesDaoException, JRException, SQLException;
	public void newInvoiceLine(HttpServletRequest request) throws InvoiceLineDaoException;
	public InvoiceVw[] previousInvoices(HttpServletRequest request) throws NumberFormatException, InvoiceVwDaoException;
	public String ajax_previousInvoices(HttpServletRequest request) throws NumberFormatException, InvoiceVwDaoException;
	public void deletePurchase(HttpServletRequest request) throws InvoiceLineDaoException, NumberFormatException, BusinessPartnerDaoException;
	public InvoiceVw[] getLastDateInvoice(HttpServletRequest request) throws NumberFormatException, InvoiceVwDaoException;
	public String ajax_getLastDateInvoice(HttpServletRequest request) throws NumberFormatException, InvoiceVwDaoException;
	public InvoiceVw[] getTransaction(HttpServletRequest request) throws InvoiceVwDaoException;
	public String ajax_getTransaction(HttpServletRequest request) throws InvoiceVwDaoException;
	public void updateBalance(int bpId,double amount) throws BusinessPartnerDaoException;
	public InvoiceLine getAvg(HttpServletRequest request) throws InvoiceLineDaoException;
	public String ajax_getAvg(HttpServletRequest request) throws InvoiceLineDaoException;
	public void newPatti(HttpServletRequest request) throws PattiDaoException, PattiLinesDaoException;
	public void newPattiLine(HttpServletRequest request) throws PattiLinesDaoException;
	public Invoices getInvoice(HttpServletRequest request) throws InvoicesDaoException;
	public String ajax_getInvoice(HttpServletRequest request) throws InvoicesDaoException;
	public Patti[] listPatti(HttpServletRequest request) throws PattiDaoException;
	public PattiLines[] PattiLine(HttpServletRequest request) throws NumberFormatException, PattiLinesDaoException;
	public String ajax_PattiLine(HttpServletRequest request) throws NumberFormatException, PattiLinesDaoException;
	public void updatePattiLine(HttpServletRequest request) throws PattiLinesDaoException;
	public String printPDF(int invoiceId,String reportName,HttpServletRequest request) throws JRException, SQLException;
	public void updateInvoiceLine(HttpServletRequest request) throws NumberFormatException, InvoiceLineDaoException, BusinessPartnerDaoException;
}
