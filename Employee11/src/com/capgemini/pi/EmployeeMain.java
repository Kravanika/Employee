package com.capgemini.pi;

import java.util.InputMismatchException;



import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.capgemini.bean.EmployeeBean;
import com.capgemini.exception.EmployeeException;
import com.capgemini.exception.EmployeeException;
import com.capgemini.service.EmployeeServiceImpl;
import com.capgemini.service.IEmployeeService;
import com.capgemini.service.EmployeeServiceImpl;

//import com.capgemini.dao;
import java.lang.NullPointerException;

@SuppressWarnings("unused")
public class EmployeeMain  {

	static Scanner sc = new Scanner(System.in);
	static IEmployeeService employeeService = null;
	static EmployeeServiceImpl employeeServiceImpl = null;
	static Logger logger = Logger.getRootLogger();

	public static void main(String[] args) throws Exception {
		PropertyConfigurator.configure("resources//log4j.properties");
		EmployeeBean employeebean = null;

		String employee_id = null;
		int option = 0;

		while (true) {

			// show menu
			System.out.println();
			System.out.println();
			System.out.println("   Employee Details ");
			System.out.println("_______________________________\n");

			System.out.println("1.Insert Employee ");
			System.out.println("2.Exit");
			System.out.println("________________________________");
			System.out.println("Select an option:");
			// accept option

			try {
				option = sc.nextInt();

				switch (option) {

				case 1:

					while (employeebean  == null) {
						employeebean   = populateEmployeebean ();
						 System.out.println(employeebean);
						
					}

					try {
						employeeService = new EmployeeServiceImpl();
						employee_id = employeeService.addEmployeeDetails(employeebean);

						System.out.println("Employee details  has been successfully registered ");
						System.out.println("Emp  ID Is: " + employee_id);

					} catch (EmployeeException employeeException) {
						logger.error("exception occured", employeeException);
						System.out.println("ERROR : "
								+ employeeException.getMessage());
					} finally {
						employee_id = null;
						employeeService = null;
						employeebean = null;
					}

					break;


				case 2:

					System.out.print("Exit Trust Application");
					System.exit(0);
					break;
				default:
					System.out.println("Enter a valid option[1-4]");
				}// end of switch
			}

			catch (InputMismatchException e) {
				sc.nextLine();
				System.err.println("Please enter a numeric value, try again");
		}

		}// end of while
	}

	private static EmployeeBean populateEmployeebean() throws Exception {

		// Reading and setting the values for the donorBean
		
		EmployeeBean employeebean = new EmployeeBean();

		System.out.println("\n Employee Details");

		System.out.println("Enter id_number: ");
		employeebean.setIdnumber(sc.next());
		System.out.println("Enter  name: ");
		employeebean.setName(sc.next());
		
	
		
        employeeServiceImpl = new EmployeeServiceImpl();
//System.out.println("After creating patient service impl object");

		try {
			employeeServiceImpl.validateEmployee(employeebean);
			
			System.out.println("after validate Employee");
			return employeebean ;
		} catch (EmployeeException employeeException) {
			logger.error("exception occured", employeeException);
			System.err.println("Invalid data:");
			System.err.println(employeeException.getMessage() + " \n Try again..");
			System.exit(0);

		}
		return null;

	}
}
