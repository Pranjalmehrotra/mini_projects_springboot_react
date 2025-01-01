package com.example.design_patterns_example_factory_design_pattern;

public class FactoryDesignPatternRunnner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeFactoryDesignPattern employeeFactoryDesignPattern = new EmployeeFactoryDesignPattern();
		String androidType = "web developer";
		EmployeeInterface employeeInterface = employeeFactoryDesignPattern.getEmployeeInterface(androidType);
		if(employeeInterface != null) {
			int salary = employeeInterface.employeeSalary();
			System.out.println("The employee salary is ::" + salary);
		}
		else {
			System.out.println("The object is null!!Please give proper input");
		}

	}

}
