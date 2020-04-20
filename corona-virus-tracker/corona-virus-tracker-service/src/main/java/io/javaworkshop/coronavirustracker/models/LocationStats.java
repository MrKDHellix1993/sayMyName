package io.javaworkshop.coronavirustracker.models;

public class LocationStats {
	private String state;
	private String country;
	private String latestTotalCases;
	private String newCasesFromPreviousDate;
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLatestToltCases() {
		return latestTotalCases;
	}
	public void setLatestToltCases(String latestToltCases) {
		this.latestTotalCases = latestToltCases;
	}
	public String getNewCasesFromPreviousDate() {
		return newCasesFromPreviousDate;
	}
	public void setNewCasesFromPreviousDate(String newCasesFromPreviousDate) {
		this.newCasesFromPreviousDate = newCasesFromPreviousDate;
	}
	@Override
	public String toString() {
		return "LocationStats [state=" + state + ", country=" + country + ", latestTotalCases=" + latestTotalCases
				+ ", newCasesFromPreviousDate=" + newCasesFromPreviousDate + "]";
	}
	
	
	
}
