package com.jp.coronavirustracker.services;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jp.coronavirustracker.models.AllStats;
import com.jp.coronavirustracker.models.LocationStats;

@Service
public class CoronaVirusDataService {

	
	private static final String DATA_URL = "https://corona.lmao.ninja";
	private RestTemplate restTemplate = new RestTemplate();
	private List<LocationStats> locationStatsList = new ArrayList<LocationStats>();

	@PostConstruct
	public void fetchVirusData() throws IOException, InterruptedException {

		HttpClient client = HttpClient.newHttpClient();

		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(DATA_URL + "/countries")).build();

		HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

		StringReader statsJsonReader = new StringReader(httpResponse.body());

		ObjectMapper mapper = new ObjectMapper();
		List<LocationStats> newStats = new ArrayList<LocationStats>();

		try {
			newStats = Arrays.asList(mapper.readValue(statsJsonReader, LocationStats[].class));

			System.out.println(newStats);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setLocationStatsList(newStats);
	}

	public List<AllStats> getAllStats() {

		List<AllStats> newStats = Arrays.asList(restTemplate.getForObject(DATA_URL + "/all", AllStats.class));

		return newStats;

	}

	public List<LocationStats> getLocationStatsList() {
		return locationStatsList;
	}

	public void setLocationStatsList(List<LocationStats> locationStatsList) {
		this.locationStatsList = locationStatsList;
	}
}
