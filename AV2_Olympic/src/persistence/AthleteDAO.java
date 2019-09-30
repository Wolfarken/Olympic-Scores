package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Athlete;
import model.Country;

public class AthleteDAO 
{
	public Connection connection;
	
	public AthleteDAO() throws ClassNotFoundException, SQLException
	{
		GenericDAO gDAO = new GenericDAO();
		connection = gDAO.getConnection();
	}
	
	
	public void insertAthlete(Athlete athlete, Country country) throws SQLException
	{
		String sql	 = "INSERT INTO Athlete VALUES (?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setInt(1, athlete.getCode_athlete());
		ps.setString(2, country.getCoi());
		ps.setString(3, athlete.getName_athlete());
		ps.setString(4, athlete.getGender_athlete());
		
		ps.execute();
		ps.close();
	}

	
	//	Single
	public Athlete QueryAthlete(Athlete athlete) throws SQLException
	{
		String sql = "SELECT code_athlete, coi, name_athlete, gender_athlete FROM Athlete WHERE code_athlete = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		ps.setInt(1, athlete.getCode_athlete());
		
		if (rs.next())
		{
			athlete.setCode_athlete(rs.getInt("code_athlete"));
			athlete.setCoi(rs.getString("coi"));
			athlete.setName_athlete(rs.getString("name_athlete"));
			athlete.setGender_athlete(rs.getString("gender_athlete"));
		}
		
		rs.close();
		ps.close();
		
		return athlete;
	}
	
	
	//	List
	public List<Athlete> QueryAthletes() throws SQLException
	{
		List<Athlete> listAthlete = new ArrayList<Athlete>();
		
		String sql = "SELECT code_athlete, coi, name_athlete, gender_athlete FROM Athlete ORDER BY coi, name_athlete, gender_athlete";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next())
		{
			Athlete athlete = new Athlete();
			athlete.setCode_athlete(rs.getInt("code_athlete"));
			athlete.setCoi(rs.getString("coi"));
			athlete.setName_athlete(rs.getString("name_athlete"));
			athlete.setGender_athlete(rs.getString("gender_athlete"));
			
			listAthlete.add(athlete);
		}
		
		rs.close();
		ps.close();
		
		return listAthlete;
	}
	
	
	public int NextAthleteCode() throws SQLException
	{
		String sql = "SELECT max(code_athlete) + 1 AS NextCode FROM Athlete";
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
