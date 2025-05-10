package spring_boot_assignments.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class OracleDatabaseServiceImpl implements DatabaseService {

	@Override
	public List<String> getTables() {
		System.out.println("Inside the method of OracleDatabaseServiceImpl.getTables()");
		return List.of("MySQL", "Oracle", "PostGresSQL");

	}
}
