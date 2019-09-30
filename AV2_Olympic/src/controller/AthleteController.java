package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import model.Athlete;
import model.Country;
import persistence.AthleteDAO;
import persistence.CountryDAO;
import view.AthleteView.GenderEnum;

public class AthleteController implements ActionListener
{

	private JTextField 				textCodeAthlete;
	private JTextField				textName;
	private JComboBox<Country> 		comboCountry;
	private JComboBox<GenderEnum>	comboGender;
	
	//	To insert a new Athlete
	public AthleteController(JTextField textCodeAthlete, JTextField textName, JComboBox<Country> comboCountry, JComboBox<GenderEnum> comboGender) 
	{
		this.textCodeAthlete = textCodeAthlete;
		this.textName = textName;
		this.comboCountry = comboCountry;
		this.comboGender = comboGender;
	}

	
	//	Set CodeAthlete on AthleteView
	public AthleteController(JTextField textCodeAthlete) 
	{
		this.textCodeAthlete = textCodeAthlete;
	}
	
	
	//	Populate JComboBox Country on AthleteView
	public AthleteController(JComboBox<Country> comboCountry) 
	{
		this.comboCountry = comboCountry;
	}



	//	Set CodeAthlete on AthleteView searching for last CodeAthlete on SQL 
	public void NextCode()
	{
		try 
		{
			AthleteDAO athleteDAO = new AthleteDAO();
			
			textCodeAthlete.setText(String.valueOf(athleteDAO.NextAthleteCode()));
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		InsertAthlete();
	}

	
	public void InsertAthlete()
	{
		Athlete athlete = new Athlete();
		int codeAthlete = Integer.parseInt(textCodeAthlete.getText());
		athlete.setCode_athlete(codeAthlete);
		
		Country country = new Country();
		country = (Country) comboCountry.getSelectedItem();
		
		athlete.setName_athlete((String) textName.getText());
		
		athlete.setGender_athlete((String) comboGender.getSelectedItem().toString());
		
		try
		{
			AthleteDAO athleteDAO = new AthleteDAO();
			athleteDAO.insertAthlete(athlete, country);
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			NextCode();
			comboCountry.setSelectedIndex(0);
			textName.setText("");
			comboGender.setSelectedIndex(0);
		}
	}
	
	
	
	public void PopulateComboBoxCountry()
	{
		try 
		{
			CountryDAO countryDAO = new CountryDAO();
			List<Country> listCountry = countryDAO.PopulateCountry();
			
			if (listCountry != null)
			{
				for (Country country : listCountry)
				{
					comboCountry.addItem(country);
				}
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
}
