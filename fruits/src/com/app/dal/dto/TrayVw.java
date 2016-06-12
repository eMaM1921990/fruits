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
import java.util.Date;

public class TrayVw implements Serializable
{
	/** 
	 * This attribute maps to the column created_at in the tray_vw table.
	 */
	protected Date createdAt;

	/** 
	 * This attribute maps to the column number_of_tray in the tray_vw table.
	 */
	protected int numberOfTray;

	/** 
	 * This attribute represents whether the primitive attribute numberOfTray is null.
	 */
	protected boolean numberOfTrayNull = true;

	/** 
	 * This attribute maps to the column name in the tray_vw table.
	 */
	protected String name;

	/** 
	 * This attribute maps to the column bp_name in the tray_vw table.
	 */
	protected String bpName;

	/**
	 * Method 'TrayVw'
	 * 
	 */
	public TrayVw()
	{
	}

	/**
	 * Method 'getCreatedAt'
	 * 
	 * @return Date
	 */
	public Date getCreatedAt()
	{
		return createdAt;
	}

	/**
	 * Method 'setCreatedAt'
	 * 
	 * @param createdAt
	 */
	public void setCreatedAt(Date createdAt)
	{
		this.createdAt = createdAt;
	}

	/**
	 * Method 'getNumberOfTray'
	 * 
	 * @return int
	 */
	public int getNumberOfTray()
	{
		return numberOfTray;
	}

	/**
	 * Method 'setNumberOfTray'
	 * 
	 * @param numberOfTray
	 */
	public void setNumberOfTray(int numberOfTray)
	{
		this.numberOfTray = numberOfTray;
		this.numberOfTrayNull = false;
	}

	/**
	 * Method 'setNumberOfTrayNull'
	 * 
	 * @param value
	 */
	public void setNumberOfTrayNull(boolean value)
	{
		this.numberOfTrayNull = value;
	}

	/**
	 * Method 'isNumberOfTrayNull'
	 * 
	 * @return boolean
	 */
	public boolean isNumberOfTrayNull()
	{
		return numberOfTrayNull;
	}

	/**
	 * Method 'getName'
	 * 
	 * @return String
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Method 'setName'
	 * 
	 * @param name
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Method 'getBpName'
	 * 
	 * @return String
	 */
	public String getBpName()
	{
		return bpName;
	}

	/**
	 * Method 'setBpName'
	 * 
	 * @param bpName
	 */
	public void setBpName(String bpName)
	{
		this.bpName = bpName;
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
		
		if (!(_other instanceof TrayVw)) {
			return false;
		}
		
		final TrayVw _cast = (TrayVw) _other;
		if (createdAt == null ? _cast.createdAt != createdAt : !createdAt.equals( _cast.createdAt )) {
			return false;
		}
		
		if (numberOfTray != _cast.numberOfTray) {
			return false;
		}
		
		if (numberOfTrayNull != _cast.numberOfTrayNull) {
			return false;
		}
		
		if (name == null ? _cast.name != name : !name.equals( _cast.name )) {
			return false;
		}
		
		if (bpName == null ? _cast.bpName != bpName : !bpName.equals( _cast.bpName )) {
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
		if (createdAt != null) {
			_hashCode = 29 * _hashCode + createdAt.hashCode();
		}
		
		_hashCode = 29 * _hashCode + numberOfTray;
		_hashCode = 29 * _hashCode + (numberOfTrayNull ? 1 : 0);
		if (name != null) {
			_hashCode = 29 * _hashCode + name.hashCode();
		}
		
		if (bpName != null) {
			_hashCode = 29 * _hashCode + bpName.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.app.dal.dto.TrayVw: " );
		ret.append( "createdAt=" + createdAt );
		ret.append( ", numberOfTray=" + numberOfTray );
		ret.append( ", name=" + name );
		ret.append( ", bpName=" + bpName );
		return ret.toString();
	}

}
