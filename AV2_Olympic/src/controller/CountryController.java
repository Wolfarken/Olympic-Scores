package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JTextField;

import model.Country;
import persistence.CountryDAO;

public class CountryController implements ActionListener 
{
	
	private JTextField	textCoi;
	private JTextField	textName;
	
	public CountryController(JTextField textCoi, JTextField textName) 
	{
		this.textCoi = textCoi;
		this.textName = textName;
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		InsertCountry();
	}
	
	
	public void InsertCountry()
	{
		Country country = new Country();
		country.setCoi((String) textCoi.getText());
		
		country.setName_country((String) textName.getText());
		
		try
		{
			CountryDAO countryDAO = new CountryDAO();
			countryDAO.insertCountry(country);
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			textCoi.setText("");
			textName.setText("");
		}
	}
}
