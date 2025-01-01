package com.example.design_patterns_example_factory_abstract_design_pattern;

public class EmployeeFactory {
	
	public static EmployeeInterface getEmployeeDetails(EmployeeFactoryAbstractClass employeeFactoryAbstractClass) {
		
		return employeeFactoryAbstractClass.getEmployee();
	}

}
