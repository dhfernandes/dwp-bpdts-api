package org.dwp.bpdts.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

/**
 * Spring service for geography calculations
 */
@Service
public class GeographyService {

	private static final double EARTH_RADIUS = 3956;
	
    /**
     * Calculate distance between two coordinates using the Haversine formula
     *
     * @param latitudeFrom - the latitude of the start point
     * @param longitudeFrom -  the longitude of the start point
     * @param latitudeTo - the latitude of the end point
     * @param longitudeTo - the longitude of the end point
     * @return distance in miles.
     */
    public double calculateDistance(double latitudeFrom, 
    								double longitudeFrom,
    								double latitudeTo, 
    								double longitudeTo) {
        //Convert degrees to radians. 
    	latitudeFrom = Math.toRadians(latitudeFrom); 
    	longitudeFrom = Math.toRadians(longitudeFrom); 
    	latitudeTo = Math.toRadians(latitudeTo); 
    	longitudeTo = Math.toRadians(longitudeTo); 
        //Use the Haversine formula 
        double longitudeDifference = longitudeTo - longitudeFrom;  
        double latitudeDifference = latitudeTo - latitudeFrom; 
        double formula = Math.pow(Math.sin(latitudeDifference / 2), 2) 
                 + Math.cos(latitudeFrom) * Math.cos(latitudeTo) 
                 * Math.pow(Math.sin(longitudeDifference / 2),2);      
        double distance = 2 * Math.asin(Math.sqrt(formula));
        //Multiply by Earth's Radius and round up to 2 decimal places       
        BigDecimal ret = new BigDecimal(distance * EARTH_RADIUS).setScale(2, RoundingMode.HALF_UP);
        return ret.doubleValue();
    } 
    
}
