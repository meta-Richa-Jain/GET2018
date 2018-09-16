package com.metacube.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Employee;

@Repository
@Transactional
public interface EmployeeRepository<E> extends JpaRepository<Employee, Integer> {

	Employee findByEmailId(String emailId);
	
	List<Employee> findByFirstNameContainingIgnoreCase(String firstName);
	
	Employee findByCode(int code);
	
//	@Modifying
//	@Query("update Employee e set e.password =:password where e.code =:code")
//	boolean setPasswordFor(@Param("password") String password, @Param("code") int code);
//	
//	@Modifying
//	@Query("update Employee e set e.enabled = 'true' where e.code =:code")
//	boolean DisableEmployee(@Param("code") int code);
}