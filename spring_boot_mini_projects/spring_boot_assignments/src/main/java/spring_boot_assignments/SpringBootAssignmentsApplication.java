package spring_boot_assignments;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import spring_boot_assignments.controller.PrimaryController;
import spring_boot_assignments.controller.QualifierController;
import spring_boot_assignments_durgesh_assignment_one.EmailServiceImpl;
import spring_boot_assignments_durgesh_assignment_one.UserServiceImpl;

@SpringBootApplication
@ComponentScan({ "spring_boot_assignments_durgesh_assignment_one", "spring_boot_assignments.controller",
		"spring_boot_assignments.dao" })
public class SpringBootAssignmentsApplication {
	public static void main(String[] args) {

		ConfigurableApplicationContext assignmentContext = SpringApplication.run(SpringBootAssignmentsApplication.class,
				args);
		UserServiceImpl userServiceClass = assignmentContext.getBean(UserServiceImpl.class);
		System.out.println(userServiceClass);
		System.out.println("*****************************************");
		System.out.println();
		EmailServiceImpl emailServiceClass = assignmentContext.getBean(EmailServiceImpl.class);
		System.out.println(emailServiceClass);
		System.out.println("****************************************");
		System.out.println();
		PrimaryController primaryControllerClass = assignmentContext.getBean(PrimaryController.class);
		List<String> tableNameList = primaryControllerClass.getTableList();
		System.out.println("The table name list using primary is ::" + tableNameList);
		System.out.println("****************************************");
		System.out.println();
		QualifierController qualifierControllerClass = assignmentContext.getBean(QualifierController.class);
		List<String> tableNameListUsingQualifier = qualifierControllerClass.getTableListName();
		System.out.println("The table name list using qualifeir is ::" + tableNameListUsingQualifier);
		assignmentContext.close();
	}

}
