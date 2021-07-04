/**
 * 
 */
package com.api.ratelimiter.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

/**
 * @author vikas
 *
 */
@Controller
public class SchedulerClass {
	
	private final static long FIXED_RATE = 60 * 60 * 1000;

	/**
	 * 1. Schedule a Job which runs for every 1 hour 2. Maintain an Hashmap whcih
	 * stores user ID as a key and number of requests as a value 3. refreshes the
	 * map once the specified time li
	 */
	
	private Map<String, Integer> requestsMap = new HashMap<String, Integer>();

	@Async
	@Scheduled(fixedRate = FIXED_RATE)
	public void reportCurrentTime() {
		System.out.println("Refreshing entries at " + new Date());
		refreshMap();
	}

	// adding userId's to the requestsMap
	public void addRequestToMap(String userId) {
		if (requestsMap.containsKey(userId))
			requestsMap.put(userId, requestsMap.get(userId) + 1);
		else
			requestsMap.put(userId, 1);
		displayMap();
	}

	// removing all the entries from the hashmap after specified time
	public void refreshMap() {
		requestsMap.clear();
	}

	// get the map
	public Map<String, Integer> getRequestMap() {
		return requestsMap;
	}

	// display the current status of the map
	public void displayMap() {
		for (Map.Entry<String, Integer> set : requestsMap.entrySet()) {
			System.out.println(set.getKey() + "=" + set.getValue());
		}
	}

}
