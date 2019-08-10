package com.spring.cloud.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {
	/*@Autowired
	private DiscoveryClient discoveryClient;*/

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/call")
	public String callClient2() {
		//String appInstance=getInstance(appname);
		ResponseEntity<String> response = restTemplate.getForEntity("http://my-client2/values", String.class);
		return response.getBody();
	}

	/*private String getInstance(String appname) {
		List<ServiceInstance> instances=discoveryClient.getInstances(appname);
		System.out.println(instances);
		System.out.println(instances.get(0).getUri().toString());
		if(instances!=null && instances.size()>0)
			return instances.get(0).getUri().toString();
		return null;
	}*/
}
