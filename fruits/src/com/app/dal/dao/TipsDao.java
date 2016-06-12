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

public interface TipsDao
{
	/** 
	 * Inserts a new row in the tips table.
	 */
	public TipsPk insert(Tips dto) throws TipsDaoException;

	/** 
	 * Updates a single row in the tips table.
	 */
	public void update(TipsPk pk, Tips dto) throws TipsDaoException;

	/** 
	 * Deletes a single row in the tips table.
	 */
	public void delete(TipsPk pk) throws TipsDaoException;

	/** 
	 * Returns the rows from the tips table that matches the specified primary-key value.
	 */
	public Tips findByPrimaryKey(TipsPk pk) throws TipsDaoException;

	/** 
	 * Returns all rows from the tips table that match the criteria 'id = :id'.
	 */
	public Tips findByPrimaryKey(int id) throws TipsDaoException;

	/** 
	 * Returns all rows from the tips table that match the criteria ''.
	 */
	public Tips[] findAll() throws TipsDaoException;

	/** 
	 * Returns all rows from the tips table that match the criteria 'id = :id'.
	 */
	public Tips[] findWhereIdEquals(int id) throws TipsDaoException;

	/** 
	 * Returns all rows from the tips table that match the criteria 'bp_id = :bpId'.
	 */
	public Tips[] findWhereBpIdEquals(int bpId) throws TipsDaoException;

	/** 
	 * Returns all rows from the tips table that match the criteria 'amount_type = :amountType'.
	 */
	public Tips[] findWhereAmountTypeEquals(String amountType) throws TipsDaoException;

	/** 
	 * Returns all rows from the tips table that match the criteria 'item_name = :itemName'.
	 */
	public Tips[] findWhereItemNameEquals(String itemName) throws TipsDaoException;

	/** 
	 * Returns all rows from the tips table that match the criteria 'tips_type = :tipsType'.
	 */
	public Tips[] findWhereTipsTypeEquals(String tipsType) throws TipsDaoException;

	/** 
	 * Returns all rows from the tips table that match the criteria 'worth = :worth'.
	 */
	public Tips[] findWhereWorthEquals(double worth) throws TipsDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the tips table that match the specified arbitrary SQL statement
	 */
	public Tips[] findByDynamicSelect(String sql, Object[] sqlParams) throws TipsDaoException;

	/** 
	 * Returns all rows from the tips table that match the specified arbitrary SQL statement
	 */
	public Tips[] findByDynamicWhere(String sql, Object[] sqlParams) throws TipsDaoException;

}
