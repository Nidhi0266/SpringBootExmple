package com.spring.demo.java;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.demo.java.beans.TblEmployee;
import com.spring.demo.java.service.EmployeeService;

@SpringBootApplication
public class SpringCrudExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCrudExampleApplication.class, args);
		System.out.println("get here");
		/*List<TblEmployee> list = service.getAllEmployees();*/
	}

}
