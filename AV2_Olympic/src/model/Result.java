package model;

public class Result 
{
	private Athlete athlete;
	
	private int id_sport;
	private int code_athlete;
	private String coi;
	private String phase;
	private int trial_round;
	private String result;
	private String situation;
	
	public Athlete getAthlete() 
	{
		return athlete;
	}
	public void setAthlete(Athlete athlete) 
	{
		this.athlete = athlete;
	}
	
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
	public int getTrial_round() 
	{
		return trial_round;
	}
	public void setTrial_round(int trial_round) 
	{
		this.trial_round = trial_round;
	}
	public String getResult() 
	{
		return result;
	}
	public void setResult(String result) 
	{
		this.result = result;
	}
	public String getSituation() 
	{
		return situation;
	}
	public void setSituation(String situation) 
	{
		this.situation = situation;
	}
}
