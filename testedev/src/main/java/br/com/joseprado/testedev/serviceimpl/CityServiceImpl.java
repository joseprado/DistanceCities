package br.com.joseprado.testedev.serviceimpl;

import java.util.List;

import br.com.joseprado.testedev.dao.CitiesDAO;
import br.com.joseprado.testedev.entity.Cities;
import br.com.joseprado.testedev.factory.DistanceFactory;
import br.com.joseprado.testedev.response.CityResponse;
import br.com.joseprado.testedev.service.CityService;

public class CityServiceImpl implements CityService {

	DistanceFactory distance = new DistanceFactory();
	
	public List<CityResponse> returnListDistance(String unity){
		
		List<Cities> listCities = CitiesDAO.getInstance().returListCoordinates();
		String isKm = unity == null ? "metric" : unity;
		List<CityResponse> list = distance.calculate(listCities, isKm);
		
		return list;
	}
	
}
