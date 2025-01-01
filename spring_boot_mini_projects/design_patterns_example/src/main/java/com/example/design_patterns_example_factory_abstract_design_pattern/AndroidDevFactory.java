package com.example.design_patterns_example_factory_abstract_design_pattern;

public class AndroidDevFactory extends EmployeeFactoryAbstractClass {

	@Override
	public EmployeeInterface getEmployee() {
		// TODO Auto-generated method stub
		return new AndroidDeveloper();
	}
	

}
