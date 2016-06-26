/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.app.dal.dao;

import com.app.dal.dto.*;
import com.app.dal.exceptions.*;

public interface ItemsDao
{
	/** 
	 * Inserts a new row in the items table.
	 */
	public ItemsPk insert(Items dto) throws ItemsDaoException;

	/** 
	 * Updates a single row in the items table.
	 */
	public void update(ItemsPk pk, Items dto) throws ItemsDaoException;

	/** 
	 * Deletes a single row in the items table.
	 */
	public void delete(ItemsPk pk) throws ItemsDaoException;

	/** 
	 * Returns the rows from the items table that matches the specified primary-key value.
	 */
	public Items findByPrimaryKey(ItemsPk pk) throws ItemsDaoException;

	/** 
	 * Returns all rows from the items table that match the criteria 'id = :id'.
	 */
	public Items findByPrimaryKey(int id) throws ItemsDaoException;

	/** 
	 * Returns all rows from the items table that match the criteria ''.
	 */
	public Items[] findAll() throws ItemsDaoException;

	/** 
	 * Returns all rows from the items table that match the criteria 'id = :id'.
	 */
	public Items[] findWhereIdEquals(int id) throws ItemsDaoException;

	/** 
	 * Returns all rows from the items table that match the criteria 'name = :name'.
	 */
	public Items[] findWhereNameEquals(String name) throws ItemsDaoException;

	/** 
	 * Returns all rows from the items table that match the criteria 'quantity = :quantity'.
	 */
	public Items[] findWhereQuantityEquals(double quantity) throws ItemsDaoException;

	/** 
	 * Returns all rows from the items table that match the criteria 'stock_id = :stockId'.
	 */
	public Items[] findWhereStockIdEquals(int stockId) throws ItemsDaoException;

	/** 
	 * Returns all rows from the items table that match the criteria 'code = :code'.
	 */
	public Items[] findWhereCodeEquals(String code) throws ItemsDaoException;

	/** 
	 * Returns all rows from the items table that match the criteria 'price = :price'.
	 */
	public Items[] findWherePriceEquals(double price) throws ItemsDaoException;

	/** 
	 * Returns all rows from the items table that match the criteria 'type = :type'.
	 */
	public Items[] findWhereTypeEquals(String type) throws ItemsDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the items table that match the specified arbitrary SQL statement
	 */
	public Items[] findByDynamicSelect(String sql, Object[] sqlParams) throws ItemsDaoException;

	/** 
	 * Returns all rows from the items table that match the specified arbitrary SQL statement
	 */
	public Items[] findByDynamicWhere(String sql, Object[] sqlParams) throws ItemsDaoException;

}