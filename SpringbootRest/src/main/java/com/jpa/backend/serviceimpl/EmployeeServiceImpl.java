package com.jpa.backend.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jpa.backend.exception.ResourceNotFoundException;
import com.jpa.backend.model.Employee;
import com.jpa.backend.repository.EmployeeRepository;
import com.jpa.backend.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}


	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}


	@Override
	public Employee getEmployeeById(long id) {
		// TODO Auto-generated method stub
//		Optional<Employee> employee=employeeRepository.findById(id);
//		if(employee.isPresent())
//		{
//			return employee.get();
//		}
//		else {
//			throw new ResourceNotFoundException("Employee","Id",id);
//		}
		return employeeRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Employee","Id",id));
	}


	@Override
	public Employee updateEmployee(Employee employee, long id) {
		// TODO Auto-generated method stub
		Employee existingemployee=employeeRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Employee","Id",id));
		existingemployee.setFirstName(employee.getFirstName());
		existingemployee.setLastName(employee.getLastName());
		existingemployee.setEmail(employee.getEmail());
		employeeRepository.save(existingemployee);
		return existingemployee;
	}

	@Override
	public void deleteEmployee(long id) {
		// TODO Auto-generated method stub
		
		employeeRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Employee","Id",id));
		employeeRepository.deleteById(id);
	}
	
}
