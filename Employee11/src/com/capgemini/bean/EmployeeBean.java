package com.capgemini.bean;

public class EmployeeBean {

	private String Idnumber;
	private String name;

	public String getIdnumber() {
		return Idnumber;
	}

	public void setIdnumber(String idnumber) {
		Idnumber = idnumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Printing Employee Details \n");
		sb.append("IdNumber: " +Idnumber +"\n");
		sb.append("Name: " +name +"\n");		
		return sb.toString();
	}
	
}
