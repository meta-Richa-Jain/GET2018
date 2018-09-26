package com.metacube.training.EAD_EmployeePortal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EAD_EmployeePortal.models.Employee;
import com.metacube.training.EAD_EmployeePortal.models.EmployeeRole;
import com.metacube.training.EAD_EmployeePortal.repository.EmployeeRolesRepository;

@Service
public class EmployeeRolesImpl{

	@Autowired
	private EmployeeRolesRepository<Employee> empRolesRepo;

	public List<EmployeeRole> getInfoByEmail(String email) {
		return empRolesRepo.findByEmail(email);
	}
}