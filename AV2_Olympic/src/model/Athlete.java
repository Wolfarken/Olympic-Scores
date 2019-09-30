package model;

public class Athlete 
{
	private int code_athlete;
	private String coi;
	private String name_athlete;
	private String gender_athlete;
	
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
	public void setCoi(String string) 
	{
		this.coi = string;
	}
	public String getName_athlete() 
	{
		return name_athlete;
	}
	public void setName_athlete(String name_athlete) 
	{
		this.name_athlete = name_athlete;
	}
	public String getGender_athlete() 
	{
		return gender_athlete;
	}
	public void setGender_athlete(String gender_athlete) 
	{
		this.gender_athlete = gender_athlete;
	}
	
	@Override
	public String toString() 
	{
		return this.name_athlete;
	}
}
