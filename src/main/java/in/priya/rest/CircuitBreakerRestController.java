package in.priya.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController

public class CircuitBreakerRestController {
	
	
	@GetMapping("/data")
	@CircuitBreaker(fallbackMethod = "getDataFromDatabase" , name="priyaIT")
	public String getDataFromRedis()
	{
		//int a=7/0;
		return "Get data from redis";
	}
	
	public String getDataFromDatabase(Throwable t)
	{
		return "Get data from Database";
	}

}
