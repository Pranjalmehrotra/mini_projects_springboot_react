package spring_boot_assignments.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

import spring_boot_assignments.dao.DatabaseService;

@RestController
public class QualifierController {
	
	private DatabaseService databaseService;
	
	@Autowired
	public QualifierController(@Qualifier("oracleDatabaseServiceImpl")DatabaseService databaseService) {
		this.databaseService = databaseService;
	}
	
	public List<String>getTableListName(){
		return databaseService.getTables();
	}
	
	
	
	

}
