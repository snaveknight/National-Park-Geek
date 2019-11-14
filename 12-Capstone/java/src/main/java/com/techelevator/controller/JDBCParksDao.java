package com.techelevator.controller;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
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
		while (results.next()) {
			Parks parks = new Parks();
			parks.setParkCode(results.getString("parkcode").toLowerCase());
			parks.setParkName(results.getString("parkname"));
			parks.setParkDescription(results.getString("parkdescription"));
			allParks.add(parks);
		}
		return allParks;

	}

	@Override
	public Parks getParkInfoById(String parkCode) {
		Parks parks = new Parks();
		String sqlGetThisPark = "Select * from park where parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetThisPark, parkCode);
		while (results.next()) {
			parks.setParkCode(results.getString("parkcode").toLowerCase());
			parks.setParkName(results.getString("parkname"));
			parks.setState(results.getString("state"));
			parks.setAcreage(results.getInt("acreage"));
			parks.setElevationInFeet(results.getInt("elevationinfeet"));
			parks.setMilesOfTrail(results.getDouble("milesoftrail"));
			parks.setNumberOfCampsites(results.getInt("numberofcampsites"));
			parks.setClimate(results.getString("climate"));
			parks.setYearFounded(results.getInt("yearfounded"));
			parks.setAnnualVisitorCount(results.getInt("annualvisitorcount"));
			parks.setInspirationalQuote(results.getString("inspirationalquote"));
			parks.setInspirationalQuoteSource(results.getString("inspirationalquotesource"));
			parks.setParkDescription(results.getString("parkdescription"));
			parks.setEntryFee(results.getInt("entryfee"));
			parks.setNumberOfAnimalSpecies(results.getInt("numberofanimalspecies"));
		
		}
		return parks;
	}

	@Override
	public List<Weather> getWeatherInfo(String parkCode) {
		List<Weather> todaysWeather = new ArrayList();
		String sqlGetWeatherInfo = "Select * \r\n" + 
				"From \r\n" + 
				"weather\r\n" + 
				"where parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetWeatherInfo, parkCode);
		while(results.next()) {
			Weather weather = new Weather();
			weather.setParkCode(results.getString("parkcode"));
			weather.setFiveDayForeCastValue(results.getInt("fivedayforecastvalue"));
			weather.setLow(results.getInt("low"));
			weather.setHigh(results.getInt("high"));
			weather.setForeCast(results.getString("forecast"));
			todaysWeather.add(weather);
		}

		return todaysWeather;
	}

//	@Override
//	public String getAdvisoryCondition(String parkCode) {
//		String advisCondition = "";
//		if (foreCast.contentEquals("snow")) {
//			advisCondition = "Pack Snowshoes";
//		}
//		if (foreCast.contentEquals("rain")) {
//			advisCondition = "Pack rain gear";
//		}
//		if (foreCast.contentEquals("thunderstorms")) {
//			advisCondition = "Seek shelter and avoid hiking on exposed bridges";
//		}
//		if (foreCast.contentEquals("sunny")) {
//			advisCondition = "Pack Sunblock";
//		}
//		return advisCondition;
//	}
	
	
	
	


}
