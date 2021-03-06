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

public class PattiLinesDaoImpl extends AbstractDAO implements PattiLinesDao
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
	protected final String SQL_SELECT = "SELECT id, code, avg_cost, avg_quantity, actual_cost, actual_quantity, patti_id, bp_id FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( id, code, avg_cost, avg_quantity, actual_cost, actual_quantity, patti_id, bp_id ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET id = ?, code = ?, avg_cost = ?, avg_quantity = ?, actual_cost = ?, actual_quantity = ?, patti_id = ?, bp_id = ? WHERE id = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE id = ?";

	/** 
	 * Index of column id
	 */
	protected static final int COLUMN_ID = 1;

	/** 
	 * Index of column code
	 */
	protected static final int COLUMN_CODE = 2;

	/** 
	 * Index of column avg_cost
	 */
	protected static final int COLUMN_AVG_COST = 3;

	/** 
	 * Index of column avg_quantity
	 */
	protected static final int COLUMN_AVG_QUANTITY = 4;

	/** 
	 * Index of column actual_cost
	 */
	protected static final int COLUMN_ACTUAL_COST = 5;

	/** 
	 * Index of column actual_quantity
	 */
	protected static final int COLUMN_ACTUAL_QUANTITY = 6;

	/** 
	 * Index of column patti_id
	 */
	protected static final int COLUMN_PATTI_ID = 7;

	/** 
	 * Index of column bp_id
	 */
	protected static final int COLUMN_BP_ID = 8;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 8;

	/** 
	 * Index of primary-key column id
	 */
	protected static final int PK_COLUMN_ID = 1;

	/** 
	 * Inserts a new row in the patti_lines table.
	 */
	public PattiLinesPk insert(PattiLines dto) throws PattiLinesDaoException
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
			stmt.setString( index++, dto.getCode() );
			if (dto.isAvgCostNull()) {
				stmt.setNull( index++, java.sql.Types.DOUBLE );
			} else {
				stmt.setDouble( index++, dto.getAvgCost() );
			}
		
			if (dto.isAvgQuantityNull()) {
				stmt.setNull( index++, java.sql.Types.INTEGER );
			} else {
				stmt.setInt( index++, dto.getAvgQuantity() );
			}
		
			if (dto.isActualCostNull()) {
				stmt.setNull( index++, java.sql.Types.DOUBLE );
			} else {
				stmt.setDouble( index++, dto.getActualCost() );
			}
		
			if (dto.isActualQuantityNull()) {
				stmt.setNull( index++, java.sql.Types.INTEGER );
			} else {
				stmt.setInt( index++, dto.getActualQuantity() );
			}
		
			if (dto.isPattiIdNull()) {
				stmt.setNull( index++, java.sql.Types.INTEGER );
			} else {
				stmt.setInt( index++, dto.getPattiId() );
			}
		
			if (dto.isBpIdNull()) {
				stmt.setNull( index++, java.sql.Types.INTEGER );
			} else {
				stmt.setInt( index++, dto.getBpId() );
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
			throw new PattiLinesDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the patti_lines table.
	 */
	public void update(PattiLinesPk pk, PattiLines dto) throws PattiLinesDaoException
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
			stmt.setString( index++, dto.getCode() );
			if (dto.isAvgCostNull()) {
				stmt.setNull( index++, java.sql.Types.DOUBLE );
			} else {
				stmt.setDouble( index++, dto.getAvgCost() );
			}
		
			if (dto.isAvgQuantityNull()) {
				stmt.setNull( index++, java.sql.Types.INTEGER );
			} else {
				stmt.setInt( index++, dto.getAvgQuantity() );
			}
		
			if (dto.isActualCostNull()) {
				stmt.setNull( index++, java.sql.Types.DOUBLE );
			} else {
				stmt.setDouble( index++, dto.getActualCost() );
			}
		
			if (dto.isActualQuantityNull()) {
				stmt.setNull( index++, java.sql.Types.INTEGER );
			} else {
				stmt.setInt( index++, dto.getActualQuantity() );
			}
		
			if (dto.isPattiIdNull()) {
				stmt.setNull( index++, java.sql.Types.INTEGER );
			} else {
				stmt.setInt( index++, dto.getPattiId() );
			}
		
			if (dto.isBpIdNull()) {
				stmt.setNull( index++, java.sql.Types.INTEGER );
			} else {
				stmt.setInt( index++, dto.getBpId() );
			}
		
			stmt.setInt( 9, pk.getId() );
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new PattiLinesDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the patti_lines table.
	 */
	public void delete(PattiLinesPk pk) throws PattiLinesDaoException
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
			throw new PattiLinesDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the patti_lines table that matches the specified primary-key value.
	 */
	public PattiLines findByPrimaryKey(PattiLinesPk pk) throws PattiLinesDaoException
	{
		return findByPrimaryKey( pk.getId() );
	}

	/** 
	 * Returns all rows from the patti_lines table that match the criteria 'id = :id'.
	 */
	public PattiLines findByPrimaryKey(int id) throws PattiLinesDaoException
	{
		PattiLines ret[] = findByDynamicSelect( SQL_SELECT + " WHERE id = ?", new Object[] {  new Integer(id) } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the patti_lines table that match the criteria ''.
	 */
	public PattiLines[] findAll() throws PattiLinesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY id", null );
	}

	/** 
	 * Returns all rows from the patti_lines table that match the criteria 'patti_id = :pattiId'.
	 */
	public PattiLines[] findByPatti(int pattiId) throws PattiLinesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE patti_id = ?", new Object[] {  new Integer(pattiId) } );
	}

	/** 
	 * Returns all rows from the patti_lines table that match the criteria 'id = :id'.
	 */
	public PattiLines[] findWhereIdEquals(int id) throws PattiLinesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE id = ? ORDER BY id", new Object[] {  new Integer(id) } );
	}

	/** 
	 * Returns all rows from the patti_lines table that match the criteria 'code = :code'.
	 */
	public PattiLines[] findWhereCodeEquals(String code) throws PattiLinesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE code = ? ORDER BY code", new Object[] { code } );
	}

	/** 
	 * Returns all rows from the patti_lines table that match the criteria 'avg_cost = :avgCost'.
	 */
	public PattiLines[] findWhereAvgCostEquals(double avgCost) throws PattiLinesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE avg_cost = ? ORDER BY avg_cost", new Object[] {  new Double(avgCost) } );
	}

	/** 
	 * Returns all rows from the patti_lines table that match the criteria 'avg_quantity = :avgQuantity'.
	 */
	public PattiLines[] findWhereAvgQuantityEquals(int avgQuantity) throws PattiLinesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE avg_quantity = ? ORDER BY avg_quantity", new Object[] {  new Integer(avgQuantity) } );
	}

	/** 
	 * Returns all rows from the patti_lines table that match the criteria 'actual_cost = :actualCost'.
	 */
	public PattiLines[] findWhereActualCostEquals(double actualCost) throws PattiLinesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE actual_cost = ? ORDER BY actual_cost", new Object[] {  new Double(actualCost) } );
	}

	/** 
	 * Returns all rows from the patti_lines table that match the criteria 'actual_quantity = :actualQuantity'.
	 */
	public PattiLines[] findWhereActualQuantityEquals(int actualQuantity) throws PattiLinesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE actual_quantity = ? ORDER BY actual_quantity", new Object[] {  new Integer(actualQuantity) } );
	}

	/** 
	 * Returns all rows from the patti_lines table that match the criteria 'patti_id = :pattiId'.
	 */
	public PattiLines[] findWherePattiIdEquals(int pattiId) throws PattiLinesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE patti_id = ? ORDER BY patti_id", new Object[] {  new Integer(pattiId) } );
	}

	/** 
	 * Returns all rows from the patti_lines table that match the criteria 'bp_id = :bpId'.
	 */
	public PattiLines[] findWhereBpIdEquals(int bpId) throws PattiLinesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE bp_id = ? ORDER BY bp_id", new Object[] {  new Integer(bpId) } );
	}

	/**
	 * Method 'PattiLinesDaoImpl'
	 * 
	 */
	public PattiLinesDaoImpl()
	{
	}

	/**
	 * Method 'PattiLinesDaoImpl'
	 * 
	 * @param userConn
	 */
	public PattiLinesDaoImpl(final java.sql.Connection userConn)
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
		return "fruits.patti_lines";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected PattiLines fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			PattiLines dto = new PattiLines();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected PattiLines[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			PattiLines dto = new PattiLines();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		PattiLines ret[] = new PattiLines[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(PattiLines dto, ResultSet rs) throws SQLException
	{
		dto.setId( rs.getInt( COLUMN_ID ) );
		dto.setCode( rs.getString( COLUMN_CODE ) );
		dto.setAvgCost( rs.getDouble( COLUMN_AVG_COST ) );
		if (rs.wasNull()) {
			dto.setAvgCostNull( true );
		}
		
		dto.setAvgQuantity( rs.getInt( COLUMN_AVG_QUANTITY ) );
		if (rs.wasNull()) {
			dto.setAvgQuantityNull( true );
		}
		
		dto.setActualCost( rs.getDouble( COLUMN_ACTUAL_COST ) );
		if (rs.wasNull()) {
			dto.setActualCostNull( true );
		}
		
		dto.setActualQuantity( rs.getInt( COLUMN_ACTUAL_QUANTITY ) );
		if (rs.wasNull()) {
			dto.setActualQuantityNull( true );
		}
		
		dto.setPattiId( rs.getInt( COLUMN_PATTI_ID ) );
		if (rs.wasNull()) {
			dto.setPattiIdNull( true );
		}
		
		dto.setBpId( rs.getInt( COLUMN_BP_ID ) );
		if (rs.wasNull()) {
			dto.setBpIdNull( true );
		}
		
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(PattiLines dto)
	{
	}

	/** 
	 * Returns all rows from the patti_lines table that match the specified arbitrary SQL statement
	 */
	public PattiLines[] findByDynamicSelect(String sql, Object[] sqlParams) throws PattiLinesDaoException
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
			throw new PattiLinesDaoException( "Exception: " + _e.getMessage(), _e );
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
	 * Returns all rows from the patti_lines table that match the specified arbitrary SQL statement
	 */
	public PattiLines[] findByDynamicWhere(String sql, Object[] sqlParams) throws PattiLinesDaoException
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
			throw new PattiLinesDaoException( "Exception: " + _e.getMessage(), _e );
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
