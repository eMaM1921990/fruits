/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.app.dal.dto;

import com.app.dal.dao.*;
import com.app.dal.factory.*;
import com.app.dal.exceptions.*;
import java.io.Serializable;
import java.util.*;

public class PattiLines implements Serializable
{
	/** 
	 * This attribute maps to the column id in the patti_lines table.
	 */
	protected int id;

	/** 
	 * This attribute maps to the column code in the patti_lines table.
	 */
	protected String code;

	/** 
	 * This attribute maps to the column avg_cost in the patti_lines table.
	 */
	protected double avgCost;

	/** 
	 * This attribute represents whether the primitive attribute avgCost is null.
	 */
	protected boolean avgCostNull = true;

	/** 
	 * This attribute maps to the column avg_quantity in the patti_lines table.
	 */
	protected int avgQuantity;

	/** 
	 * This attribute represents whether the primitive attribute avgQuantity is null.
	 */
	protected boolean avgQuantityNull = true;

	/** 
	 * This attribute maps to the column actual_cost in the patti_lines table.
	 */
	protected double actualCost;

	/** 
	 * This attribute represents whether the primitive attribute actualCost is null.
	 */
	protected boolean actualCostNull = true;

	/** 
	 * This attribute maps to the column actual_quantity in the patti_lines table.
	 */
	protected int actualQuantity;

	/** 
	 * This attribute represents whether the primitive attribute actualQuantity is null.
	 */
	protected boolean actualQuantityNull = true;

	/** 
	 * This attribute maps to the column commission_percent in the patti_lines table.
	 */
	protected double commissionPercent;

	/** 
	 * This attribute represents whether the primitive attribute commissionPercent is null.
	 */
	protected boolean commissionPercentNull = true;

	/** 
	 * This attribute maps to the column loory in the patti_lines table.
	 */
	protected double loory;

	/** 
	 * This attribute represents whether the primitive attribute loory is null.
	 */
	protected boolean looryNull = true;

	/** 
	 * This attribute maps to the column cooli in the patti_lines table.
	 */
	protected double cooli;

	/** 
	 * This attribute represents whether the primitive attribute cooli is null.
	 */
	protected boolean cooliNull = true;

	/** 
	 * This attribute maps to the column patti_id in the patti_lines table.
	 */
	protected int pattiId;

	/** 
	 * This attribute represents whether the primitive attribute pattiId is null.
	 */
	protected boolean pattiIdNull = true;

	/** 
	 * This attribute maps to the column balance in the patti_lines table.
	 */
	protected double balance;

	/** 
	 * This attribute represents whether the primitive attribute balance is null.
	 */
	protected boolean balanceNull = true;

	/** 
	 * This attribute maps to the column bp_id in the patti_lines table.
	 */
	protected int bpId;

	/** 
	 * This attribute represents whether the primitive attribute bpId is null.
	 */
	protected boolean bpIdNull = true;

	/**
	 * Method 'PattiLines'
	 * 
	 */
	public PattiLines()
	{
	}

	/**
	 * Method 'getId'
	 * 
	 * @return int
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * Method 'setId'
	 * 
	 * @param id
	 */
	public void setId(int id)
	{
		this.id = id;
	}

	/**
	 * Method 'getCode'
	 * 
	 * @return String
	 */
	public String getCode()
	{
		return code;
	}

	/**
	 * Method 'setCode'
	 * 
	 * @param code
	 */
	public void setCode(String code)
	{
		this.code = code;
	}

	/**
	 * Method 'getAvgCost'
	 * 
	 * @return double
	 */
	public double getAvgCost()
	{
		return avgCost;
	}

	/**
	 * Method 'setAvgCost'
	 * 
	 * @param avgCost
	 */
	public void setAvgCost(double avgCost)
	{
		this.avgCost = avgCost;
		this.avgCostNull = false;
	}

	/**
	 * Method 'setAvgCostNull'
	 * 
	 * @param value
	 */
	public void setAvgCostNull(boolean value)
	{
		this.avgCostNull = value;
	}

	/**
	 * Method 'isAvgCostNull'
	 * 
	 * @return boolean
	 */
	public boolean isAvgCostNull()
	{
		return avgCostNull;
	}

	/**
	 * Method 'getAvgQuantity'
	 * 
	 * @return int
	 */
	public int getAvgQuantity()
	{
		return avgQuantity;
	}

	/**
	 * Method 'setAvgQuantity'
	 * 
	 * @param avgQuantity
	 */
	public void setAvgQuantity(int avgQuantity)
	{
		this.avgQuantity = avgQuantity;
		this.avgQuantityNull = false;
	}

	/**
	 * Method 'setAvgQuantityNull'
	 * 
	 * @param value
	 */
	public void setAvgQuantityNull(boolean value)
	{
		this.avgQuantityNull = value;
	}

	/**
	 * Method 'isAvgQuantityNull'
	 * 
	 * @return boolean
	 */
	public boolean isAvgQuantityNull()
	{
		return avgQuantityNull;
	}

	/**
	 * Method 'getActualCost'
	 * 
	 * @return double
	 */
	public double getActualCost()
	{
		return actualCost;
	}

	/**
	 * Method 'setActualCost'
	 * 
	 * @param actualCost
	 */
	public void setActualCost(double actualCost)
	{
		this.actualCost = actualCost;
		this.actualCostNull = false;
	}

	/**
	 * Method 'setActualCostNull'
	 * 
	 * @param value
	 */
	public void setActualCostNull(boolean value)
	{
		this.actualCostNull = value;
	}

	/**
	 * Method 'isActualCostNull'
	 * 
	 * @return boolean
	 */
	public boolean isActualCostNull()
	{
		return actualCostNull;
	}

	/**
	 * Method 'getActualQuantity'
	 * 
	 * @return int
	 */
	public int getActualQuantity()
	{
		return actualQuantity;
	}

	/**
	 * Method 'setActualQuantity'
	 * 
	 * @param actualQuantity
	 */
	public void setActualQuantity(int actualQuantity)
	{
		this.actualQuantity = actualQuantity;
		this.actualQuantityNull = false;
	}

	/**
	 * Method 'setActualQuantityNull'
	 * 
	 * @param value
	 */
	public void setActualQuantityNull(boolean value)
	{
		this.actualQuantityNull = value;
	}

	/**
	 * Method 'isActualQuantityNull'
	 * 
	 * @return boolean
	 */
	public boolean isActualQuantityNull()
	{
		return actualQuantityNull;
	}

	/**
	 * Method 'getCommissionPercent'
	 * 
	 * @return double
	 */
	public double getCommissionPercent()
	{
		return commissionPercent;
	}

	/**
	 * Method 'setCommissionPercent'
	 * 
	 * @param commissionPercent
	 */
	public void setCommissionPercent(double commissionPercent)
	{
		this.commissionPercent = commissionPercent;
		this.commissionPercentNull = false;
	}

	/**
	 * Method 'setCommissionPercentNull'
	 * 
	 * @param value
	 */
	public void setCommissionPercentNull(boolean value)
	{
		this.commissionPercentNull = value;
	}

	/**
	 * Method 'isCommissionPercentNull'
	 * 
	 * @return boolean
	 */
	public boolean isCommissionPercentNull()
	{
		return commissionPercentNull;
	}

	/**
	 * Method 'getLoory'
	 * 
	 * @return double
	 */
	public double getLoory()
	{
		return loory;
	}

	/**
	 * Method 'setLoory'
	 * 
	 * @param loory
	 */
	public void setLoory(double loory)
	{
		this.loory = loory;
		this.looryNull = false;
	}

	/**
	 * Method 'setLooryNull'
	 * 
	 * @param value
	 */
	public void setLooryNull(boolean value)
	{
		this.looryNull = value;
	}

	/**
	 * Method 'isLooryNull'
	 * 
	 * @return boolean
	 */
	public boolean isLooryNull()
	{
		return looryNull;
	}

	/**
	 * Method 'getCooli'
	 * 
	 * @return double
	 */
	public double getCooli()
	{
		return cooli;
	}

	/**
	 * Method 'setCooli'
	 * 
	 * @param cooli
	 */
	public void setCooli(double cooli)
	{
		this.cooli = cooli;
		this.cooliNull = false;
	}

	/**
	 * Method 'setCooliNull'
	 * 
	 * @param value
	 */
	public void setCooliNull(boolean value)
	{
		this.cooliNull = value;
	}

	/**
	 * Method 'isCooliNull'
	 * 
	 * @return boolean
	 */
	public boolean isCooliNull()
	{
		return cooliNull;
	}

	/**
	 * Method 'getPattiId'
	 * 
	 * @return int
	 */
	public int getPattiId()
	{
		return pattiId;
	}

	/**
	 * Method 'setPattiId'
	 * 
	 * @param pattiId
	 */
	public void setPattiId(int pattiId)
	{
		this.pattiId = pattiId;
		this.pattiIdNull = false;
	}

	/**
	 * Method 'setPattiIdNull'
	 * 
	 * @param value
	 */
	public void setPattiIdNull(boolean value)
	{
		this.pattiIdNull = value;
	}

	/**
	 * Method 'isPattiIdNull'
	 * 
	 * @return boolean
	 */
	public boolean isPattiIdNull()
	{
		return pattiIdNull;
	}

	/**
	 * Method 'getBalance'
	 * 
	 * @return double
	 */
	public double getBalance()
	{
		return balance;
	}

	/**
	 * Method 'setBalance'
	 * 
	 * @param balance
	 */
	public void setBalance(double balance)
	{
		this.balance = balance;
		this.balanceNull = false;
	}

	/**
	 * Method 'setBalanceNull'
	 * 
	 * @param value
	 */
	public void setBalanceNull(boolean value)
	{
		this.balanceNull = value;
	}

	/**
	 * Method 'isBalanceNull'
	 * 
	 * @return boolean
	 */
	public boolean isBalanceNull()
	{
		return balanceNull;
	}

	/**
	 * Method 'getBpId'
	 * 
	 * @return int
	 */
	public int getBpId()
	{
		return bpId;
	}

	/**
	 * Method 'setBpId'
	 * 
	 * @param bpId
	 */
	public void setBpId(int bpId)
	{
		this.bpId = bpId;
		this.bpIdNull = false;
	}

	/**
	 * Method 'setBpIdNull'
	 * 
	 * @param value
	 */
	public void setBpIdNull(boolean value)
	{
		this.bpIdNull = value;
	}

	/**
	 * Method 'isBpIdNull'
	 * 
	 * @return boolean
	 */
	public boolean isBpIdNull()
	{
		return bpIdNull;
	}

	/**
	 * Method 'equals'
	 * 
	 * @param _other
	 * @return boolean
	 */
	public boolean equals(Object _other)
	{
		if (_other == null) {
			return false;
		}
		
		if (_other == this) {
			return true;
		}
		
		if (!(_other instanceof PattiLines)) {
			return false;
		}
		
		final PattiLines _cast = (PattiLines) _other;
		if (id != _cast.id) {
			return false;
		}
		
		if (code == null ? _cast.code != code : !code.equals( _cast.code )) {
			return false;
		}
		
		if (avgCost != _cast.avgCost) {
			return false;
		}
		
		if (avgCostNull != _cast.avgCostNull) {
			return false;
		}
		
		if (avgQuantity != _cast.avgQuantity) {
			return false;
		}
		
		if (avgQuantityNull != _cast.avgQuantityNull) {
			return false;
		}
		
		if (actualCost != _cast.actualCost) {
			return false;
		}
		
		if (actualCostNull != _cast.actualCostNull) {
			return false;
		}
		
		if (actualQuantity != _cast.actualQuantity) {
			return false;
		}
		
		if (actualQuantityNull != _cast.actualQuantityNull) {
			return false;
		}
		
		if (commissionPercent != _cast.commissionPercent) {
			return false;
		}
		
		if (commissionPercentNull != _cast.commissionPercentNull) {
			return false;
		}
		
		if (loory != _cast.loory) {
			return false;
		}
		
		if (looryNull != _cast.looryNull) {
			return false;
		}
		
		if (cooli != _cast.cooli) {
			return false;
		}
		
		if (cooliNull != _cast.cooliNull) {
			return false;
		}
		
		if (pattiId != _cast.pattiId) {
			return false;
		}
		
		if (pattiIdNull != _cast.pattiIdNull) {
			return false;
		}
		
		if (balance != _cast.balance) {
			return false;
		}
		
		if (balanceNull != _cast.balanceNull) {
			return false;
		}
		
		if (bpId != _cast.bpId) {
			return false;
		}
		
		if (bpIdNull != _cast.bpIdNull) {
			return false;
		}
		
		return true;
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 */
	public int hashCode()
	{
		int _hashCode = 0;
		_hashCode = 29 * _hashCode + id;
		if (code != null) {
			_hashCode = 29 * _hashCode + code.hashCode();
		}
		
		long temp_avgCost = Double.doubleToLongBits(avgCost);
		_hashCode = 29 * _hashCode + (int) (temp_avgCost ^ (temp_avgCost >>> 32));
		_hashCode = 29 * _hashCode + (avgCostNull ? 1 : 0);
		_hashCode = 29 * _hashCode + avgQuantity;
		_hashCode = 29 * _hashCode + (avgQuantityNull ? 1 : 0);
		long temp_actualCost = Double.doubleToLongBits(actualCost);
		_hashCode = 29 * _hashCode + (int) (temp_actualCost ^ (temp_actualCost >>> 32));
		_hashCode = 29 * _hashCode + (actualCostNull ? 1 : 0);
		_hashCode = 29 * _hashCode + actualQuantity;
		_hashCode = 29 * _hashCode + (actualQuantityNull ? 1 : 0);
		long temp_commissionPercent = Double.doubleToLongBits(commissionPercent);
		_hashCode = 29 * _hashCode + (int) (temp_commissionPercent ^ (temp_commissionPercent >>> 32));
		_hashCode = 29 * _hashCode + (commissionPercentNull ? 1 : 0);
		long temp_loory = Double.doubleToLongBits(loory);
		_hashCode = 29 * _hashCode + (int) (temp_loory ^ (temp_loory >>> 32));
		_hashCode = 29 * _hashCode + (looryNull ? 1 : 0);
		long temp_cooli = Double.doubleToLongBits(cooli);
		_hashCode = 29 * _hashCode + (int) (temp_cooli ^ (temp_cooli >>> 32));
		_hashCode = 29 * _hashCode + (cooliNull ? 1 : 0);
		_hashCode = 29 * _hashCode + pattiId;
		_hashCode = 29 * _hashCode + (pattiIdNull ? 1 : 0);
		long temp_balance = Double.doubleToLongBits(balance);
		_hashCode = 29 * _hashCode + (int) (temp_balance ^ (temp_balance >>> 32));
		_hashCode = 29 * _hashCode + (balanceNull ? 1 : 0);
		_hashCode = 29 * _hashCode + bpId;
		_hashCode = 29 * _hashCode + (bpIdNull ? 1 : 0);
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return PattiLinesPk
	 */
	public PattiLinesPk createPk()
	{
		return new PattiLinesPk(id);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.app.dal.dto.PattiLines: " );
		ret.append( "id=" + id );
		ret.append( ", code=" + code );
		ret.append( ", avgCost=" + avgCost );
		ret.append( ", avgQuantity=" + avgQuantity );
		ret.append( ", actualCost=" + actualCost );
		ret.append( ", actualQuantity=" + actualQuantity );
		ret.append( ", commissionPercent=" + commissionPercent );
		ret.append( ", loory=" + loory );
		ret.append( ", cooli=" + cooli );
		ret.append( ", pattiId=" + pattiId );
		ret.append( ", balance=" + balance );
		ret.append( ", bpId=" + bpId );
		return ret.toString();
	}

}