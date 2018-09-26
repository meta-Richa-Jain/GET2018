package com.metacube.training.EAD_EmployeePortal.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.metacube.training.EAD_EmployeePortal.models.EmployeeRole;
import com.metacube.training.EAD_EmployeePortal.services.EmployeeRolesImpl;
import com.metacube.training.EAD_EmployeePortal.services.EmployeeServiceImpl;

@Component
public class CustomAuthentication implements AuthenticationProvider {

	@Autowired
	EmployeeServiceImpl employeeService;

	@Autowired
	EmployeeRolesImpl employeeRolesService;

	@Override
	public Authentication authenticate(Authentication authentication) {
		UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
		String email = String.valueOf(auth.getPrincipal());
		String password = String.valueOf(auth.getCredentials());

		if (!(employeeService.checkByEmailAndPassword(email, password))) {
			throw new BadCredentialsException(
					"External system authentication failed");
		}

		List<GrantedAuthority> roles = new ArrayList<>();
		List<EmployeeRole> roleList = employeeRolesService
				.getInfoByEmail(email);

		for (EmployeeRole role : roleList) {
			roles.add(new SimpleGrantedAuthority(role.getRole()));
		}

		return new UsernamePasswordAuthenticationToken(email, password, roles);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
