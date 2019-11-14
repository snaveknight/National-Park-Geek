package com.techelevator.controller;

public class Weather {
	
	private String parkCode;
	private int fiveDayForeCastValue;
	private int low;
	private int high;
	private String foreCast;
	
	
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public int getFiveDayForeCastValue() {
		return fiveDayForeCastValue;
	}
	public void setFiveDayForeCastValue(int fiveDayForeCastValue) {
		this.fiveDayForeCastValue = fiveDayForeCastValue;
	}
	public int getLow() {
		return low;
	}
	public void setLow(int low) {
		this.low = low;
	}
	public int getHigh() {
		return high;
	}
	public void setHigh(int high) {
		this.high = high;
	}
	public String getForeCast() {
		return foreCast.toLowerCase();
	}
	public void setForeCast(String foreCast) {
		this.foreCast = foreCast;
	}
	
	
	

}
