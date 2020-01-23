package com.michael;

import javax.persistence.*;

@Entity
@Table(name="dept_slc")
public class Department {
	@Id @GeneratedValue
	private int deptId;
	@Column(name="dept_name")
	private String deptName;
	public Department() {}
	public Department(String deptName) {
		super();
		this.deptName=deptName;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	
}
