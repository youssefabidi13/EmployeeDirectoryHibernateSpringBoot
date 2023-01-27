package com.luv2code.cruddemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.cruddemo.entity.Employee;

import jakarta.persistence.EntityManager;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	//define field for entity manager
	private EntityManager entityManager;
	
	//setup constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		
		//get the current hibernate session 
		Session currentSession = entityManager.unwrap(Session.class);
		 
		//create query
		Query<Employee> theQuery = currentSession.createQuery("from Employee",Employee.class);
		
		//execute query and get  result list
		List<Employee> employees = theQuery.getResultList();
		
		//return the result
		
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		//get employee
		Employee theEmployee = currentSession.get(Employee.class,theId);
		
		//return the employee
		return theEmployee;
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		
		//get the current hibernate session 
		Session currentSession = entityManager.unwrap(Session.class);

		//save the employee if id=0 the save else update
		currentSession.saveOrUpdate(theEmployee);
		
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		//get the current hibernate session 
		Session currentSession = entityManager.unwrap(Session.class);
		
		//delete by id
		Query theQuery =
				currentSession.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();	
	}

}

























