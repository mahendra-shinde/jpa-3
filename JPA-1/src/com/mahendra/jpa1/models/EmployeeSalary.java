package com.mahendra.jpa1.models;

import java.util.Date;

import jakarta.persistence.*;

@Table (name="salaries", schema = "hr")
@Entity
@IdClass(SalaryPK.class)
public class EmployeeSalary {
	
	@Id
	@Column(name="emp_no")
	private Integer empId;
	
	@Id
	@Temporal(TemporalType.DATE)
	@Column(name="from_date")
	private Date fromDate;
	
	@Column(name="salary")
	private double salary;
	
	@Temporal(TemporalType.DATE)
	@Column(name="to_date")
	private Date toDate;
	
	public EmployeeSalary() {
		// TODO Auto-generated constructor stub
	}

	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	
	@ManyToOne // Many instances of EmployeeSalary (THIS class) may have a COMMON employee object
	@JoinColumn(name =  "emp_no",updatable = false)
	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public Integer getEmpId() {
		return empId;
	}


	public void setEmpId(Integer empId) {
		this.empId = empId;
	}


	public Date getFromDate() {
		return fromDate;
	}


	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	
	
}


