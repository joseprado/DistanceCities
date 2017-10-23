/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.joseprado.testedev.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.joseprado.testedev.entity.Cities;
import br.com.joseprado.testedev.factory.ConnectionFactory;

/**
 *
 * @author jose.prado
 */
public class CitiesDAO extends ConnectionFactory {

	private static CitiesDAO instance;

	public static CitiesDAO getInstance() {
		if (instance == null)
			instance = new CitiesDAO();
		return instance;
	}

	public List<Cities> returListCoordinates() {
		Connection conexao = null;
		Statement st = null;
		ResultSet rs = null;
		List<Cities> listCities = new ArrayList<Cities>();
		try {
			conexao = criarConexao();

			String sql = "select a.name as origin ,b.name as destination, " + " a.latitude  as latitude_a, "
					+ " a.longitude as longitude_a, " + " b.latitude as latitude_b, " + " b.longitude as longitude_b "
					+ " from (select name, latitude, longitude from city) a "
					+ " inner join (select name, latitude, longitude from city) b " + " on a.name != b.name order by 1";

			st = conexao.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				Cities cities = new Cities();
				cities.setOrigin(rs.getString(1));
				cities.setDestination(rs.getString(2));
				cities.setLatitudeOrigin(rs.getString(3));
				cities.setLongitudeOrigin(rs.getString(4));
				cities.setLatitudeDestination(rs.getString(5));
				cities.setLongitudeDestination(rs.getString(6));
				
				listCities.add(cities);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, st, rs);

		}

		return listCities;
	}

}
