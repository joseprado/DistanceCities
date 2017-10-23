package br.com.joseprado.testedev.service;

import java.util.List;

import br.com.joseprado.testedev.response.CityResponse;

public interface CityService {

	public List<CityResponse> returnListDistance(String unity);
	
}
