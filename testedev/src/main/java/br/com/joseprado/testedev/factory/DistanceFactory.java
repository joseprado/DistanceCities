/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.joseprado.testedev.factory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import br.com.joseprado.testedev.entity.Cities;
import br.com.joseprado.testedev.response.CityResponse;

/**
 * Classe responsável por fazer as conexao e trabalho com os dados na API da
 * Google Maps Directory
 * 
 * @author jose.prado
 */
public class DistanceFactory {

	
	private static final String KM = "km";
	
	/**
	 * Metodo responsável por invocar o webservice e retornar o objeto preenchido.
	 * 
	 * @param origem
	 * @param destino
	 * @param mapa
	 * @return
	 */
	public List<CityResponse> calculate(List<Cities> listCities, String utiny) {
		List<CityResponse> list = new ArrayList<CityResponse>();
		 
		try {
			String isKm = KM.equalsIgnoreCase(utiny) ? "metric" : "imperial";
			for(Cities cities : listCities){
				URL url = new URL(
						"http://maps.google.es/maps/api/directions/xml?origin="+cities.getLatitudeOrigin()+","+cities.getLongitudeOrigin()+""
								+ "&destination="+cities.getLatitudeDestination()+","+cities.getLongitudeDestination()+"&sensor=false"
								+ "&units="+ isKm);

				Document document = getDocument(url);
				
				String distance = this.returnDistance(document);
				
				CityResponse city = new CityResponse();
				
				city.setCities(cities.getOrigin() +" - "+cities.getDestination());
				city.setDistance(distance.split(" ")[0]);
				city.setUnity(distance.split(" ")[1]);
				
				list.add(city);
			}
			

		} catch (MalformedURLException | DocumentException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * Metodo responsável em converter os dados retornados pelo webservice
	 * 
	 * @param url
	 * @return
	 * @throws DocumentException
	 */
	public static Document getDocument(URL url) throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(url);
		return document;
	}

	/**
	 * Metodo responsável por retornar o valor em distancia entre as cidades.
	 * 
	 * @param document
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public String returnDistance(Document document) {
		List list = document.selectNodes("//DirectionsResponse/route/leg/distance/text");

		Element element = (Element) list.get(list.size() - 1);

		return element.getText();
	}

}
