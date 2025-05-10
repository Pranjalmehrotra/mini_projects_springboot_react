package spring_boot_assignments.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import spring_boot_assignments.dao.DatabaseService;

@RestController
public class PrimaryController {
	
	private DatabaseService databaseService;
	
	@Autowired
	public PrimaryController(DatabaseService databaseService) {
		this.databaseService = databaseService;
		
	}
	
	public List<String>getTableList(){
		return databaseService.getTables();
	}

}
