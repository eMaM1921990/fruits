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

public interface LoansDao
{
	/** 
	 * Inserts a new row in the loans table.
	 */
	public LoansPk insert(Loans dto) throws LoansDaoException;

	/** 
	 * Updates a single row in the loans table.
	 */
	public void update(LoansPk pk, Loans dto) throws LoansDaoException;

	/** 
	 * Deletes a single row in the loans table.
	 */
	public void delete(LoansPk pk) throws LoansDaoException;

	/** 
	 * Returns the rows from the loans table that matches the specified primary-key value.
	 */
	public Loans findByPrimaryKey(LoansPk pk) throws LoansDaoException;

	/** 
	 * Returns all rows from the loans table that match the criteria 'id = :id'.
	 */
	public Loans findByPrimaryKey(int id) throws LoansDaoException;

	/** 
	 * Returns all rows from the loans table that match the criteria 'dr = :dr'.
	 */
	public Loans[] findWhereDrEquals(String dr) throws LoansDaoException;

	/** 
	 * Returns all rows from the loans table that match the criteria 'loanscol = :loanscol'.
	 */
	public Loans[] findWhereLoanscolEquals(String loanscol) throws LoansDaoException;

	/** 
	 * Returns all rows from the loans table that match the criteria ''.
	 */
	public Loans[] findAll() throws LoansDaoException;

	/** 
	 * Returns all rows from the loans table that match the criteria 'bp_id = :bpId'.
	 */
	public Loans[] findWhereBpIdEquals(int bpId) throws LoansDaoException;

	/** 
	 * Returns all rows from the loans table that match the criteria 'need_to_pay = :needToPay'.
	 */
	public Loans[] findWhereNeedToPayEquals(double needToPay) throws LoansDaoException;

	/** 
	 * Returns all rows from the loans table that match the criteria 'paid = :paid'.
	 */
	public Loans[] findWherePaidEquals(double paid) throws LoansDaoException;

	/** 
	 * Returns all rows from the loans table that match the criteria 'pay_date = :payDate'.
	 */
	public Loans[] findWherePayDateEquals(Date payDate) throws LoansDaoException;

	/** 
	 * Returns all rows from the loans table that match the criteria 'id = :id'.
	 */
	public Loans[] findWhereIdEquals(int id) throws LoansDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the loans table that match the specified arbitrary SQL statement
	 */
	public Loans[] findByDynamicSelect(String sql, Object[] sqlParams) throws LoansDaoException;

	/** 
	 * Returns all rows from the loans table that match the specified arbitrary SQL statement
	 */
	public Loans[] findByDynamicWhere(String sql, Object[] sqlParams) throws LoansDaoException;

}
