package com.mindtree.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tables")
public class Tables {
	
	
	@Id
	@Column(name = "table_number")
	private int tableNumber;
	
	@Column(name  = "num_of_persons_per_table")
	private int numOfPersonsPerTable;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "vendor_id")
	private Vendor vendor;
	
	@Column(name="status", length = 20)
	private String status;
	
	public Tables() {
		/*
		 * Empty constructor for Hibernate to instantiate object
		 */
	}

	public int getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}


	public int getNumOfPersonsPerTable() {
		return numOfPersonsPerTable;
	}

	public void setNumOfPersonsPerTable(int numOfPersonsPerTable) {
		this.numOfPersonsPerTable = numOfPersonsPerTable;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


}
