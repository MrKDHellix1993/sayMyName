package io.javaworkshop.coronavirustracker.models;

import java.util.List;

public class CoronaVirsuStatSummay {
	
	private Integer totalNewCasesOverGlob;
	private Integer prevDffNewRegCasesOverGlob;
	private List<LocationStats> allLocationStats;
	
	public CoronaVirsuStatSummay() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Integer getTotalNewCasesOverGlob() {
		return totalNewCasesOverGlob;
	}
	public void setTotalNewCasesOverGlob(Integer totalNewCasesOverGlob) {
		this.totalNewCasesOverGlob = totalNewCasesOverGlob;
	}
	public Integer getPrevDffNewRegCasesOverGlob() {
		return prevDffNewRegCasesOverGlob;
	}
	public void setPrevDffNewRegCasesOverGlob(Integer prevDffNewRegCasesOverGlob) {
		this.prevDffNewRegCasesOverGlob = prevDffNewRegCasesOverGlob;
	}
	public List<LocationStats> getAllLocationStats() {
		return allLocationStats;
	}
	public void setAllLocationStats(List<LocationStats> allLocationStats) {
		this.allLocationStats = allLocationStats;
	}
	
	
}
