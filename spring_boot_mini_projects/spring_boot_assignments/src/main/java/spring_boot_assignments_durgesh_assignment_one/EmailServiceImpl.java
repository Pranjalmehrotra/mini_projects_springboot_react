package spring_boot_assignments_durgesh_assignment_one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl {

	private UserServiceImpl userServiceImpl;

	@Autowired
	public EmailServiceImpl(UserServiceImpl userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

}
