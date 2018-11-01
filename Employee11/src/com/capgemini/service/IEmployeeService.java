package com.capgemini.service;

import com.capgemini.bean.EmployeeBean;


import com.capgemini.exception.EmployeeException;


public interface IEmployeeService {
	public String addEmployeeDetails(EmployeeBean employeebean) throws EmployeeException;
}
