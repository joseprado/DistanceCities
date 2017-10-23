package br.com.joseprado.testedev.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CityResponse {

	private String cities;
	
	private String distance;
	
	private String unity;

	/**
	 * @return the cities
	 */
	public String getCities() {
		return cities;
	}

	/**
	 * @param cities the cities to set
	 */
	public void setCities(String cities) {
		this.cities = cities;
	}

	/**
	 * @return the distance
	 */
	public String getDistance() {
		return distance;
	}

	/**
	 * @param distance the distance to set
	 */
	public void setDistance(String distance) {
		this.distance = distance;
	}

	/**
	 * @return the unity
	 */
	public String getUnity() {
		return unity;
	}

	/**
	 * @param unity the unity to set
	 */
	public void setUnity(String unity) {
		this.unity = unity;
	}
	
	
}
