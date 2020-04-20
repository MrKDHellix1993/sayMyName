/*
 * package io.javaworkshop.coronavirustracker.controllers;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.GetMapping;
 * 
 * import
 * io.javaworkshop.coronavirustracker.services.CoronaVirusFetchDataService;
 * 
 * @Controller public class HomeDataController {
 * 
 * @Autowired private CoronaVirusFetchDataService coronaVirusFetchDataService;
 * 
 * @GetMapping("/v1/home") public String home(Model model) {
 * model.addAttribute("locationStats",
 * coronaVirusFetchDataService.getAllStates()); return "home"; }
 * 
 * 
 * }
 */