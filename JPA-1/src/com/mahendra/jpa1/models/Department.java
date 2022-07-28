package com.mahendra.jpa1.models;

import jakarta.persistence.*;

@Entity
@Table(name="departments", schema = "hr")
public class Department {
	
	@Id
	@Column(name="dept_no", length=4)
	private String deptId;
	
	@Column(name="dept_name", length=40)
	private String name;
	

	public String getDeptId() {
		return deptId;
	}
	
	public String getName() {
		return name;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Department() {

	}
}
