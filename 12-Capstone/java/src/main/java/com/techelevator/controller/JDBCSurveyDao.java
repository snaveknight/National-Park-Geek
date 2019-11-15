package com.techelevator.controller;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
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
				survey.getParkCode().toUpperCase(),
				survey.getEmailAddress(),
				survey.getState(), 
				survey.getActivityLevel());
	}
	@Override
	public List<Parks> getAllParksInFavOrder() {
		List<Parks> favParks = new ArrayList<>();
		String sqlGetAllParks = "select COUNT(s.parkcode) AS favorites, parkname, s.parkcode \r\n" + 
				"				FROM survey_result s\r\n" + 
				"				INNER JOIN park p \r\n" + 
				"				\r\n" + 
				"				ON \r\n" + 
				"				p.parkcode = s.parkcode \r\n" + 
				"				GROUP BY\r\n" + 
				"				parkname, s.parkcode \r\n" + 
				"				ORDER BY\r\n" + 
				"				favorites DESC";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllParks);
		while (results.next()) {
			Parks parks = new Parks();
			parks.setParkName(results.getString("parkname"));
			parks.setFavorites(results.getInt("favorites"));
			parks.setParkCode(results.getString("parkcode").toLowerCase());
			favParks.add(parks);
		}
		return favParks;
	}
	
	
}
