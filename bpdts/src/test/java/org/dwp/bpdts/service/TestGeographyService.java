/**
 * 
 */
package org.dwp.bpdts.service;

import static org.junit.jupiter.api.Assertions.*;

import org.dwp.bpdts.service.GeographyService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestGeographyService {

	@Autowired
	GeographyService geographyService;
	
	@Test
	@DisplayName (value = "Test Haversine formula to calculate distance from London to Lisbon")
	void testCalculateDistance() {
		//London
        double latitudeFrom =  51.509865; 
        double longitudeFrom = -0.118092;
        //Lisbon
        double latitudeTo =  38.736946; 
        double longitudeTo = -9.142685;  
        double expected = 983.68;
        double actual = geographyService.calculateDistance(latitudeFrom, longitudeFrom, latitudeTo, longitudeTo);
        assertEquals(expected, actual);
	}

}
