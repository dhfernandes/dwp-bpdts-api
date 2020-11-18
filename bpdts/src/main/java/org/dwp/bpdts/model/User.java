package org.dwp.bpdts.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * POJO object to hold user details
 */
public class User {

	@JsonProperty("id")
	private final int id;
	@JsonProperty("first_name") 
	private final String firstName;
	@JsonProperty("last_name")
	private final String lastName;
	@JsonProperty("email")
	private final String email;
	@JsonProperty("ip_address")
	private final String ipAddress;
	@JsonProperty("latitude")
	private final double latitude;
	@JsonProperty("longitude")
	private final double longitude;

	/**
	 * Constructor for creating user object
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param ipAddress
	 * @param latitude
	 * @param longitude
	 */
	@JsonCreator
	public User(@JsonProperty("id") int id,
            	@JsonProperty("first_name") String firstName,
            	@JsonProperty("last_name") String lastName,
            	@JsonProperty("email") String email,
            	@JsonProperty("ip_address") String ipAddress,
            	@JsonProperty("latitude") double latitude,
            	@JsonProperty("longitude") double longitude) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.ipAddress = ipAddress;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the ipAddress
	 */
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((ipAddress == null) ? 0 : ipAddress.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (ipAddress == null) {
			if (other.ipAddress != null)
				return false;
		} else if (!ipAddress.equals(other.ipAddress))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", ipAddress=" + ipAddress + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
	
}
