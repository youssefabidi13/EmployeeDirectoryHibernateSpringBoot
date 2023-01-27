package com.luv2code.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.cruddemo.entity.Employee;
import com.luv2code.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService ;
	
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	//expose "/employees" and return list of employees
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	
	//add mapping for Get /employees/{employeeId}
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		 
		Employee theEmployee = employeeService.findById(employeeId);
		
		if (theEmployee == null) {
			throw new RuntimeException("Employee id not found by this id  : "  + employeeId );
		}
		return theEmployee; 
	}
	
	//add mapping for POST /employees add new Employee
		@PostMapping("/employees")
		public Employee addEmployee(@RequestBody Employee theEmployee) {
			 
			//also just in case they pass an id in json ...set id to 0
			//this is to force a save of new items .. instead of update
			
			theEmployee.setId(0);
			employeeService.save(theEmployee);
			return theEmployee; 
		} 
		
		//add mapping for put /employees update Employee
				@PutMapping("/employees")
				public Employee updateEmployee(@RequestBody Employee theEmployee) {
					 
					//update theEmployee
					
					employeeService.save(theEmployee);
					return theEmployee; 
				} 
				
				//add mapping for delete /employees add new Employee
				@DeleteMapping("/employees/{employeeId}")
				public String deleteEmployee(@PathVariable int employeeId) {
					 
					//delete theEmployee
					Employee theEmployee = employeeService.findById(employeeId);
					
					if (theEmployee == null) {
						throw new RuntimeException("Employee id not found by this id  : "  + employeeId );
					}
					employeeService.deleteById(employeeId);
					return "The employee who has this id: "+employeeId+" is deleted "; 
				} 		
}






























