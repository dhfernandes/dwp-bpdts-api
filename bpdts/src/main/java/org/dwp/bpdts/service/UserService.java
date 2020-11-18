package org.dwp.bpdts.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;
import org.dwp.bpdts.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Spring service for users
 */
@Service
public class UserService {

	private static final Logger log = Logger.getLogger(UserService.class);	
	private static final  String BASE_URL = "https://bpdts-test-app.herokuapp.com";
	private static final String USERS_URI = "/users";
	private static final String CITY_URI = "/city";
	//The city name, radius, latitude and longitude can be put in config in case the city changes
	private static final String CITY_NAME_URI = "/London";
	private static final double PERMITTED_RADIUS = 50;
	private static final double LATITUDE_FROM =  51.509865; 
	private static final double LONGITUDE_FROM = -0.118092;

	@Autowired
	GeographyService geographyService;
	
	/**
	 * Get users in specified city or within specified radius
	 * @return list of users
	 */
	public List<User> getUsers() {
		List<User> usersByCity = getUsersByCity();
		List<User> allUsers = getAllUsers();
		List<User> usersByCityRadius = getUsersByCityRadius(allUsers);	
		List<User> users = Stream.of(usersByCity, usersByCityRadius)
                .flatMap(list -> list.stream())
                .distinct()
                .collect(Collectors.toList());
		log.debug("Total Users:" + users.size());
		users.sort(Comparator
				.comparing(User::getLastName)
				.thenComparing(User::getFirstName));		
		users.forEach( u -> log.debug(u));
        return users;
	}
	
	/**
	 * Get all users
	 * @return list of users
	 */
	public List<User> getAllUsers() {
		List<User> users = getUsersFromSource(USERS_URI);
		log.debug("All Users" + users.size());
		return users;
	}
	
	/**
	 * Get users by specified city
	 * @return list of users
	 */
	public List<User> getUsersByCity() {
		final String uri = CITY_URI + CITY_NAME_URI + USERS_URI;
		List<User> users = getUsersFromSource(uri);
		log.debug("London Users:" + users.size());
		return users;
	}

	/**
	 * Get users within specified city radius
	 * @param all users
	 * @return list of users within specified city radius
	 */
	public List<User> getUsersByCityRadius(final List<User> users) {
		return users.stream()
				.filter(user -> geographyService.calculateDistance(LATITUDE_FROM, 
																   LONGITUDE_FROM, 
																   user.getLatitude(), 
																   user.getLongitude())
						<= PERMITTED_RADIUS)
				.collect(Collectors.toList());
	}
	
	/**
	 * Get users from source using web client as it asynchronous (non blocking)
	 * @param uri
	 * @return list of users
	 */
	private List<User> getUsersFromSource(final String uri) {
		WebClient webClient = WebClient.create(BASE_URL);
		return webClient.get()
				.uri(uri)
				.retrieve()
				.bodyToFlux(User.class).collectList().block();
	}

}
