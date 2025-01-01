package com.example.design_patterns_example_factory_design_pattern;

public class AndroidDeveloper implements EmployeeInterface{

	@Override
	public String employeeType() {
     String employeeType = "Android developer";
     System.out.println("AndroidDeveloper.employeeType()");
		return employeeType;
	}

	@Override
	public int employeeSalary() {
		System.out.println("AndroidDeveloper.employeeSalary()");
		int employeeSalary = 123456;
		return employeeSalary;
	}
	

}
