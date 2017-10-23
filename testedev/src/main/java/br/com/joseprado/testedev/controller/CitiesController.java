package br.com.joseprado.testedev.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;

import br.com.joseprado.testedev.response.CityResponse;
import br.com.joseprado.testedev.service.CityService;
import br.com.joseprado.testedev.serviceimpl.CityServiceImpl;

@Path("/cities")
public class CitiesController {
	
	CityService cityService = new CityServiceImpl();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/xml/{unity}")
	public List<CityResponse> getDistanceCalculateXml(@PathParam("unity") String unity) throws JAXBException{
			return cityService.returnListDistance(unity);

	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/json/{unity}")
	public List<CityResponse> getDistanceCalculateJson(@PathParam("unity") String unity) throws JAXBException{
			return cityService.returnListDistance(unity);

	}
}


