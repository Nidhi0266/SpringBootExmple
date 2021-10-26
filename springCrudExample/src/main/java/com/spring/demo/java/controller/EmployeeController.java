package com.spring.demo.java.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.java.beans.TblEmployee;
import com.spring.demo.java.repository.EmployeeRepository;
import com.spring.demo.java.service.EmployeeService;
//@CrossOrigin(origins = "http://localhost:8081")
//@CrossOrigin(origins = "http://localhost:8080")
@RestController
//@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeService empServ;
	
//	@GetMapping("/AllEmp")//@RequestParam(required = false) String title
	@RequestMapping("/AllEmp")
	public ResponseEntity<List<TblEmployee>> getAllTutorials() {
		try {
			List<TblEmployee> emps = new ArrayList<TblEmployee>();

			emps = empServ.getAllEmployees();

			if (emps.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(emps, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(method= RequestMethod.POST, value="/SaveEditEmp")
	public void saveUpdateEmployee(@RequestBody TblEmployee tblEmp) {
		System.out.println("get here");
		empServ.saveEmp(tblEmp);
	}
	
	
	@RequestMapping(method= RequestMethod.DELETE, value="/DelEmp/{id}")
	public void delEmployee(@PathVariable Long id) {
		System.out.println("get here");
		empServ.delEmp(id);
	}
	
	@RequestMapping(method= RequestMethod.GET, value="/getEmp/{id}")
	public TblEmployee detEmployee(@PathVariable Long id) {
		System.out.println("get here");
		 TblEmployee emp= empServ.getEmp(id).get();
		 return emp;
	}
}
