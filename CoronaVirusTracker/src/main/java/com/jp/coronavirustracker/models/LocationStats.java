package com.jp.coronavirustracker.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationStats {
	
	@JsonProperty("country")
	private String country;
	
	@JsonProperty("cases")
	private int totalCases;
	
	@JsonProperty("todayCases")
	private int todayCases;
	
	@JsonProperty("deaths")
	private int deaths;
	
	@JsonProperty("todayDeaths")
	private int todayDeaths;
	
	@JsonProperty("recovered")
	private int recovered;
	
	@JsonProperty("critical")
	private int critical;


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public int getTotalCases() {
		return totalCases;
	}


	public void setTotalCases(int totalCases) {
		this.totalCases = totalCases;
	}


	public int getTodayCases() {
		return todayCases;
	}


	public void setTodayCases(int todayCases) {
		this.todayCases = todayCases;
	}


	public int getDeaths() {
		return deaths;
	}


	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}


	public int getTodayDeaths() {
		return todayDeaths;
	}


	public void setTodayDeaths(int todayDeaths) {
		this.todayDeaths = todayDeaths;
	}


	public int getRecovered() {
		return recovered;
	}


	public void setRecovered(int recovered) {
		this.recovered = recovered;
	}


	public int getCritical() {
		return critical;
	}


	public void setCritical(int critical) {
		this.critical = critical;
	}


	@Override
	public String toString() {
		return "LocationStats [country=" + country + ", totalCases=" + totalCases + ", todayCases=" + todayCases
				+ ", deaths=" + deaths + ", todayDeaths=" + todayDeaths + ", recovered=" + recovered + ", critical="
				+ critical + "]";
	}
	
	
	

}
