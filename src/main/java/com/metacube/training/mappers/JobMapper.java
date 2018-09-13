package com.metacube.training.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.Job;

public class JobMapper implements RowMapper<Job> {

	public Job mapRow(ResultSet resultSet, int i) throws SQLException {
		Job job = new Job();
		job.setTitle(resultSet.getString("title"));
		return job;
	}

}

