package io.javaworkshop.coronavirustracker.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.javaworkshop.coronavirustracker.accessingdatajpa.Users;
import io.javaworkshop.coronavirustracker.config.CoronaVirusBeanConfigurtion;
import io.javaworkshop.coronavirustracker.models.CoronaVirsuStatSummay;
import io.javaworkshop.coronavirustracker.models.LocationStats;
import io.javaworkshop.coronavirustracker.reposistory.UserRepository;
import io.javaworkshop.coronavirustracker.services.CoronaVirusFetchDataService;

@RequestMapping("/api/auth")
@RestController
public class HomeDataRestController {

//	@Autowired
	private static CoronaVirusFetchDataService coronaVirusFetchDataService;
	
	@Autowired
	public void getCoronaVirusFetchDataService(CoronaVirusFetchDataService coronaVirusFetchDataService) {
		HomeDataRestController.coronaVirusFetchDataService = coronaVirusFetchDataService;
	}
//	@Autowired
	private static CoronaVirsuStatSummay coronaVirsuStatSummay;
	
	@Autowired
	private UserRepository customerRepository;

	@Autowired
	public void setCoronaVirsuStatSummay(CoronaVirsuStatSummay coronaVirsuStatSummay) {
		HomeDataRestController.coronaVirsuStatSummay = coronaVirsuStatSummay;
	}

	@GetMapping("/home")
	@CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin")
	public ResponseEntity<CoronaVirsuStatSummay> getLandingHomePage() {
		List<LocationStats> allStats = coronaVirusFetchDataService.getAllStates();
		Integer totalNewCasesOverGlob = allStats.stream().mapToInt(stat -> Integer.valueOf(stat.getLatestToltCases()))
				.sum();
		Integer prevDffNewRegCasesOverGlob = allStats.stream()
				.mapToInt(stat -> Integer.valueOf(stat.getNewCasesFromPreviousDate())).sum();
		coronaVirsuStatSummay.setTotalNewCasesOverGlob(totalNewCasesOverGlob);
		coronaVirsuStatSummay.setPrevDffNewRegCasesOverGlob(prevDffNewRegCasesOverGlob);
		coronaVirsuStatSummay.setAllLocationStats(allStats);
		return ResponseEntity.ok(coronaVirsuStatSummay);
	}

	@GetMapping("/getAllUsers")
	@CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin")
	public ResponseEntity<List<Users>> getUsers() {
		List<Users> custList = new ArrayList<>();
		Iterable<Users> custIterable = this.customerRepository.findAll();
		if(null != custIterable) {
			custIterable.forEach(custList::add);
		}
		return ResponseEntity.ok(custList);
	}
	
	@RequestMapping(value = "/getMoviePurshaseDetails")
	public ResponseEntity<String> getMoviePurshaseDetails(
			@PathVariable Optional<String> custId,
			@RequestParam(value = "orderId", required = true) String orderId,
			@RequestParam(value = "placeOfPurchase", required = false, defaultValue = "Mumbai") String placeOfPurchase) {
		if (null != orderId) {
			return ResponseEntity.ok(" Here is your Movie Purshase Details " + placeOfPurchase + custId);
		}
		return ResponseEntity.ok(" Order Id can't be null" + placeOfPurchase);
	}
}
