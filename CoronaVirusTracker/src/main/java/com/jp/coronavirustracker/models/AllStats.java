package com.jp.coronavirustracker.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AllStats {
	
	@JsonProperty("cases")
	private int cases;
	
	@JsonProperty("deaths")
	private int deaths;
	
	@JsonProperty("recovered")
	private int recovered;
	
	@JsonProperty("updated")
	private Date dateUpdated;

	public int getCases() {
		return cases;
	}

	public void setCases(int cases) {
		this.cases = cases;
	}

	public int getDeaths() {
		return deaths;
	}

	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}

	public int getRecovered() {
		return recovered;
	}

	public void setRecovered(int recovered) {
		this.recovered = recovered;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(long timeStamp) {
		
		this.dateUpdated = new Date(timeStamp);
	}

	@Override
	public String toString() {
		return "AllStats [cases=" + cases + ", deaths=" + deaths + ", recovered=" + recovered + ", dateUpdated="
				+ dateUpdated + "]";
	}

	
	
	

}
