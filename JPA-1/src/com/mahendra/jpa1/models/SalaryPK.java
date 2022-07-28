package com.mahendra.jpa1.models;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;


public class SalaryPK implements Serializable{

	private Integer empId;
	
	private Date fromDate;
	
	public SalaryPK() {
	}

	public SalaryPK(Integer empId, Date fromDate) {
		super();
		this.empId = empId;
		this.fromDate = fromDate;
	}
	
	public Integer getEmpId() {
		return empId;
	}
	
	public Date getFromDate() {
		return fromDate;
	}
	
	
}
