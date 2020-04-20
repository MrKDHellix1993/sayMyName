package io.batch.multithreading.batchmultithreadingservice.entity;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import io.batch.multithreading.batchmultithreadingservice.model.MovieSummary;

public class CompletableFutureDemo {

	@Value("${api_key}")
	private String apiKey;

	@Value("${api_url}")
	private String apiUrl;
	
	public static void main(String[] args) {
		CompletableFutureDemo cd = new CompletableFutureDemo();
		cd.getPrices();
	}

	public Set<Integer> getPrices() {
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		Set<Integer> prices = new HashSet<>();
		prices = Collections.synchronizedSet(prices);
		CountDownLatch cdl = new CountDownLatch(3);
		executorService.submit(new Task(apiUrl, apiKey, "550",cdl));
		executorService.submit(new Task(apiUrl, apiKey, "551",cdl));
		executorService.submit(new Task(apiUrl, apiKey, "552",cdl));
		
		try {
			cdl.await(3, TimeUnit.SECONDS);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("is shut " + executorService.isShutdown());
		return prices;
	}

}

class Task implements Runnable {

	private String url;
	private String productId;
	private String apiKey;
	private CountDownLatch cdl;
	@Autowired
	private RestTemplate restTemplate;

	public Task(String url, String apiKey, String productId,CountDownLatch cdl) {
		super();
		this.url = url;
		this.productId = productId;
		this.cdl = cdl;
	}

	@Override
	public void run() {
		String movieDBUrl = url + productId + "?api_key=" + apiKey;
		MovieSummary movieSummary = restTemplate.getForObject(movieDBUrl, MovieSummary.class);
		pric
		System.out.println("movieSummary : " + movieSummary);
		cdl.countDown();
	}

}
