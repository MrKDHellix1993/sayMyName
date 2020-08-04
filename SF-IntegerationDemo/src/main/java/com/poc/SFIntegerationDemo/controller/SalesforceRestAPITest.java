package com.poc.SFIntegerationDemo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.SFIntegerationDemo.model.DataPayload;
import com.poc.SFIntegerationDemo.model.ResponseJson;
//import com.poc.SFIntegerationDemo.service.JavarestApi;
import com.poc.SFIntegerationDemo.service.WebClientSFDemo;

@RestController
public class SalesforceRestAPITest {

	/*
	 * @Autowired private JavarestApi javarestApi;
	 */

	@Autowired
	private WebClientSFDemo webClientDemo;
	
	@RequestMapping("/")
	public String helloSF() {
		return "Welcome to SF";
	}

	/*
	 * @RequestMapping("/login") public Object initiateCallToSF() {
	 * System.out.println("WS Hit"); return this.javarestApi.doSalesforceLogin(); }
	 */
	
	@RequestMapping("/login")
	public Object initiateCallToSF() {
		System.out.println("WS Hit");
		return this.webClientDemo.doSalesforceLoginTest();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/postTest", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseJson> postTest(@RequestBody DataPayload payload) {
		ResponseJson res = null;
		if (null != payload) {
			if (null != payload.getTotal()) {
				res = new ResponseJson();
				res.setStatus("200");
				res.setMessage("Sucess total value is :" + payload.getTotal());
				System.out.println(res.getMessage());
			}

		}
		return ResponseEntity.ok(res);
	}

	/*
	 * @RequestMapping("/create") public Object createObjectToSF(@RequestParam
	 * String instace_url, @RequestParam String token) throws Exception { return
	 * this.webClientDemo.createaccount(instace_url, token);
	 * 
	 * }
	 */

	@RequestMapping("/createProfile")
	public Object createProObjectToSF(@RequestParam String instace_url, @RequestParam String token) throws Exception {
		return this.webClientDemo.createProfile(instace_url, token);

	}
}
