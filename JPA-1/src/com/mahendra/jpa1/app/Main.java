package com.mahendra.jpa1.app;

import com.mahendra.jpa1.models.Employee;
import com.mahendra.jpa1.models.EmployeeSalary;

import jakarta.persistence.*;

public class Main {

	public static void main(String[] args) {
		// Initialize the JPA factory class, it will search for "persistence.xml" file
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu1");
		//Entity Manager instance
		EntityManager em = factory.createEntityManager();
		
		/*
		 * TypedQuery<Employee> query =
		 * em.createQuery("SELECT e FROM Employee e WHERE e.empId < 10100",
		 * Employee.class);
		 * 
		 * List<Employee> empList = query.getResultList();
		 * System.out.println("Emp No   | First Name   | Last Name     "); for(Employee
		 * e: empList) { System.out.printf("\n%8d | %-12s | %-12s ", e.getEmpId(),
		 * e.getFirstName(), e.getLastName()); }
		 */
		
		
		/*
		 * EntityTransaction tn = null;
		 * 
		 * try { tn = em.getTransaction(); tn.begin(); Department dt =
		 * em.find(Department.class, "d010"); em.remove(dt);
		 * System.out.println("Deleted department 010"); tn.commit(); }catch(Exception
		 * ex) { System.out.println(ex.getMessage()); if(tn != null ) { tn.rollback(); }
		 * }
		 */
		
		Employee emp = em.find(Employee.class, 10001);
		System.out.println("Employee details : "+ emp.getLastName()+" "+emp.getFirstName());
		System.out.println("Salary History : ");
		for(EmployeeSalary salary : emp.getSalaryHistory()) {
			System.out.println(salary.getFromDate()+" to "+salary.getToDate()+" = "+salary.getSalary());
		}
		
		
		em.close();
		
	}

}
