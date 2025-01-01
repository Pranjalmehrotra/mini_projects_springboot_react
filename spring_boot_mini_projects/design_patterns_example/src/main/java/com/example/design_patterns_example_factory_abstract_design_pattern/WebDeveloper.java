package com.example.design_patterns_example_factory_abstract_design_pattern;

public class WebDeveloper implements EmployeeInterface {

	@Override
	public String employeeType() {
		String employeeType = "Web developer";
		System.out.println("WebDeveloper.employeeType()");
		return employeeType;
	}

	@Override
	public int employeeSalary() {
		int employeeSalary = 123456;
		System.out.println("WebDeveloper.employeeSalary()");
		return employeeSalary;
	}

}
