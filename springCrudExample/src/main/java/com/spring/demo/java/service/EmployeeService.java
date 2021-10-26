package com.spring.demo.java.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.demo.java.beans.TblEmployee;
import com.spring.demo.java.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
    EmployeeRepository repository;
     
    public List<TblEmployee> getAllEmployees()
    {
        List<TblEmployee> employeeList = new ArrayList<>();
        repository.findAll().forEach(employeeList::add);
         
        if(employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<TblEmployee>();
        }
    }
    
    public void saveEmp(TblEmployee tblEmp) {
    	repository.save(tblEmp);
    }
    
    public void delEmp(Long id) {
    	repository.deleteById(id);
    }

    public Optional<TblEmployee> getEmp(Long id) {
     return	repository.findById(id);
    }
}
