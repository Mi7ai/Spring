package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Employee;

//crud methods for free baby
//change the access, instead of /*/employees you access /*/members
//by default is lower case Entity name(employee) + s = /employees
//@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
