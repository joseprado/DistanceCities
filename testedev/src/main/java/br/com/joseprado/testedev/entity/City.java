package br.com.joseprado.testedev.entity;

public class City {

	private Long id;
	
	private String name;
	
	private Long latitude;
	
	private Long longitude;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the latitude
	 */
	public Long getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public Long getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(Long longitude) {
		this.longitude = longitude;
	}
	
	
	
}
