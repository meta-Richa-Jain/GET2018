package com.metacube.training.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.metacube.training.model.Project;

@Repository
public class ProjectDAOImpl {

	private final static String ADD_PROJECT = "INSERT INTO project (description, start_date, end_date, project_logo) "
			+ "VALUES (?,?,?,?) ";

	private final static String UPDATE_PROJECT = "UPDATE project SET description = ? , start_date = ? , end_date = ? ,"
			+ "project_logo = ? WHERE id = ? ";

	private final static String GET_ALL_PROJECTS = "SELECT project_id, description, start_date, end_date, project_logo "
			+ "FROM project";

	private ConnectionPool dbCon = new ConnectionPool();

	private static ProjectDAOImpl projectDao = new ProjectDAOImpl();

	public static ProjectDAOImpl getInstance() {
		return projectDao;
	}

	public boolean addProject(Project project) {
		Connection con = null;
		try {
			con = dbCon.getAvailableConnection();
			PreparedStatement ps = con.prepareStatement(ADD_PROJECT);
			ps.setString(1, project.getDescription());
			ps.setDate(2, (Date) project.getStartDate());
			ps.setDate(3, (Date) project.getEndDate());
			ps.setString(4, project.getProjectLogo());

			ps.executeUpdate();
		} catch (SQLException e) {
			return false;
		} finally {
			dbCon.releaseConnection(con);
		}
		return true;
	}

	public boolean updateProject(Project project) {
		Connection con = null;
		try {
			con = dbCon.getAvailableConnection();
			PreparedStatement ps = con.prepareStatement(UPDATE_PROJECT);
			ps.setString(1, project.getDescription());
			ps.setDate(2, (Date) project.getStartDate());
			ps.setDate(3, (Date) project.getEndDate());
			ps.setString(4, project.getProjectLogo());
			ps.setInt(5, project.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			return false;
		} finally {
			dbCon.releaseConnection(con);
		}
		return true;
	}
	
	public List<Project> getAllProjects(){
		Connection con = null;
		List<Project> projects = new ArrayList<Project>();
		try {
			con = dbCon.getAvailableConnection();
			PreparedStatement ps = con.prepareStatement(GET_ALL_PROJECTS);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Project project = new Project();
				project.setDescription(rs.getString("description"));
				project.setStartDate(rs.getDate("start_date"));
				project.setEndDate(rs.getDate("end_date"));
				project.setProjectLogo(rs.getString("project_logo"));
				projects.add(project);
			}
		} catch(SQLException e) {
			
		} finally {
			dbCon.releaseConnection(con);
		} 
		return projects;
	}

}