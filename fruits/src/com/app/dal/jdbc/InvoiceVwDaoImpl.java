/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.app.dal.jdbc;

import com.app.dal.dao.*;
import com.app.dal.factory.*;
import java.util.Date;
import com.app.dal.dto.*;
import com.app.dal.exceptions.*;
import java.sql.Connection;
import java.util.Collection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class InvoiceVwDaoImpl extends AbstractDAO implements InvoiceVwDao
{
	/** 
	 * The factory class for this DAO has two versions of the create() method - one that
takes no arguments and one that takes a Connection argument. If the Connection version
is chosen then the connection will be stored in this attribute and will be used by all
calls to this DAO, otherwise a new Connection will be allocated for each operation.
	 */
	protected java.sql.Connection userConn;

	/** 
	 * All finder methods in this class use this SELECT constant to build their queries
	 */
	protected final String SQL_SELECT = "SELECT date, bp_id, is_trx, id, price, quantity, name FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * Index of column date
	 */
	protected static final int COLUMN_DATE = 1;

	/** 
	 * Index of column bp_id
	 */
	protected static final int COLUMN_BP_ID = 2;

	/** 
	 * Index of column is_trx
	 */
	protected static final int COLUMN_IS_TRX = 3;

	/** 
	 * Index of column id
	 */
	protected static final int COLUMN_ID = 4;

	/** 
	 * Index of column price
	 */
	protected static final int COLUMN_PRICE = 5;

	/** 
	 * Index of column quantity
	 */
	protected static final int COLUMN_QUANTITY = 6;

	/** 
	 * Index of column name
	 */
	protected static final int COLUMN_NAME = 7;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 7;

	/** 
	 * Returns all rows from the invoice_vw table that match the criteria ''.
	 */
	public InvoiceVw[] findAll() throws InvoiceVwDaoException
	{
		return findByDynamicSelect( SQL_SELECT, null );
	}

	/** 
	 * Returns all rows from the invoice_vw table that match the criteria 'date = :date'.
	 */
	public InvoiceVw[] findWhereDateEquals(Date date) throws InvoiceVwDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE date = ? ORDER BY date", new Object[] { date==null ? null : new java.sql.Date( date.getTime() ) } );
	}

	/** 
	 * Returns all rows from the invoice_vw table that match the criteria 'bp_id = :bpId'.
	 */
	public InvoiceVw[] findWhereBpIdEquals(int bpId) throws InvoiceVwDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE bp_id = ? ORDER BY bp_id", new Object[] {  new Integer(bpId) } );
	}

	/** 
	 * Returns all rows from the invoice_vw table that match the criteria 'is_trx = :isTrx'.
	 */
	public InvoiceVw[] findWhereIsTrxEquals(short isTrx) throws InvoiceVwDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE is_trx = ? ORDER BY is_trx", new Object[] {  new Short(isTrx) } );
	}

	/** 
	 * Returns all rows from the invoice_vw table that match the criteria 'id = :id'.
	 */
	public InvoiceVw[] findWhereIdEquals(int id) throws InvoiceVwDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE id = ? ORDER BY id", new Object[] {  new Integer(id) } );
	}

	/** 
	 * Returns all rows from the invoice_vw table that match the criteria 'price = :price'.
	 */
	public InvoiceVw[] findWherePriceEquals(double price) throws InvoiceVwDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE price = ? ORDER BY price", new Object[] {  new Double(price) } );
	}

	/** 
	 * Returns all rows from the invoice_vw table that match the criteria 'quantity = :quantity'.
	 */
	public InvoiceVw[] findWhereQuantityEquals(double quantity) throws InvoiceVwDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE quantity = ? ORDER BY quantity", new Object[] {  new Double(quantity) } );
	}

	/** 
	 * Returns all rows from the invoice_vw table that match the criteria 'name = :name'.
	 */
	public InvoiceVw[] findWhereNameEquals(String name) throws InvoiceVwDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE name = ? ORDER BY name", new Object[] { name } );
	}

	/**
	 * Method 'InvoiceVwDaoImpl'
	 * 
	 */
	public InvoiceVwDaoImpl()
	{
	}

	/**
	 * Method 'InvoiceVwDaoImpl'
	 * 
	 * @param userConn
	 */
	public InvoiceVwDaoImpl(final java.sql.Connection userConn)
	{
		this.userConn = userConn;
	}

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows)
	{
		this.maxRows = maxRows;
	}

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows()
	{
		return maxRows;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "fruits.invoice_vw";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected InvoiceVw fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			InvoiceVw dto = new InvoiceVw();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected InvoiceVw[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			InvoiceVw dto = new InvoiceVw();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		InvoiceVw ret[] = new InvoiceVw[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(InvoiceVw dto, ResultSet rs) throws SQLException
	{
		dto.setDate( rs.getDate(COLUMN_DATE ) );
		dto.setBpId( rs.getInt( COLUMN_BP_ID ) );
		if (rs.wasNull()) {
			dto.setBpIdNull( true );
		}
		
		dto.setIsTrx( rs.getShort( COLUMN_IS_TRX ) );
		if (rs.wasNull()) {
			dto.setIsTrxNull( true );
		}
		
		dto.setId( rs.getInt( COLUMN_ID ) );
		dto.setPrice( rs.getDouble( COLUMN_PRICE ) );
		if (rs.wasNull()) {
			dto.setPriceNull( true );
		}
		
		dto.setQuantity( rs.getDouble( COLUMN_QUANTITY ) );
		if (rs.wasNull()) {
			dto.setQuantityNull( true );
		}
		
		dto.setName( rs.getString( COLUMN_NAME ) );
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(InvoiceVw dto)
	{
	}

	/** 
	 * Returns all rows from the invoice_vw table that match the specified arbitrary SQL statement
	 */
	public InvoiceVw[] findByDynamicSelect(String sql, Object[] sqlParams) throws InvoiceVwDaoException
	{
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			// construct the SQL statement
			final String SQL = sql;
		
		
			System.out.println( "Executing " + SQL );
			// prepare statement
			stmt = conn.prepareStatement( SQL );
			stmt.setMaxRows( maxRows );
		
			// bind parameters
			for (int i=0; sqlParams!=null && i<sqlParams.length; i++ ) {
				stmt.setObject( i+1, sqlParams[i] );
			}
		
		
			rs = stmt.executeQuery();
		
			// fetch the results
			return fetchMultiResults(rs);
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new InvoiceVwDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns all rows from the invoice_vw table that match the specified arbitrary SQL statement
	 */
	public InvoiceVw[] findByDynamicWhere(String sql, Object[] sqlParams) throws InvoiceVwDaoException
	{
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			// construct the SQL statement
			final String SQL = SQL_SELECT + " WHERE " + sql;
		
		
			System.out.println( "Executing " + SQL );
			// prepare statement
			stmt = conn.prepareStatement( SQL );
			stmt.setMaxRows( maxRows );
		
			// bind parameters
			for (int i=0; sqlParams!=null && i<sqlParams.length; i++ ) {
				stmt.setObject( i+1, sqlParams[i] );
			}
		
		
			rs = stmt.executeQuery();
		
			// fetch the results
			return fetchMultiResults(rs);
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new InvoiceVwDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

}