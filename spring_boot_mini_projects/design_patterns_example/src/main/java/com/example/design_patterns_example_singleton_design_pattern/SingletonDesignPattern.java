package com.example.design_patterns_example_singleton_design_pattern;

/*Important points::

	1. Private Constructor-->Always make the constructor of the class as private
	2. Make one static variable of type class
	3. Make static method that generates the object of the class with the condition that if object variable is null then only, 
	   it creates the object otherwise return the same object.
	Now, Lazy way of initialisig the object is best when we are not working in the multi-threaded environment.
	But if we areworking in the multi-threaded environment, then we have to use synchronised keyword in the common method. 
	*/

public class SingletonDesignPattern {

	private static SingletonDesignPattern singletonDesignPatternObject;

	// Eager way of the object initialising
	private static SingletonDesignPattern singletonDesignPatternObjectEager = new SingletonDesignPattern();

	// *************************************************************************************************************************

	private SingletonDesignPattern() {
		// This we have done so that our singleton pattern doesnot break for the
		// Reflection APIS.
		if (singletonDesignPatternObject != null) {
			throw new RuntimeException("Object already exists for the singleton pattern");
		}
	}

	// Lazy way of object initialising
	// a. This method work perfectly fine in non-multi threaded environment.
	public static SingletonDesignPattern getDesignPatternLazyInitNonMultithreaded() {
		// Object has not been created in the memory.
		if (singletonDesignPatternObject == null) {

			singletonDesignPatternObject = new SingletonDesignPattern();
		}
		// Object already created in the memory.

		return singletonDesignPatternObject;
	}
//*************************************************************************************************************************
	// b. This method work perfectly fine in a multi threaded environment.

	public static SingletonDesignPattern getDesignPatternLazyInitMultithreaded() {
		// Object has not been created in the memory.
		if (singletonDesignPatternObject == null) {

			synchronized (SingletonDesignPattern.class) {
				singletonDesignPatternObject = new SingletonDesignPattern();
			}
		}
		// Object already created in the memory.

		return singletonDesignPatternObject;
	}

	public static SingletonDesignPattern getObjectEagerWay() {
		return singletonDesignPatternObjectEager;
	}

}
