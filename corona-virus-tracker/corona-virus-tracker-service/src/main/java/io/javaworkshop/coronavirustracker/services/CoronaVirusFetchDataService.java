package io.javaworkshop.coronavirustracker.services;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import io.javaworkshop.coronavirustracker.models.LocationStats;

@Service
public class CoronaVirusFetchDataService {

	private static String VIRUS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
	private List<LocationStats> allStates = new ArrayList<LocationStats>();
	
	public List<LocationStats> getAllStates() {
		return allStates;
	}

	public void setAllStates(List<LocationStats> allStates) {
		this.allStates = allStates;
	}

	@Scheduled(cron = "* * 1 * * *")
	@PostConstruct
	public void fetchVirusRegisteredCases() throws IOException, InterruptedException {
		List<LocationStats> newStats = new ArrayList<LocationStats>();
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(VIRUS_DATA_URL)).build();
		HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
		StringReader csvBodyReader = new StringReader(httpResponse.body());
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader().parse(csvBodyReader);
		for (CSVRecord record : records) {
			LocationStats locationStat = new LocationStats();
			if(record.get("Province/State").equals(""))
			{
				locationStat.setState(null);
			}else {
				locationStat.setState(record.get("Province/State"));
			}
			locationStat.setCountry(record.get("Country/Region"));
			String latest = record.get(record.size()-1);
			String previous = record.get(record.size()-2);
			locationStat.setLatestToltCases(latest);
			Integer diffFromPrev = Integer.valueOf(latest) - Integer.valueOf(previous); 
			locationStat.setNewCasesFromPreviousDate(String.valueOf(diffFromPrev));
		    newStats.add(locationStat);
		}
		this.allStates = newStats;
	}
}
