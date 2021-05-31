package com.eyterhiguera.springboot.cruddemo.apirest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.eyterhiguera.springboot.cruddemo.apirest.dao.EmployeeRepository;
import com.eyterhiguera.springboot.cruddemo.apirest.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	//inject  EmployeeRepository
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		
		this.employeeRepository = theEmployeeRepository;
	}
	
	@Override
	//Remove @Transactional since JpaRepository provides this functionality
	//@Transactional
	public List<Employee> findAll() {
	
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		
		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee theEmployee = null;
		
		if(result.isPresent()) {
		 
			theEmployee = result.get();
		}
		
/* There is no need to thow a run time exception if the Data is not present 
in the optional. Because The EmployeeRestController itself throws a run time exception 
if an Employee is not found in the database with the provided id. 
So we can get rid of that or we can get rid of the same logic applied 
in the Rest Controller*/
		
		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
	
         employeeRepository.save(theEmployee);
	}

	@Override	
	public void deleteById(int theId) {
	
		employeeRepository.deleteById(theId);

	}

}
