package com.example.design_patterns_example_singleton_design_pattern;

public class SingletonDesignPatternRunner {
	
	public static void main(String[] args) {
		
		SingletonDesignPattern singleOne = 	SingletonDesignPattern.getDesignPatternLazyInitNonMultithreaded();
		
		SingletonDesignPattern singleTwo = 	SingletonDesignPattern.getDesignPatternLazyInitNonMultithreaded();
		
		System.out.println("The hashcode of the singleOne is ::" + singleOne.hashCode());
		System.out.println("The hashcode of the singleOne is ::" + singleTwo.hashCode());
		
		SingletonDesignPattern singleOneEager = SingletonDesignPattern.getObjectEagerWay();
		SingletonDesignPattern singleTwoEager = SingletonDesignPattern.getObjectEagerWay();
		SingletonDesignPattern singleThreeEager = SingletonDesignPattern.getObjectEagerWay();

		
		System.out.println("The hashcode of the singleOneEager is ::" + singleOneEager.hashCode());
		System.out.println("The hashcode of the singleTwoEager is ::" + singleTwoEager.hashCode());
		System.out.println("The hashcode of the singleThreeEager is ::" + singleThreeEager.hashCode());

	}
}
