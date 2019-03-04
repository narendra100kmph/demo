package com.cityconnect.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class CityConnectServiceImpl implements CityConnectService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CityConnectServiceImpl.class);

	@Value("${routes.graph.file}")
	private String file;

	@Autowired
	Graph graph;

	@PostConstruct
	public void init() throws IOException {

		Resource resource = new ClassPathResource(file);
		InputStream resourceAsStream = resource.getInputStream();
		Scanner scanner = new Scanner(resourceAsStream);
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			String[] split = line.split(",");

			graph.addVertex(split[0].trim());
			graph.addVertex(split[1].trim());

			graph.addEdge(split[0].trim(), split[1].trim());
		}
		scanner.close();

	}

	@Override
	public boolean isRouteExists(String origin, String destination) {

		List<Vertex> verList = graph.getAdjVertices(graph, origin);

		List<String> verStrList = verList.stream().map(result -> result.getLabel()).collect(Collectors.toList());

		if (ifExistsInCollection(verStrList, destination)) {
			return true;
		} else {
			Set<String> visited = graph.breadthFirstTraversal(graph, origin, destination);
			return ifExistsInCollection(visited, destination);

		}

	}

	private boolean ifExistsInCollection(Collection<String> coll, String destination) {
		boolean isExists = false;
		String destVertex = coll.stream().filter(str -> destination.equals(str)).findAny().orElse(null);
		if (destVertex != null) {
			isExists = true;
		}
		return isExists;
	}

}
