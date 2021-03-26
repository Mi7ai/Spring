package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Employee;

//crud methods for free baby
//change the access, instead of /*/employees you access /*/members
//by default is lower case Entity name(employee) + s = /employees
//@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
