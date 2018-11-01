package com.capgemini.dao;
import com.capgemini.bean.EmployeeBean;



import com.capgemini.exception.EmployeeException;
public interface IEmployeeDAO {
	public String addEmployeeDetails(EmployeeBean employeebean) throws EmployeeException;
}





