package model;

public class Country 
{
	private String coi;
	private String name_country;
	
	public String getCoi() 
	{
		return coi;
	}
	public void setCoi(String coi) 
	{
		this.coi = coi;
	}
	public String getName_country() 
	{
		return name_country;
	}
	public void setName_country(String name_country) 
	{
		this.name_country = name_country;
	}

	@Override
	public String toString() 
	{
		return this.name_country;
	}
}
