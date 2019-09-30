package persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import model.Athlete;
import model.Sport;


public class PhaseResultDAO 
{
	public Connection connection;
	
	public PhaseResultDAO() throws ClassNotFoundException, SQLException
	{
		GenericDAO gDAO = new GenericDAO();
		connection = gDAO.getConnection();
	}
	
	
	public String RegisterAthleteToSport(Sport sport, Athlete athlete) throws SQLException
	{
		String exit = "";
		String sql	 = "{CALL SP_Olympic(?,?,?,?)}";
		CallableStatement cs = connection.prepareCall(sql);
		
		//	Procedure parameters
		cs.setInt(1, sport.getId_sport());
		cs.setInt(2, athlete.getCode_athlete());
		cs.setString(3, athlete.getCoi());
		
		cs.registerOutParameter(4, Types.VARCHAR);
		cs.execute();
		
		//	Procedure exit message
		exit = cs.getString(4);
		
		return exit;
	}
}
