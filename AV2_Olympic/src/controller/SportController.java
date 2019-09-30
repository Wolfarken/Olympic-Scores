package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import model.Sport;
import persistence.SportDAO;
import view.AthleteView.GenderEnum;
import view.SportView.MeasurementEnum;

public class SportController implements ActionListener 
{

	private JTextField					textIdSport;
	private JTextField					textName;
	private JComboBox<GenderEnum> 		comboGender;
	private JComboBox<MeasurementEnum> 	comboMeasurement;
	
	
	public SportController(JTextField textIdSport, JTextField textName, JComboBox<GenderEnum> comboGender, JComboBox<MeasurementEnum> comboMeasurement) 
	{
		this.textIdSport = textIdSport;
		this.textName = textName;
		this.comboGender = comboGender;
		this.comboMeasurement = comboMeasurement;
	}

	
	public SportController(JTextField textIdSport) 
	{
		this.textIdSport = textIdSport;
	}
	
	
	
	//	Set IdSport on SportView searching for last IdSport on SQL
	public void NextCode()
	{
		try 
		{
			SportDAO sportDAO = new SportDAO();
			
			textIdSport.setText(String.valueOf(sportDAO.NextSportCode()));
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}



	@Override
	public void actionPerformed(ActionEvent e) 
	{
		InsertSport();
	}
	
	
	public void InsertSport()
	{
		Sport sport = new Sport();
		int idSport = Integer.parseInt(textIdSport.getText());
		sport.setId_sport(idSport);
		
		sport.setName_sport((String) textName.getText());
		
		sport.setGender_sport((String) comboGender.getSelectedItem().toString());
		
		sport.setMeasurementType_sport((String) comboMeasurement.getSelectedItem().toString());
		
		try
		{
			SportDAO sportDAO = new SportDAO();
			sportDAO.insertSport(sport);
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			NextCode();
			textName.setText("");
			comboGender.setSelectedIndex(0);
			comboMeasurement.setSelectedIndex(0);
		}
	}
}
