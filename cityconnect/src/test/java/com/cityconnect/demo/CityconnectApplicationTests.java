package com.cityconnect.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityconnectApplicationTests {

	private static final Logger LOGGER = LoggerFactory.getLogger(CityconnectApplicationTests.class);

	@Autowired
	private Graph graph;

	@Autowired
	private CityConnectService cityConnectService;

	@Test
	public void adjVertices() {
		Assert.assertEquals("[New York, Newark]", graph.getAdjVertices(graph, "Boston").toString());
	}

	@Test
	public void isRouteExists() {

		LOGGER.info("Boston to is  Newark RouteExists::->" + cityConnectService.isRouteExists("Boston", "Newark"));
		//Assert.assertTrue(cityConnectService.isRouteExists("Boston", "Newark"));
		
		LOGGER.info("Newark to is  Boston RouteExists::->" + cityConnectService.isRouteExists("Newark", "Boston"));
		//Assert.assertTrue(cityConnectService.isRouteExists("Newark", "Boston"));

		LOGGER.info("Boston to is  Philadelphia RouteExists::->" + cityConnectService.isRouteExists("Boston", "Philadelphia"));

		//Assert.assertTrue(cityConnectService.isRouteExists("Boston", "Philadelphia"));

		LOGGER.info("Philadelphia to is  Boston RouteExists::->" + cityConnectService.isRouteExists("Philadelphia", "Boston"));
		
		//Assert.assertTrue(cityConnectService.isRouteExists("Philadelphia", "Boston"));

		LOGGER.info("New York to is  Newark RouteExists::->" + cityConnectService.isRouteExists("New York", "Newark"));
		
		//Assert.assertTrue(cityConnectService.isRouteExists("New York", "Newark"));

		LOGGER.info("Newark to is  New York RouteExists::->" + cityConnectService.isRouteExists("Newark", "New York"));
		
		//Assert.assertTrue(cityConnectService.isRouteExists("Newark", "New York"));

		LOGGER.info("Boston to is  New York RouteExists::->" + cityConnectService.isRouteExists("Boston", "New York"));

		//Assert.assertTrue(cityConnectService.isRouteExists("Boston", "New York"));

		LOGGER.info("New York to is  Boston RouteExists::->" + cityConnectService.isRouteExists("New York", "Boston"));
		
		//Assert.assertTrue(cityConnectService.isRouteExists("New York", "Boston"));

		LOGGER.info("Newark to is  Philadelphia RouteExists::->" + cityConnectService.isRouteExists("Newark", "Philadelphia"));
		
		//Assert.assertTrue(cityConnectService.isRouteExists("Newark", "Philadelphia"));

		LOGGER.info("Philadelphia to is  Newark RouteExists::->" + cityConnectService.isRouteExists("Philadelphia", "Newark"));
		
		//Assert.assertTrue(cityConnectService.isRouteExists("Philadelphia", "Newark"));

		LOGGER.info("Philadelphia to is  Albany RouteExists::->" + cityConnectService.isRouteExists("Philadelphia", "Albany"));
		
		//Assert.assertFalse(cityConnectService.isRouteExists("Philadelphia", "Albany"));

		LOGGER.info("Albany to is  Philadelphia RouteExists::->" + cityConnectService.isRouteExists("Albany", "Philadelphia"));
		
		//Assert.assertFalse(cityConnectService.isRouteExists("Albany", "Philadelphia"));
	}

}
