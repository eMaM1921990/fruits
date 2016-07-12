package com.app.business;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.app.business.utils.dateFormatter;
import com.app.dal.dto.BusinessPartner;
import com.app.dal.dto.InvoiceLine;
import com.app.dal.dto.InvoiceLinePk;
import com.app.dal.dto.InvoiceVw;
import com.app.dal.dto.Invoices;
import com.app.dal.dto.InvoicesPk;
import com.app.dal.dto.Items;
import com.app.dal.dto.Patti;
import com.app.dal.dto.PattiLines;
import com.app.dal.dto.PattiLinesPk;
import com.app.dal.dto.PattiPk;
import com.app.dal.exceptions.BusinessPartnerDaoException;
import com.app.dal.exceptions.InvoiceLineDaoException;
import com.app.dal.exceptions.InvoiceVwDaoException;
import com.app.dal.exceptions.InvoicesDaoException;
import com.app.dal.exceptions.ItemsDaoException;
import com.app.dal.exceptions.PattiDaoException;
import com.app.dal.exceptions.PattiLinesDaoException;
import com.app.dal.factory.BusinessPartnerDaoFactory;
import com.app.dal.factory.InvoiceLineDaoFactory;
import com.app.dal.factory.InvoiceVwDaoFactory;
import com.app.dal.factory.InvoicesDaoFactory;
import com.app.dal.factory.ItemsDaoFactory;
import com.app.dal.factory.PattiDaoFactory;
import com.app.dal.factory.PattiLinesDaoFactory;
import com.app.dal.jdbc.ResourceManager;
import com.app.i.business.I_Invoice;
import com.google.gson.Gson;

public class X_Invoices implements I_Invoice{

	@Override
	public String newInvoice(HttpServletRequest request) throws InvoicesDaoException, JRException, SQLException {
		// TODO Auto-generated method stub
		Invoices dto=new Invoices();
		dto.setBpId(Integer.parseInt(request.getParameter("bpId")));
		dto.setDate(new Date());
		dto.setEmpIdNull(true);
		dto.setGrandTotal(request.getParameter("grandTotal"));
		dto.setIsTrx(Short.parseShort(request.getParameter("isTrx")));
		
		InvoicesPk pk=InvoicesDaoFactory.create().insert(dto);
		if(pk!=null){
			request.setAttribute("pk", pk); 
			// ADD INVOICE LINE
			try {
				newInvoiceLine(request);
			} catch (InvoiceLineDaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			/// UPDATE BALANCE
			try {
				if(dto.getIsTrx()==1){
					updateBalance(dto.getBpId(), Double.parseDouble(dto.getGrandTotal()));
				}
				
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BusinessPartnerDaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//print PDf
		if(dto.getIsTrx()==0){
			return printPDF(pk.getId(), "sale_bill", request);
		}else{
			if(Integer.parseInt(request.getParameter("token"))==0){
				return printPDF(pk.getId(), "small_token", request);
			}else{
				return printPDF(pk.getId(), "sale_bill", request);
			}
		}
		
	}

	@Override
	public void newInvoiceLine(HttpServletRequest request) throws InvoiceLineDaoException {
		// TODO Auto-generated method stub
		
		System.out.println(request.getParameter("data"));
		JSONArray arr=new JSONArray(request.getParameter("data"));
		
		for(int i=0;i<arr.length();i++){
			JSONObject obj=arr.getJSONObject(i);
			InvoiceLine dto=new InvoiceLine();
			dto.setInvoiceId(((InvoicesPk)request.getAttribute("pk")).getId());
			dto.setItemId(obj.getInt("itemId"));
			dto.setPrice(obj.getDouble("price"));
			dto.setQuantity(obj.getDouble("quantity"));
			if(obj.has("purchase")){
				dto.setCode(new X_Items().setCode(obj.getString("purchase"), obj.getString("name"), obj.getString("type")));
			}
			
			// for purchasee
			if(Short.parseShort(request.getParameter("isTrx"))==0){
					dto.setType(obj.getString("type"));
				
			}
			InvoiceLineDaoFactory.create().insert(dto);
			System.out.println("contain------- "+request.getParameterMap().containsKey("stockPurchase"));
			if(request.getParameterMap().containsKey("stockPurchase")){
				Items i_dto=new Items();
				i_dto.setCode(dto.getCode());
				System.out.println("Price---->"+obj.getDouble("price"));
				i_dto.setPrice(obj.getDouble("price"));
				i_dto.setQuantity(obj.getDouble("quantity"));
				System.out.println("type====>"+obj.getString("type"));
				i_dto.setType(obj.getString("type"));
				i_dto.setName(obj.getString("name"));
				i_dto.setId(obj.getInt("itemId"));
				
				
				try {
					ItemsDaoFactory.create().update(i_dto.createPk(), i_dto);
				} catch (ItemsDaoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}

	@Override
	public InvoiceVw[] previousInvoices(HttpServletRequest request) throws NumberFormatException, InvoiceVwDaoException {
		// TODO Auto-generated method stub
		InvoiceVw[] data=InvoiceVwDaoFactory.create().findByDynamicWhere("date=? and bp_id=? and is_trx=?", new Object[]{dateFormatter.getSQLDate(request.getParameter("date")),Integer.parseInt(request.getParameter("bpId")),Integer.parseInt(request.getParameter("isTrx"))});
		return data;
	}

	@Override
	public String ajax_previousInvoices(HttpServletRequest request)
			throws NumberFormatException, InvoiceVwDaoException {
		// TODO Auto-generated method stub
		return new Gson().toJson(previousInvoices(request));
	}

	@Override
	public void deletePurchase(HttpServletRequest request) throws InvoiceLineDaoException, NumberFormatException, BusinessPartnerDaoException {
		// TODO Auto-generated method stub
		InvoiceLinePk pk=new InvoiceLinePk(Integer.parseInt(request.getParameter("id")));
		InvoiceLineDaoFactory.create().delete(pk);
		
		//update balance
		updateBalance(Integer.parseInt(request.getParameter("bpId")),(Double.parseDouble(request.getParameter("balance"))*-1) );
		
	}

	@Override
	public InvoiceVw[] getLastDateInvoice(HttpServletRequest request) throws NumberFormatException, InvoiceVwDaoException {
		// TODO Auto-generated method stub
		InvoiceVw[] data=InvoiceVwDaoFactory.create().findByDynamicWhere(" bp_id=? and is_trx=? group by date having MAX(date)", new Object[]{Integer.parseInt(request.getParameter("bpId")),Integer.parseInt(request.getParameter("isTrx"))});
		return data;
	}

	@Override
	public String ajax_getLastDateInvoice(HttpServletRequest request)
			throws NumberFormatException, InvoiceVwDaoException {
		// TODO Auto-generated method stub
		return new Gson().toJson(getLastDateInvoice(request));
	}

	@Override
	public InvoiceVw[] getTransaction(HttpServletRequest request) throws InvoiceVwDaoException {
		// TODO Auto-generated method stub
		InvoiceVw[] data=InvoiceVwDaoFactory.create().findByDynamicWhere(" date between ? and ? and is_trx=? order by date desc", new Object[]{dateFormatter.getSQLDate(request.getParameter("datefrom")),dateFormatter.getSQLDate(request.getParameter("dateto")),new Integer(Integer.parseInt(request.getParameter("isTrx")))});
		return data;
	}

	@Override
	public String ajax_getTransaction(HttpServletRequest request)
			throws InvoiceVwDaoException {
		// TODO Auto-generated method stub
		return new Gson().toJson(getTransaction(request));
	}

	@Override
	public void updateBalance(int bpId, double amount) throws BusinessPartnerDaoException {
		// TODO Auto-generated method stub
		BusinessPartner dto=BusinessPartnerDaoFactory.create().findByPrimaryKey(bpId);
		dto.setBalance(dto.getBalance()+amount);
		BusinessPartnerDaoFactory.create().update(dto.createPk(), dto);
		
		
		
	}

	@Override
	public InvoiceLine getAvg(HttpServletRequest request) throws InvoiceLineDaoException {
		// TODO Auto-generated method stub
		System.out.println(request.getParameter("code"));
		InvoiceLine data=InvoiceLineDaoFactory.create().findByDynamicSelect("SELECT 0 as id, 0 as invoice_id,0 as item_id, AVG(quantity) as qunatity,AVG(quantity*price) as price,0 as total_price,null as type ,code from invoice_line where code=? group by code", new Object[]{request.getParameter("code")})[0];
		return data;
	}

	@Override
	public String ajax_getAvg(HttpServletRequest request) throws InvoiceLineDaoException {
		// TODO Auto-generated method stub
		return new Gson().toJson(getAvg(request));
	}

	@Override
	public void newPatti(HttpServletRequest request) throws PattiDaoException, PattiLinesDaoException {
		// TODO Auto-generated method stub
		Patti dto=new Patti();
		dto.setPattiDate(new Date());
		PattiPk pk=PattiDaoFactory.create().insert(dto);
		if(pk!=null){
			request.setAttribute("pk", pk.getId());
			newPattiLine(request);
		}
		
	}

	@Override
	public void newPattiLine(HttpServletRequest request) throws PattiLinesDaoException {
		// TODO Auto-generated method stub
		System.out.println(request.getParameter("data"));
		JSONArray data=new JSONArray(request.getParameter("data"));
		for(int i=0;i<data.length();i++){
			JSONObject obj=data.getJSONObject(i);
			PattiLines dto=new PattiLines();
			dto.setActualCost(obj.getDouble("actualCost"));
			dto.setActualQuantity(obj.getInt("actualQuantity"));
			dto.setAvgCost(obj.getDouble("avgCost"));
			dto.setAvgQuantity(obj.getInt("avgQuantity"));
			dto.setCode(obj.getString("code"));
			dto.setCommissionPercent(obj.getDouble("commissionPercent"));
			dto.setCooli(obj.getDouble("cooli"));
			dto.setLoory(obj.getDouble("loory"));
			dto.setPattiId((int)request.getAttribute("pk"));
			dto.setBalance(obj.getDouble("balance"));
			dto.setBpId(obj.getInt("bpId"));
			PattiLinesDaoFactory.create().insert(dto);
			
			try {
				updateBalance(obj.getInt("bpId"), obj.getDouble("balance")*-1);
			} catch (BusinessPartnerDaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Invoices getInvoice(HttpServletRequest request) throws InvoicesDaoException {
		// TODO Auto-generated method stub
		Invoices data=InvoicesDaoFactory.create().findByDynamicWhere("id IN (select invoice_id from invoice_line where code=?) AND is_trx=0", new Object[]{request.getParameter("code")})[0];
		return data;
	}

	@Override
	public String ajax_getInvoice(HttpServletRequest request)
			throws InvoicesDaoException {
		// TODO Auto-generated method stub
		return new Gson().toJson(getInvoice(request));
	}

	@Override
	public Patti[] listPatti(HttpServletRequest request) throws PattiDaoException {
		// TODO Auto-generated method stub
		Patti[] data=PattiDaoFactory.create().findAll();
		return data;
	}

	@Override
	public PattiLines[] PattiLine(HttpServletRequest request) throws NumberFormatException, PattiLinesDaoException {
		// TODO Auto-generated method stub
		PattiLines[] data=PattiLinesDaoFactory.create().findWherePattiIdEquals(Integer.parseInt(request.getParameter("pattiId")));
		return data;
	}

	@Override
	public String ajax_PattiLine(HttpServletRequest request) throws NumberFormatException, PattiLinesDaoException {
		// TODO Auto-generated method stub
		return new Gson().toJson(PattiLine(request));
	}

	@Override
	public void updatePattiLine(HttpServletRequest request)
			throws PattiLinesDaoException {
		// TODO Auto-generated method stub
		
		JSONArray data=new JSONArray(request.getParameter("data"));
		for(int i=0;i<data.length();i++){
			JSONObject obj=data.getJSONObject(i);
			PattiLinesDaoFactory.create().delete(new PattiLinesPk(obj.getInt("id")));

			PattiLines dto=new PattiLines();
			dto.setActualCost(obj.getDouble("actualCost"));
			dto.setActualQuantity(obj.getInt("actualQuantity"));
			dto.setAvgCost(obj.getDouble("avgCost"));
			dto.setAvgQuantity(obj.getInt("avgQuantity"));
			dto.setCode(obj.getString("code"));
			dto.setCommissionPercent(obj.getDouble("commissionPercent"));
			dto.setCooli(obj.getDouble("cooli"));
			dto.setLoory(obj.getDouble("loory"));
			dto.setPattiId((int)request.getAttribute("pk"));
			dto.setBalance(obj.getDouble("balance"));
			dto.setBpId(obj.getInt("bpId"));
			PattiLinesDaoFactory.create().insert(dto);
			
			
		}
		
	}

	@Override
	public String printPDF(int invoiceId,String reportName,HttpServletRequest request) throws JRException, SQLException {
		// TODO Auto-generated method stub
		Map<String, Object> param=new HashMap<String, Object>();
		param.put("invoice_id", invoiceId);
		String reportFullPath="/com/app/business/ticket/"+reportName+".jrxml";
		JasperDesign jd=null;
	    JasperReport js=null;
	    JasperPrint jp=null;
	    jd = JRXmlLoader.load(getClass().getResourceAsStream(reportFullPath));
	     js = JasperCompileManager.compileReport(jd);	 
	     jp = JasperFillManager.fillReport(js, param, ResourceManager.getConnection());
	     JRExporter exporter = null;
	     String outputFile = request.getServletContext().getRealPath("/tmp") + "/" + invoiceId + ".pdf";
	     System.out.println(outputFile);
	     exporter = (JRExporter) new JRPdfExporter();
	     exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
	     exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, outputFile);
	     exporter.exportReport();
	    
	     return invoiceId + ".pdf";
		
		
	}

	@Override
	public void updateInvoiceLine(HttpServletRequest request) throws NumberFormatException, InvoiceLineDaoException, BusinessPartnerDaoException {
		// TODO Auto-generated method stub
		InvoiceLine dto=InvoiceLineDaoFactory.create().findByPrimaryKey(Integer.parseInt(request.getParameter("id")));
		dto.setQuantity(Double.parseDouble(request.getParameter("Quantity")));
		dto.setPrice(Double.parseDouble(request.getParameter("newPrice")));
		InvoiceLineDaoFactory.create().update(dto.createPk(), dto);
		
		//Update balance
		double oldPrice=Double.parseDouble(request.getParameter("oldPrice"))*dto.getQuantity();
		double newPrice=dto.getPrice()*dto.getQuantity();
		updateBalance(Integer.parseInt(request.getParameter("bpId")), newPrice-oldPrice);
		
		
		
		
	}

}
