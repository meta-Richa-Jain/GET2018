package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.mappers.ProjectMapper;
import com.metacube.training.model.Project;

@Repository
public class ProjectDAOImpl {

	private final static String ADD_PROJECT = "INSERT INTO project (description, start_date, end_date, project_logo) "
			+ "VALUES (?,?,?,?) ";

	private final static String UPDATE_PROJECT = "UPDATE project SET description = ? , start_date = ? , end_date = ? ,"
			+ "project_logo = ? WHERE id = ? ";

	private final static String GET_ALL_PROJECTS = "SELECT id, description, start_date, end_date, project_logo "
			+ "FROM project";

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public ProjectDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public boolean addProject(Project project) {
		return jdbcTemplate.update(ADD_PROJECT, project.getDescription(),
				project.getStartDate(), project.getEndDate(),
				project.getProjectLogo()) > 0;
	}

	public boolean updateProject(Project project) {
		return jdbcTemplate.update(UPDATE_PROJECT, project.getDescription(),
				project.getStartDate(), project.getEndDate(),
				project.getProjectLogo(), project.getId()) > 0;
	}

	public List<Project> getAllProjects() {
		return jdbcTemplate.query(GET_ALL_PROJECTS, new ProjectMapper());
	}

}