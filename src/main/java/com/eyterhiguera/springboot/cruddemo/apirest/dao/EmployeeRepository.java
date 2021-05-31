package com.eyterhiguera.springboot.cruddemo.apirest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eyterhiguera.springboot.cruddemo.apirest.entity.Employee;

//Spring Data Jpa (JpaRepository)
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	//that's it....no need to write any code
}
