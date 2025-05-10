package spring_boot_assignments.dao;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class MySQLDatabaseServiceImpl implements DatabaseService{

	@Override
	public List<String> getTables() {
		System.out.println("Inside the method of MySQLDatabaseServiceImpl.getTables()");
		return List.of("MySQL","Oracle","PostGresSQL");
	}

}
