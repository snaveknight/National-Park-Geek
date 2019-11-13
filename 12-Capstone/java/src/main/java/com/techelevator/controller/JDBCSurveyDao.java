package com.techelevator.controller;

import java.util.ArrayList;
import java.util.List;

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
	@Override
	public void getAllParksInFavOrder() {
		List<Parks> favParks = new ArrayList<>();
		String sqlGetAllParks = "select p.parkname, COUNT(s.surveyid) AS favorites\r\n" + 
				"FROM park p\r\n" + 
				"INNER JOIN\r\n" + 
				"survey_result s\r\n" + 
				"ON\r\n" + 
				"p.parkcode = s.parkcode\r\n" + 
				"GROUP BY\r\n" + 
				"parkname\r\n" + 
				"ORDER BY\r\n" + 
				"favorites ASC";
	}
	
	
}
