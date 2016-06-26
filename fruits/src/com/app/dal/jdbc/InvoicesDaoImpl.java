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

public class InvoicesDaoImpl extends AbstractDAO implements InvoicesDao
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
	protected final String SQL_SELECT = "SELECT id, date, grand_total, bp_id, is_trx, emp_id FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( id, date, grand_total, bp_id, is_trx, emp_id ) VALUES ( ?, ?, ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET id = ?, date = ?, grand_total = ?, bp_id = ?, is_trx = ?, emp_id = ? WHERE id = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE id = ?";

	/** 
	 * Index of column id
	 */
	protected static final int COLUMN_ID = 1;

	/** 
	 * Index of column date
	 */
	protected static final int COLUMN_DATE = 2;

	/** 
	 * Index of column grand_total
	 */
	protected static final int COLUMN_GRAND_TOTAL = 3;

	/** 
	 * Index of column bp_id
	 */
	protected static final int COLUMN_BP_ID = 4;

	/** 
	 * Index of column is_trx
	 */
	protected static final int COLUMN_IS_TRX = 5;

	/** 
	 * Index of column emp_id
	 */
	protected static final int COLUMN_EMP_ID = 6;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 6;

	/** 
	 * Index of primary-key column id
	 */
	protected static final int PK_COLUMN_ID = 1;

	/** 
	 * Inserts a new row in the invoices table.
	 */
	public InvoicesPk insert(Invoices dto) throws InvoicesDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			stmt = conn.prepareStatement( SQL_INSERT, Statement.RETURN_GENERATED_KEYS );
			int index = 1;
			stmt.setInt( index++, dto.getId() );
			stmt.setDate(index++, dto.getDate()==null ? null : new java.sql.Date( dto.getDate().getTime() ) );
			stmt.setString( index++, dto.getGrandTotal() );
			if (dto.isBpIdNull()) {
				stmt.setNull( index++, java.sql.Types.INTEGER );
			} else {
				stmt.setInt( index++, dto.getBpId() );
			}
		
			if (dto.isIsTrxNull()) {
				stmt.setNull( index++, java.sql.Types.INTEGER );
			} else {
				stmt.setShort( index++, dto.getIsTrx() );
			}
		
			if (dto.isEmpIdNull()) {
				stmt.setNull( index++, java.sql.Types.INTEGER );
			} else {
				stmt.setInt( index++, dto.getEmpId() );
			}
		
			System.out.println( "Executing " + SQL_INSERT + " with DTO: " + dto );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		
			// retrieve values from auto-increment columns
			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				dto.setId( rs.getInt( 1 ) );
			}
		
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new InvoicesDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the invoices table.
	 */
	public void update(InvoicesPk pk, Invoices dto) throws InvoicesDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			System.out.println( "Executing " + SQL_UPDATE + " with DTO: " + dto );
			stmt = conn.prepareStatement( SQL_UPDATE );
			int index=1;
			stmt.setInt( index++, dto.getId() );
			stmt.setDate(index++, dto.getDate()==null ? null : new java.sql.Date( dto.getDate().getTime() ) );
			stmt.setString( index++, dto.getGrandTotal() );
			if (dto.isBpIdNull()) {
				stmt.setNull( index++, java.sql.Types.INTEGER );
			} else {
				stmt.setInt( index++, dto.getBpId() );
			}
		
			if (dto.isIsTrxNull()) {
				stmt.setNull( index++, java.sql.Types.INTEGER );
			} else {
				stmt.setShort( index++, dto.getIsTrx() );
			}
		
			if (dto.isEmpIdNull()) {
				stmt.setNull( index++, java.sql.Types.INTEGER );
			} else {
				stmt.setInt( index++, dto.getEmpId() );
			}
		
			stmt.setInt( 7, pk.getId() );
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new InvoicesDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the invoices table.
	 */
	public void delete(InvoicesPk pk) throws InvoicesDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			System.out.println( "Executing " + SQL_DELETE + " with PK: " + pk );
			stmt = conn.prepareStatement( SQL_DELETE );
			stmt.setInt( 1, pk.getId() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new InvoicesDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the invoices table that matches the specified primary-key value.
	 */
	public Invoices findByPrimaryKey(InvoicesPk pk) throws InvoicesDaoException
	{
		return findByPrimaryKey( pk.getId() );
	}

	/** 
	 * Returns all rows from the invoices table that match the criteria 'id = :id'.
	 */
	public Invoices findByPrimaryKey(int id) throws InvoicesDaoException
	{
		Invoices ret[] = findByDynamicSelect( SQL_SELECT + " WHERE id = ?", new Object[] {  new Integer(id) } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the invoices table that match the criteria ''.
	 */
	public Invoices[] findAll() throws InvoicesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY id", null );
	}

	/** 
	 * Returns all rows from the invoices table that match the criteria 'emp_id = :empId'.
	 */
	public Invoices[] findByBusinessPartner(int empId) throws InvoicesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE emp_id = ?", new Object[] {  new Integer(empId) } );
	}

	/** 
	 * Returns all rows from the invoices table that match the criteria 'bp_id = :bpId'.
	 */
	public Invoices[] findByBusinessPartner2(int bpId) throws InvoicesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE bp_id = ?", new Object[] {  new Integer(bpId) } );
	}

	/** 
	 * Returns all rows from the invoices table that match the criteria 'id = :id'.
	 */
	public Invoices[] findWhereIdEquals(int id) throws InvoicesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE id = ? ORDER BY id", new Object[] {  new Integer(id) } );
	}

	/** 
	 * Returns all rows from the invoices table that match the criteria 'date = :date'.
	 */
	public Invoices[] findWhereDateEquals(Date date) throws InvoicesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE date = ? ORDER BY date", new Object[] { date==null ? null : new java.sql.Date( date.getTime() ) } );
	}

	/** 
	 * Returns all rows from the invoices table that match the criteria 'grand_total = :grandTotal'.
	 */
	public Invoices[] findWhereGrandTotalEquals(String grandTotal) throws InvoicesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE grand_total = ? ORDER BY grand_total", new Object[] { grandTotal } );
	}

	/** 
	 * Returns all rows from the invoices table that match the criteria 'bp_id = :bpId'.
	 */
	public Invoices[] findWhereBpIdEquals(int bpId) throws InvoicesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE bp_id = ? ORDER BY bp_id", new Object[] {  new Integer(bpId) } );
	}

	/** 
	 * Returns all rows from the invoices table that match the criteria 'is_trx = :isTrx'.
	 */
	public Invoices[] findWhereIsTrxEquals(short isTrx) throws InvoicesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE is_trx = ? ORDER BY is_trx", new Object[] {  new Short(isTrx) } );
	}

	/** 
	 * Returns all rows from the invoices table that match the criteria 'emp_id = :empId'.
	 */
	public Invoices[] findWhereEmpIdEquals(int empId) throws InvoicesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE emp_id = ? ORDER BY emp_id", new Object[] {  new Integer(empId) } );
	}

	/**
	 * Method 'InvoicesDaoImpl'
	 * 
	 */
	public InvoicesDaoImpl()
	{
	}

	/**
	 * Method 'InvoicesDaoImpl'
	 * 
	 * @param userConn
	 */
	public InvoicesDaoImpl(final java.sql.Connection userConn)
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
		return "fruits.invoices";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected Invoices fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			Invoices dto = new Invoices();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected Invoices[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			Invoices dto = new Invoices();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		Invoices ret[] = new Invoices[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(Invoices dto, ResultSet rs) throws SQLException
	{
		dto.setId( rs.getInt( COLUMN_ID ) );
		dto.setDate( rs.getDate(COLUMN_DATE ) );
		dto.setGrandTotal( rs.getString( COLUMN_GRAND_TOTAL ) );
		dto.setBpId( rs.getInt( COLUMN_BP_ID ) );
		if (rs.wasNull()) {
			dto.setBpIdNull( true );
		}
		
		dto.setIsTrx( rs.getShort( COLUMN_IS_TRX ) );
		if (rs.wasNull()) {
			dto.setIsTrxNull( true );
		}
		
		dto.setEmpId( rs.getInt( COLUMN_EMP_ID ) );
		if (rs.wasNull()) {
			dto.setEmpIdNull( true );
		}
		
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(Invoices dto)
	{
	}

	/** 
	 * Returns all rows from the invoices table that match the specified arbitrary SQL statement
	 */
	public Invoices[] findByDynamicSelect(String sql, Object[] sqlParams) throws InvoicesDaoException
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
			throw new InvoicesDaoException( "Exception: " + _e.getMessage(), _e );
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
	 * Returns all rows from the invoices table that match the specified arbitrary SQL statement
	 */
	public Invoices[] findByDynamicWhere(String sql, Object[] sqlParams) throws InvoicesDaoException
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
			throw new InvoicesDaoException( "Exception: " + _e.getMessage(), _e );
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