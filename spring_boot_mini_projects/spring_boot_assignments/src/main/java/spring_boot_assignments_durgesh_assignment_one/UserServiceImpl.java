package spring_boot_assignments_durgesh_assignment_one;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl {
	
	private EmailServiceImpl emailServiceImpl;
	
	public UserServiceImpl(@Lazy EmailServiceImpl emailServiceImpl) {
		this.emailServiceImpl = emailServiceImpl;
	}

}
