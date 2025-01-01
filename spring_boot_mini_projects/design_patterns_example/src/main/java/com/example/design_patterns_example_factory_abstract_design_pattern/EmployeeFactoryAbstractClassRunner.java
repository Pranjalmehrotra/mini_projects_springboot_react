package com.example.design_patterns_example_factory_abstract_design_pattern;

import org.springframework.util.ObjectUtils;

public class EmployeeFactoryAbstractClassRunner {
	public static void main(String[] args) {

		EmployeeInterface androidDev = EmployeeFactory.getEmployeeDetails(new AndroidDevFactory());
		EmployeeInterface webDev = EmployeeFactory.getEmployeeDetails(new WebDevFactory());
		if (!ObjectUtils.isEmpty(androidDev)) {
			System.out.println("The employee type is ::" + androidDev.employeeType());
		} else {
			System.out.println("Please enter the eomploye details in correct format");
		}

		if (!ObjectUtils.isEmpty(webDev)) {
			System.out.println("The employee type is ::" + webDev.employeeType());
		} else {
			System.out.println("Please enter the eomploye details in correct format");
		}

	}
}