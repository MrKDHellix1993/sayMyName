package com.interview.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
public class InterviewAnswerCommonApi {

	/*
	 * @GetMapping(value = "/getAllUsersDetails")
	 * 
	 * @CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin") public
	 * ResponseEntity<User> getAllUsers() { try { ArrayList<User> userList = new
	 * ArrayList<User>(); for (int i = 0; i < 10; i++) { User temp = new User();
	 * temp.setPersonId(i); userList.add(temp); } return
	 * ResponseEntity.ok(userList.get(0)); } catch (Exception e) { return
	 * ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); } }
	 */

	@GetMapping(value = "/parseDectatorInput")
	@CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin")
	public ResponseEntity<String> parseDectatorInput(@RequestParam("inputStream") String inputStream) {
		try {
			ArrayList<Integer> freq = new ArrayList<Integer>();
			ArrayList<Integer> charVal = new ArrayList<Integer>();
			StringBuffer opBuf = null;
			if (null != inputStream && !inputStream.isEmpty()) {
				char[] ipchar = inputStream.toCharArray();
				opBuf = new StringBuffer();
				if (ipchar.length % 2 == 0) {
					for (int i = 0; i < ipchar.length; i++) {
						if (i % 2 == 0)
							freq.add(Integer.parseInt(String.valueOf(ipchar[i])));
						else
							charVal.add(Integer.parseInt(String.valueOf(ipchar[i])));
					}
				} else {

				}

				for (int i = 0; i < freq.size(); i++) {
					for (int j = 0; j < freq.get(i); j++) {
						opBuf.append(charVal.get(i));
					}
				}
			}
			if (null != opBuf) {
				inputStream = opBuf.toString();
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.ok(inputStream);
	}

	@GetMapping(value = "/noSequeneFoundListSeperator")
	@CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin")
	public ResponseEntity<List<List<Integer>>> findNoSequeneFoundListSeperator(@RequestParam("inputList") List<Integer> inputList) {
		List<List<Integer>> lList;
		try {
			lList = null;
			if (null != inputList) {
				lList = new ArrayList<List<Integer>>(); // list of list of integer
				System.out.println("list:" + inputList);
				int i = 0;
				int chop = 0;
				List<Integer> sList = new ArrayList<Integer>(2);
				for (i = 1; i < inputList.size(); i++) {
					if ((inputList.get(i) - inputList.get(i - 1)) == 1) {
						sList.add(inputList.get(i - 1));
						// sList.add(list.get(i));
					} else {
						sList.add(inputList.get(i - 1));
						lList.add(sList);
						chop = i;
						System.out.println("New Spliter index " + chop);
						sList = new ArrayList<Integer>(2);
					}

				}
				// sList.add(list.get(start)); // for last range
				sList.add(inputList.get(inputList.size() - 1));
				lList.add(sList);
				System.out.println("Range :" + lList);
			}
			return ResponseEntity.ok(lList);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
