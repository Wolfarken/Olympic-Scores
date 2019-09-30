package model;

public class Sport 
{
	private int id_sport;
	private String name_sport;
	private String gender_sport;
	private String measurementType_sport;
	
	public int getId_sport() 
	{
		return id_sport;
	}
	public void setId_sport(int id_sport) 
	{
		this.id_sport = id_sport;
	}
	public String getName_sport() 
	{
		return name_sport;
	}
	public void setName_sport(String name_sport) 
	{
		this.name_sport = name_sport;
	}
	public String getGender_sport() 
	{
		return gender_sport;
	}
	public void setGender_sport(String gender_sport) 
	{
		this.gender_sport = gender_sport;
	}
	public String getMeasurementType_sport() 
	{
		return measurementType_sport;
	}
	public void setMeasurementType_sport(String measurementType_sport) 
	{
		this.measurementType_sport = measurementType_sport;
	}
	
	@Override
	public String toString() 
	{
		return this.name_sport;
	}
}
