package com.metacube.training.EAD_EmployeePortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.EAD_EmployeePortal.models.Employee;


@Repository
@Transactional
public interface EmployeeRepository<E> extends JpaRepository<Employee, Integer> {

	/**
	 * Method to find employee details by emailId
	 * @param emailId
	 * @return
	 */
	Employee findByEmailId(String emailId);
	
	/**
	 * Method to find employee details by emailId and password
	 * @param email
	 * @param password
	 * @return
	 */
	Employee findByEmailIdAndPassword(String email, String password);
	
	/**
	 * Method to return employees details by first name
	 * @param firstName
	 * @return
	 */
	List<Employee> findByFirstNameContainingIgnoreCase(String firstName);
	
	/**
	 * Method to find employee details by employee code
	 * @param code
	 * @return
	 */
	Employee findByCode(int code);
	
	/**
	 * Method to update employee password of the given employee code
	 * @param password
	 * @param code
	 * @return
	 */
	@Modifying
	@Query("update Employee e set e.password =:password where e.code =:code")
	boolean setPasswordFor(@Param("password") String password, @Param("code") int code);
	
	/**
	 * Method to disable employee 
	 * @param code
	 * @return
	 */
	@Modifying
	@Query("update Employee e set e.enabled = 'true' where e.code =:code")
	boolean DisableEmployee(@Param("code") int code);
	
	/**
	 * Method to return the list of all employees with the given total experience 
	 * @param totalExp
	 * @return
	 */
	@Modifying
	@Query("Select e from Employee e join JobDetails jd where jd.totalExp =:totalExp")
	List<Employee> searchEmployeeByTotalExperience(@Param("totalExp") int totalExp);
}