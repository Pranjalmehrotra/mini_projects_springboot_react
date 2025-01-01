package com.example.design_patterns_example_factory_design_pattern;

public class EmployeeFactoryDesignPattern {
	
	public EmployeeInterface getEmployeeInterface(String type) {
		if(type.equalsIgnoreCase("Android developer")) {
			return new AndroidDeveloper();
			
		}
		else if(type.equalsIgnoreCase("Web developer")) {
			return new WebDeveloper();
		}
		else {
			return null;
		}
	}

}
