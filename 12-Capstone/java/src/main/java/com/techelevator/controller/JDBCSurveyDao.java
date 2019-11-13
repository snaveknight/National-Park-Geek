package com.techelevator.controller;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JDBCSurveyDao implements SurveyDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCSurveyDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(Survey survey) {
		String sqlInsertPost = "Insert Into \r\n" + 
				"survey_result(\r\n" + 
				"parkcode, emailaddress, state, activitylevel)"
				+ " values(?, ?, ?, ?)";
		jdbcTemplate.update(sqlInsertPost, 
				survey.getParkCode(),
				survey.getEmailAddress(),
				survey.getState(), 
				survey.getActivityLevel());
	}
	
	
}
