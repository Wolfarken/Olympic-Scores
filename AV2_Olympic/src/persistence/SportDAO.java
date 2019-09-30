package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Sport;

public class SportDAO 
{
	public Connection connection;
	
	public SportDAO() throws ClassNotFoundException, SQLException
	{
		GenericDAO gDAO = new GenericDAO();
		connection = gDAO.getConnection();
	}
	
	
	public void insertSport(Sport sport) throws SQLException
	{
		String sql	 = "INSERT INTO Sport VALUES (?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setInt(1, sport.getId_sport());
		ps.setString(2, sport.getName_sport());
		ps.setString(3, sport.getGender_sport());
		ps.setString(4, sport.getMeasurementType_sport());
		
		ps.execute();
		ps.close();
	}

	
	public List<Sport> QuerySports() throws SQLException
	{
		List<Sport> listSport = new ArrayList<Sport>();
		
		String sql = "SELECT id_sport, name_sport, gender_sport, measurementType_sport FROM Sport ORDER BY measurementType_sport, name_sport, gender_sport";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next())
		{
			Sport sport = new Sport();
			sport.setId_sport(rs.getInt("id_sport"));
			sport.setName_sport(rs.getString("name_sport"));
			sport.setGender_sport(rs.getString("gender_sport"));
			sport.setMeasurementType_sport(rs.getString("measurementType_sport"));
			
			listSport.add(sport);
		}
		
		rs.close();
		ps.close();
		
		return listSport;
	}
	
	
	public int NextSportCode() throws SQLException
	{
		String sql = "SELECT max(id_sport) + 1 AS NextCode FROM Sport";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		if (rs.next())
		{
			return rs.getInt("NextCode");
		}
		else
		{
			//Case of empty table
			return 1;
		}
	}
}
