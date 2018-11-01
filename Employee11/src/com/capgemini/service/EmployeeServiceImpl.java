package com.capgemini.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.dao.IEmployeeDAO;
import com.capgemini.bean.EmployeeBean;
import com.capgemini.dao.EmployeeDaoImpl;
import com.capgemini.exception.EmployeeException;

public   class EmployeeServiceImpl implements IEmployeeService {
	
	IEmployeeDAO employeeDao;
	
	public String addEmployeeDetails(EmployeeBean Employeebean) throws EmployeeException {
		
		employeeDao= new EmployeeDaoImpl();
		String employee_Id_sequence;
		employee_Id_sequence= employeeDao.addEmployeeDetails(Employeebean);
		return employee_Id_sequence;
	}
	
	
		public void validateEmployee(EmployeeBean bean) throws Exception
		{
			List<String> validationErrors = new ArrayList<String>();

			//Validating name
			if(!(isValidName(bean.getName()))) {
				validationErrors.add("\n Patient Name Should Be In Alphabets and minimum 3 characters long ! \n");
			}
			//Validating Phone Number
			if(!(isValidIdNumber(bean.getIdnumber()))){
				validationErrors.add("\n IdNumber Should be only digits \n");
			}
			
		
			if(!validationErrors.isEmpty())
				throw new EmployeeException(validationErrors +"");
		}

		private boolean isValidIdNumber(String idnumber) {
			Pattern idPattern = Pattern.compile("[0-9]{1,4}");
			Matcher idMatcher = idPattern.matcher(idnumber);
			
			if(idMatcher.matches())
				return true;
			else
				return false;	
		}


		public boolean isValidName(String name){
			Pattern namePattern=Pattern.compile("^[A-Za-z]{3,}$");
			Matcher nameMatcher=namePattern.matcher(name);
			return nameMatcher.matches();
		}
		
}


		
