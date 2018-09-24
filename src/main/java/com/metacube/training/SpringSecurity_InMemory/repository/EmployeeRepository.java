package com.metacube.training.SpringSecurity_InMemory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.SpringSecurity_InMemory.model.Employee;



@Repository
@Transactional
public interface EmployeeRepository<E> extends JpaRepository<Employee, Integer> {

	/**
	 * Method to find employee details by emailId
	 * @param emailId
	 * @return
	 */
	public Employee findByEmailId(String emailId);
	
	/**
	 * Method to return employees details by first name
	 * @param firstName
	 * @return
	 */
	public List<Employee> findByFirstNameContainingIgnoreCase(String firstName);
	
	/**
	 * Method to find employee details by employee code
	 * @param code
	 * @return
	 */
	public Employee findByCode(int code);
	
	/**
	 * Method to update employee password of the given employee code
	 * @param password
	 * @param code
	 * @return
	 */
	@Modifying
	@Query("update Employee e set e.password =:password where e.code =:code")
	public boolean setPasswordFor(@Param("password") String password, @Param("code") int code);
	
	/**
	 * Method to disable employee 
	 * @param code
	 * @return
	 */
	@Modifying
	@Query("update Employee e set e.enabled = 'true' where e.code =:code")
	public boolean DisableEmployee(@Param("code") int code);
	
	/**
	 * Method to return the list of all employees with the given total experience 
	 * @param totalExp
	 * @return
	 */
	@Modifying
	@Query("Select e from Employee join JobDetails jd where jd.totalExp =:totalExp")
	public List<Employee> searchEmployeeByTotalExperience(@Param("totalExp") int totalExp);
}