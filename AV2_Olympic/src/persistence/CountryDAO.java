package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Country;


public class CountryDAO 
{
	public Connection connection;
	
	public CountryDAO() throws ClassNotFoundException, SQLException
	{
		GenericDAO gDAO = new GenericDAO();
		connection = gDAO.getConnection();
	}
	
	
	public void insertCountry(Country country) throws SQLException
	{
		String sql	 = "INSERT INTO Country VALUES (?,?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1, country.getCoi());
		ps.setString(2, country.getName_country());
		
		ps.execute();
		ps.close();
	}

	
	public List<Country> PopulateCountry() throws SQLException
	{
		List<Country> listCountry = new ArrayList<Country>();
		
		String sql = "SELECT coi, name_country FROM Country ORDER BY coi, name_Country";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next())
		{
			Country country = new Country();
			country.setCoi(rs.getString("coi"));
			country.setName_country(rs.getString("name_country"));
			
			listCountry.add(country);
		}
		
		rs.close();
		ps.close();
		
		return listCountry;
	}
}
