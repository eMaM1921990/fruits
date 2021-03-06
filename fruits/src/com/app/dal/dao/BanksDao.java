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

public interface BanksDao
{
	/** 
	 * Inserts a new row in the banks table.
	 */
	public BanksPk insert(Banks dto) throws BanksDaoException;

	/** 
	 * Updates a single row in the banks table.
	 */
	public void update(BanksPk pk, Banks dto) throws BanksDaoException;

	/** 
	 * Deletes a single row in the banks table.
	 */
	public void delete(BanksPk pk) throws BanksDaoException;

	/** 
	 * Returns the rows from the banks table that matches the specified primary-key value.
	 */
	public Banks findByPrimaryKey(BanksPk pk) throws BanksDaoException;

	/** 
	 * Returns all rows from the banks table that match the criteria 'id = :id'.
	 */
	public Banks findByPrimaryKey(int id) throws BanksDaoException;

	/** 
	 * Returns all rows from the banks table that match the criteria ''.
	 */
	public Banks[] findAll() throws BanksDaoException;

	/** 
	 * Returns all rows from the banks table that match the criteria 'id = :id'.
	 */
	public Banks[] findWhereIdEquals(int id) throws BanksDaoException;

	/** 
	 * Returns all rows from the banks table that match the criteria 'bank_name = :bankName'.
	 */
	public Banks[] findWhereBankNameEquals(String bankName) throws BanksDaoException;

	/** 
	 * Returns all rows from the banks table that match the criteria 'account_number = :accountNumber'.
	 */
	public Banks[] findWhereAccountNumberEquals(String accountNumber) throws BanksDaoException;

	/** 
	 * Returns all rows from the banks table that match the criteria 'branch = :branch'.
	 */
	public Banks[] findWhereBranchEquals(String branch) throws BanksDaoException;

	/** 
	 * Returns all rows from the banks table that match the criteria 'bp_id = :bpId'.
	 */
	public Banks[] findWhereBpIdEquals(int bpId) throws BanksDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the banks table that match the specified arbitrary SQL statement
	 */
	public Banks[] findByDynamicSelect(String sql, Object[] sqlParams) throws BanksDaoException;

	/** 
	 * Returns all rows from the banks table that match the specified arbitrary SQL statement
	 */
	public Banks[] findByDynamicWhere(String sql, Object[] sqlParams) throws BanksDaoException;

}
