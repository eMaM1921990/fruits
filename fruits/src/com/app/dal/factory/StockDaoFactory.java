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

public class StockDaoFactory
{
	/**
	 * Method 'create'
	 * 
	 * @return StockDao
	 */
	public static StockDao create()
	{
		return new StockDaoImpl();
	}

	/**
	 * Method 'create'
	 * 
	 * @param conn
	 * @return StockDao
	 */
	public static StockDao create(Connection conn)
	{
		return new StockDaoImpl( conn );
	}

}