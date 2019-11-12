package com.techelevator.controller;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCParksDao implements ParksDao {
	private JdbcTemplate jdbcTemplate;
@Autowired
public JDBCParksDao(DataSource dataSource) {
	this.jdbcTemplate = new JdbcTemplate(dataSource);
}
	@Override
	public List<Parks> getAllParksInAlphOrder() {
	List<Parks> allParks = new ArrayList<>();
	String sqlGetAllParks = "select parkcode, parkname, parkdescription from park order by parkname";
	SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllParks);
	while(results.next()) {
		Parks parks = new Parks();
		parks.setParkCode(results.getString("parkcode"));
		parks.setParkName(results.getString("parkname"));
		parks.setParkDescription(results.getString("parkdescription"));	
		allParks.add(parks);
	}
		return allParks;

	}

}
