/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.app.dal.factory;

import java.sql.Connection;
import com.app.dal.dao.*;
import com.app.dal.jdbc.*;

public class InvoiceLineDaoFactory
{
	/**
	 * Method 'create'
	 * 
	 * @return InvoiceLineDao
	 */
	public static InvoiceLineDao create()
	{
		return new InvoiceLineDaoImpl();
	}

	/**
	 * Method 'create'
	 * 
	 * @param conn
	 * @return InvoiceLineDao
	 */
	public static InvoiceLineDao create(Connection conn)
	{
		return new InvoiceLineDaoImpl( conn );
	}

}
