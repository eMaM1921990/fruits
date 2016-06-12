package com.app.business.utils;

import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class dateFormatter {

	public static java.sql.Date getSQLDate(String p_date){
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date parsed;
        java.sql.Date sqlDate=null;
		try {
			parsed = format.parse(p_date);
			sqlDate = new java.sql.Date(parsed.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sqlDate;
        
	}
	
	public Date getIncrementDate(Date initDate,int incrementMonth){
		Calendar cal = Calendar.getInstance();
		cal.setTime(initDate);
		cal.set(Calendar.MONTH, (cal.get(Calendar.MONTH)+incrementMonth));
		initDate = cal.getTime();
		return  initDate;
		
	}
}