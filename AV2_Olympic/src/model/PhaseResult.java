package model;

public class PhaseResult 
{	
	private int id_sport;
	private int code_athlete;
	private String coi;
	private String phase;
	
	public int getId_sport() 
	{
		return id_sport;
	}
	public void setId_sport(int id_sport) 
	{
		this.id_sport = id_sport;
	}
	public int getCode_athlete() 
	{
		return code_athlete;
	}
	public void setCode_athlete(int code_athlete) 
	{
		this.code_athlete = code_athlete;
	}
	public String getCoi() 
	{
		return coi;
	}
	public void setCoi(String coi) 
	{
		this.coi = coi;
	}
	public String getPhase() 
	{
		return phase;
	}
	public void setPhase(String phase) 
	{
		this.phase = phase;
	}
}
