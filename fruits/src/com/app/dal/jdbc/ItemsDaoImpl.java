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

public class ItemsDaoImpl extends AbstractDAO implements ItemsDao
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
	protected final String SQL_SELECT = "SELECT id, name, quantity, stock_id, code, price, type, bpId FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( id, name, quantity, stock_id, code, price, type, bpId ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET id = ?, name = ?, quantity = ?, stock_id = ?, code = ?, price = ?, type = ?, bpId = ? WHERE id = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE id = ?";

	/** 
	 * Index of column id
	 */
	protected static final int COLUMN_ID = 1;

	/** 
	 * Index of column name
	 */
	protected static final int COLUMN_NAME = 2;

	/** 
	 * Index of column quantity
	 */
	protected static final int COLUMN_QUANTITY = 3;

	/** 
	 * Index of column stock_id
	 */
	protected static final int COLUMN_STOCK_ID = 4;

	/** 
	 * Index of column code
	 */
	protected static final int COLUMN_CODE = 5;

	/** 
	 * Index of column price
	 */
	protected static final int COLUMN_PRICE = 6;

	/** 
	 * Index of column type
	 */
	protected static final int COLUMN_TYPE = 7;

	/** 
	 * Index of column bpId
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
	 * Inserts a new row in the items table.
	 */
	public ItemsPk insert(Items dto) throws ItemsDaoException
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
			stmt.setString( index++, dto.getName() );
			if (dto.isQuantityNull()) {
				stmt.setNull( index++, java.sql.Types.DOUBLE );
			} else {
				stmt.setDouble( index++, dto.getQuantity() );
			}
		
			if (dto.isStockIdNull()) {
				stmt.setNull( index++, java.sql.Types.INTEGER );
			} else {
				stmt.setInt( index++, dto.getStockId() );
			}
		
			stmt.setString( index++, dto.getCode() );
			if (dto.isPriceNull()) {
				stmt.setNull( index++, java.sql.Types.DOUBLE );
			} else {
				stmt.setDouble( index++, dto.getPrice() );
			}
		
			stmt.setString( index++, dto.getType() );
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
			throw new ItemsDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the items table.
	 */
	public void update(ItemsPk pk, Items dto) throws ItemsDaoException
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
			stmt.setString( index++, dto.getName() );
			if (dto.isQuantityNull()) {
				stmt.setNull( index++, java.sql.Types.DOUBLE );
			} else {
				stmt.setDouble( index++, dto.getQuantity() );
			}
		
			if (dto.isStockIdNull()) {
				stmt.setNull( index++, java.sql.Types.INTEGER );
			} else {
				stmt.setInt( index++, dto.getStockId() );
			}
		
			stmt.setString( index++, dto.getCode() );
			if (dto.isPriceNull()) {
				stmt.setNull( index++, java.sql.Types.DOUBLE );
			} else {
				stmt.setDouble( index++, dto.getPrice() );
			}
		
			stmt.setString( index++, dto.getType() );
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
			throw new ItemsDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the items table.
	 */
	public void delete(ItemsPk pk) throws ItemsDaoException
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
			throw new ItemsDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the items table that matches the specified primary-key value.
	 */
	public Items findByPrimaryKey(ItemsPk pk) throws ItemsDaoException
	{
		return findByPrimaryKey( pk.getId() );
	}

	/** 
	 * Returns all rows from the items table that match the criteria 'id = :id'.
	 */
	public Items findByPrimaryKey(int id) throws ItemsDaoException
	{
		Items ret[] = findByDynamicSelect( SQL_SELECT + " WHERE id = ?", new Object[] {  new Integer(id) } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the items table that match the criteria ''.
	 */
	public Items[] findAll() throws ItemsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY id", null );
	}

	/** 
	 * Returns all rows from the items table that match the criteria 'id = :id'.
	 */
	public Items[] findWhereIdEquals(int id) throws ItemsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE id = ? ORDER BY id", new Object[] {  new Integer(id) } );
	}

	/** 
	 * Returns all rows from the items table that match the criteria 'name = :name'.
	 */
	public Items[] findWhereNameEquals(String name) throws ItemsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE name = ? ORDER BY name", new Object[] { name } );
	}

	/** 
	 * Returns all rows from the items table that match the criteria 'quantity = :quantity'.
	 */
	public Items[] findWhereQuantityEquals(double quantity) throws ItemsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE quantity = ? ORDER BY quantity", new Object[] {  new Double(quantity) } );
	}

	/** 
	 * Returns all rows from the items table that match the criteria 'stock_id = :stockId'.
	 */
	public Items[] findWhereStockIdEquals(int stockId) throws ItemsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE stock_id = ? ORDER BY stock_id", new Object[] {  new Integer(stockId) } );
	}

	/** 
	 * Returns all rows from the items table that match the criteria 'code = :code'.
	 */
	public Items[] findWhereCodeEquals(String code) throws ItemsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE code = ? ORDER BY code", new Object[] { code } );
	}

	/** 
	 * Returns all rows from the items table that match the criteria 'price = :price'.
	 */
	public Items[] findWherePriceEquals(double price) throws ItemsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE price = ? ORDER BY price", new Object[] {  new Double(price) } );
	}

	/** 
	 * Returns all rows from the items table that match the criteria 'type = :type'.
	 */
	public Items[] findWhereTypeEquals(String type) throws ItemsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE type = ? ORDER BY type", new Object[] { type } );
	}

	/** 
	 * Returns all rows from the items table that match the criteria 'bpId = :bpId'.
	 */
	public Items[] findWhereBpIdEquals(int bpId) throws ItemsDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE bpId = ? ORDER BY bpId", new Object[] {  new Integer(bpId) } );
	}

	/**
	 * Method 'ItemsDaoImpl'
	 * 
	 */
	public ItemsDaoImpl()
	{
	}

	/**
	 * Method 'ItemsDaoImpl'
	 * 
	 * @param userConn
	 */
	public ItemsDaoImpl(final java.sql.Connection userConn)
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
		return "fruits.items";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected Items fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			Items dto = new Items();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected Items[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			Items dto = new Items();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		Items ret[] = new Items[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(Items dto, ResultSet rs) throws SQLException
	{
		dto.setId( rs.getInt( COLUMN_ID ) );
		dto.setName( rs.getString( COLUMN_NAME ) );
		dto.setQuantity( rs.getDouble( COLUMN_QUANTITY ) );
		if (rs.wasNull()) {
			dto.setQuantityNull( true );
		}
		
		dto.setStockId( rs.getInt( COLUMN_STOCK_ID ) );
		if (rs.wasNull()) {
			dto.setStockIdNull( true );
		}
		
		dto.setCode( rs.getString( COLUMN_CODE ) );
		dto.setPrice( rs.getDouble( COLUMN_PRICE ) );
		if (rs.wasNull()) {
			dto.setPriceNull( true );
		}
		
		dto.setType( rs.getString( COLUMN_TYPE ) );
		dto.setBpId( rs.getInt( COLUMN_BP_ID ) );
		if (rs.wasNull()) {
			dto.setBpIdNull( true );
		}
		
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(Items dto)
	{
	}

	/** 
	 * Returns all rows from the items table that match the specified arbitrary SQL statement
	 */
	public Items[] findByDynamicSelect(String sql, Object[] sqlParams) throws ItemsDaoException
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
			throw new ItemsDaoException( "Exception: " + _e.getMessage(), _e );
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
	 * Returns all rows from the items table that match the specified arbitrary SQL statement
	 */
	public Items[] findByDynamicWhere(String sql, Object[] sqlParams) throws ItemsDaoException
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
			throw new ItemsDaoException( "Exception: " + _e.getMessage(), _e );
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
