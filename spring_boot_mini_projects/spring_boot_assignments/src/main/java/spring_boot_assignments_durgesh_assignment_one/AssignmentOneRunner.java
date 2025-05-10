package spring_boot_assignments_durgesh_assignment_one;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


/*Question1:
You have two components:
 • UserService depends on EmailService
 • EmailService also needs UserService
Demonstrate how Spring handles circular dependencies and how you can resolve this (with an example).*/

public class AssignmentOneRunner {

	public static void main(String[] args) {
		
		ApplicationContext userServiceContext = new AnnotationConfigApplicationContext(EmailServiceImpl.class);
		System.out.println("The bean created is ::" + userServiceContext);
		((ConfigurableApplicationContext) userServiceContext).close();

	}

}
