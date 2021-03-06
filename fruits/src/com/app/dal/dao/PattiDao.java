/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.app.dal.dao;

import java.util.Date;
import com.app.dal.dto.*;
import com.app.dal.exceptions.*;

public interface PattiDao
{
	/** 
	 * Inserts a new row in the patti table.
	 */
	public PattiPk insert(Patti dto) throws PattiDaoException;

	/** 
	 * Updates a single row in the patti table.
	 */
	public void update(PattiPk pk, Patti dto) throws PattiDaoException;

	/** 
	 * Deletes a single row in the patti table.
	 */
	public void delete(PattiPk pk) throws PattiDaoException;

	/** 
	 * Returns the rows from the patti table that matches the specified primary-key value.
	 */
	public Patti findByPrimaryKey(PattiPk pk) throws PattiDaoException;

	/** 
	 * Returns all rows from the patti table that match the criteria 'id = :id'.
	 */
	public Patti findByPrimaryKey(int id) throws PattiDaoException;

	/** 
	 * Returns all rows from the patti table that match the criteria ''.
	 */
	public Patti[] findAll() throws PattiDaoException;

	/** 
	 * Returns all rows from the patti table that match the criteria 'id = :id'.
	 */
	public Patti[] findWhereIdEquals(int id) throws PattiDaoException;

	/** 
	 * Returns all rows from the patti table that match the criteria 'patti_date = :pattiDate'.
	 */
	public Patti[] findWherePattiDateEquals(Date pattiDate) throws PattiDaoException;

	/** 
	 * Returns all rows from the patti table that match the criteria 'commission__percent = :commissionPercent'.
	 */
	public Patti[] findWhereCommissionPercentEquals(double commissionPercent) throws PattiDaoException;

	/** 
	 * Returns all rows from the patti table that match the criteria 'loory = :loory'.
	 */
	public Patti[] findWhereLooryEquals(double loory) throws PattiDaoException;

	/** 
	 * Returns all rows from the patti table that match the criteria 'cooli = :cooli'.
	 */
	public Patti[] findWhereCooliEquals(double cooli) throws PattiDaoException;

	/** 
	 * Returns all rows from the patti table that match the criteria 'subtotal = :subtotal'.
	 */
	public Patti[] findWhereSubtotalEquals(double subtotal) throws PattiDaoException;

	/** 
	 * Returns all rows from the patti table that match the criteria 'total = :total'.
	 */
	public Patti[] findWhereTotalEquals(double total) throws PattiDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the patti table that match the specified arbitrary SQL statement
	 */
	public Patti[] findByDynamicSelect(String sql, Object[] sqlParams) throws PattiDaoException;

	/** 
	 * Returns all rows from the patti table that match the specified arbitrary SQL statement
	 */
	public Patti[] findByDynamicWhere(String sql, Object[] sqlParams) throws PattiDaoException;

}
