package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Athlete;
import model.Result;
import model.Sport;
import persistence.AthleteDAO;
import persistence.PhaseResultDAO;
import persistence.ResultDAO;
import persistence.SportDAO;
import view.Olympic.ActionEnum;
import view.Olympic.PhaseEnmu;

public class OlympicController implements ActionListener
{
	
	private JComboBox<Sport> 		comboSport;
	private JComboBox<Athlete> 		comboAthlete;
	private JComboBox<PhaseEnmu> 	comboPhase;
	private JTextField				textCountry;
	private JTextField				textSportGender;
	private JTextField				textAthleteGender;
	private JTable 					tableResult;
	
	
	//	Populate JComboBox Sport, Athlete on Olympic View
	public OlympicController(JComboBox<Sport> comboSport, JComboBox<Athlete> comboAthlete) 
	{		
		this.comboSport = comboSport;
		this.comboAthlete = comboAthlete;
	}


	//	Fill Gender Sport field
	public OlympicController(JComboBox<Sport> comboSport, JTextField textSportGender, JComboBox<PhaseEnmu> comboPhase, JTable tableResult) 
	{
		this.comboSport = comboSport;
		this.textSportGender = textSportGender;
		this.comboPhase = comboPhase;
		this.tableResult = tableResult;
	}
	
	
	//	Fill Country, Gender Athlete field
	public OlympicController(JComboBox<Athlete> comboAthlete, JTextField textCountry, JTextField textAthleteGender) 
	{
		this.comboAthlete = comboAthlete;
		this.textCountry = textCountry;
		this.textAthleteGender = textAthleteGender;
	}


	//	Fill JTable on Olympic View
	public OlympicController(JComboBox<Sport> comboSport, JComboBox<PhaseEnmu> comboPhase, JTable tableResult) 
	{
		this.comboSport = comboSport;
		this.comboPhase = comboPhase;
		this.tableResult = tableResult;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getActionCommand() == ActionEnum.comboSportAction.name())
		{
			Sport sport = (Sport) comboSport.getSelectedItem();
			SportFields(sport);
			TableResult();
		}
		
		if (e.getActionCommand() == ActionEnum.comboAthleteAction.name())
		{
			Athlete athlete = (Athlete) comboAthlete.getSelectedItem();
			AthleteFields(athlete);
		}
		
		if (e.getActionCommand() == ActionEnum.ButtonRegisterAction.name())
		{
			RegisterAthleteToSport();
		}

		if (e.getActionCommand() == ActionEnum.ButtonStartInitialPhaseAction.name())
		{
			StartInitialPhaseAction();
			TableResult();
		}
		
		if (e.getActionCommand() == ActionEnum.ButtonStartFinalPhaseAction.name())
		{
			StartFinalPhaseAction();
			TableResult();
		}
	}

	
	//	Fill Gender Sport field
	public void SportFields(Sport sport)
	{
		textSportGender.setText(String.valueOf(sport.getGender_sport()));;
	}
	
	
	//	Fill Country, Gender Athlete field
	public void AthleteFields(Athlete athlete)
	{
		textCountry.setText(String.valueOf(athlete.getCoi()));;
		textAthleteGender.setText(String.valueOf(athlete.getGender_athlete()));;
	}
	
	
	//	Register Athlete To Sport on PhaseResult table
	public void RegisterAthleteToSport()
	{
		Sport sport = new Sport();
		sport = (Sport) comboSport.getSelectedItem();
		
		Athlete athlete = new Athlete();
		athlete = (Athlete) comboAthlete.getSelectedItem();
		
		String exit = "";
		
		try
		{
			PhaseResultDAO phaseResultDAO = new PhaseResultDAO();
			exit = phaseResultDAO.RegisterAthleteToSport(sport, athlete);
		}
		catch (ClassNotFoundException | SQLException e)
		{
			exit = e.getMessage();
			e.printStackTrace();
		}
		finally
		{
			System.out.println(exit);
		}
	}
	
	
	//	Start Initial Olympic Phase
	public void StartInitialPhaseAction()
	{
		Sport sport = new Sport();
		sport = (Sport) comboSport.getSelectedItem();
		
		String phase = "Initial";
		
		try
		{
			ResultDAO resultDAO = new ResultDAO();
			resultDAO.StartInitialPhase(sport, phase);
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	//	Start Final Olympic Phase
	public void StartFinalPhaseAction()
	{
		Sport sport = new Sport();
		sport = (Sport) comboSport.getSelectedItem();
		
		String phase = "Final";
		
		try
		{
			ResultDAO resultDAO = new ResultDAO();
			resultDAO.StartFinalPhase(sport);
			
			resultDAO.StartInitialPhase(sport, phase);
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	//	Fills JTable on Olympic View
	public void TableResult()
	{
		Sport sport = new Sport();
		sport = (Sport) comboSport.getSelectedItem();
		
		Result resultPhase = new Result();
		resultPhase.setPhase((String) comboPhase.getSelectedItem().toString());
		
		if (tableResult != null)
		{
			DefaultTableModel defaultTableModel = (DefaultTableModel) tableResult.getModel();
			try
			{
				ResultDAO resultDAO = new ResultDAO();
				List<Result> listTableResult = resultDAO.AllTableResult(sport, resultPhase);
				
				if (defaultTableModel.getRowCount() > 0)
				{
					defaultTableModel.setRowCount(0);
				}
				
				for (Result result : listTableResult)
				{
					Object[] line = new Object[6];
//					line[0] = result.getAthlete().getCode_athlete();
					line[0] = result.getCode_athlete();
					line[1] = result.getCoi();
					line[2] = result.getPhase();
					line[3] = result.getTrial_round();
					line[4] = result.getResult();
					line[5] = result.getSituation();
					
					defaultTableModel.addRow(line);
				}
			}
			catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	

	
	
	
	// 	Populate JComboBox Athlete
	public void PopulateComboBoxAthlete()
	{
		try 
		{
			AthleteDAO athleteDAO = new AthleteDAO();
			List<Athlete> listAthlete = athleteDAO.QueryAthletes();
			
			if (comboAthlete.getItemCount() > 0)
			{
				comboAthlete.removeAllItems();
			}
			
			if (listAthlete != null)
			{
				for (Athlete athlete : listAthlete)
				{
					comboAthlete.addItem(athlete);
				}
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
	
	
	//	Populate JComboBox Sport
	public void PopulateComboBoxSport()
	{
		try 
		{
			SportDAO sportDAO = new SportDAO();
			List<Sport> listSport = sportDAO.QuerySports();
			
			if (comboSport.getItemCount() > 0)
			{
				comboSport.removeAllItems();
			}
			
			if (listSport != null)
			{
				for (Sport sport : listSport)
				{
					comboSport.addItem(sport);
				}
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
}
