package persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import model.Result;
import model.Sport;


public class ResultDAO 
{
	public Connection connection;
	
	public ResultDAO() throws ClassNotFoundException, SQLException
	{
		GenericDAO gDAO = new GenericDAO();
		connection = gDAO.getConnection();
	}
	
	
	public String StartInitialPhase(Sport sport, String phase) throws SQLException
	{
		String exit = "";
		String sql	 = "{CALL SP_InitialPhase(?,?,?)}";
		CallableStatement cs = connection.prepareCall(sql);
		
		//	Procedure parameters
		cs.setInt(1, sport.getId_sport());
		cs.setString(2, phase);
		
		cs.registerOutParameter(3, Types.VARCHAR);
		cs.execute();
		
		//	Procedure exit message
		exit = cs.getString(3);
		
		return exit;
	}
	
	
	public void StartFinalPhase(Sport sport) throws SQLException
	{
		String sql	 = "{CALL SP_EndPhase(?)}";
		CallableStatement cs = connection.prepareCall(sql);
		
		//	Procedure parameters
		cs.setInt(1, sport.getId_sport());
		
		cs.execute();
	}
	
	
	public List<Result> AllTableResult(Sport sport, Result resultPhase) throws SQLException
	{
		List<Result> listTableResult = new ArrayList<Result>();
		
		String sql = "{CALL SP_ShowResult(?,?)}";
		PreparedStatement ps = connection.prepareStatement(sql);
		
		//	Procedure parameters
		ps.setInt(1, sport.getId_sport());
		ps.setString(2, resultPhase.getPhase());
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next())
		{
			Result result = new Result();
			result.setId_sport(rs.getInt("id_sport"));
			result.setCode_athlete(rs.getInt("code_athlete"));
			result.setCoi(rs.getString("coi"));
			result.setPhase(rs.getString("phase"));
			result.setTrial_round(rs.getInt("trial_round"));
			result.setResult(rs.getString("result"));
			result.setSituation(rs.getString("chanceToFinish"));
			
			listTableResult.add(result);
		}
		
		rs.close();
		ps.close();
		
		return listTableResult;
	}
}
