package com.spring.demo.java.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.demo.java.beans.TblEmployee;

//@Repository
public interface EmployeeRepository extends CrudRepository<TblEmployee, Long>{

}
