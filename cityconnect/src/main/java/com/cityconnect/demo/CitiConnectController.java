package com.cityconnect.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CitiConnectController {

	@Autowired
	private CityConnectService cityConnectService;

	@RequestMapping(value = "/connected")
	public String areCitiesConnected(@RequestParam("origin") String origin,
			@RequestParam("destination") String destination) {
		boolean isRouteExists = cityConnectService.isRouteExists(origin, destination);
		if (isRouteExists)
			return "yes";
		return "no";
	}
}