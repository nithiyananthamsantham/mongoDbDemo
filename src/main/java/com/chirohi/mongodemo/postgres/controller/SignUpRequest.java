package com.chirohi.mongodemo.postgres.controller;

import java.util.Objects;

public class SignUpRequest {
	
    public String empName;

    public String empEmail;

	@Override
	public int hashCode() {
		return Objects.hash(empEmail, empName, empPass);
	}

	public SignUpRequest(String empName, String empEmail, String empPass) {
		super();
		this.empName = empName;
		this.empEmail = empEmail;
		this.empPass = empPass;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SignUpRequest other = (SignUpRequest) obj;
		return Objects.equals(empEmail, other.empEmail) && Objects.equals(empName, other.empName)
				&& Objects.equals(empPass, other.empPass);
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpPass() {
		return empPass;
	}

	public void setEmpPass(String empPass) {
		this.empPass = empPass;
	}

	public String empPass;

}
