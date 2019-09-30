package view;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.OlympicController;
import model.Athlete;
import model.Sport;

public class Olympic extends JFrame
{
	public enum ActionEnum 	{ButtonStartInitialPhaseAction, ButtonStartFinalPhaseAction, ButtonRegisterAction, comboSportAction, comboAthleteAction}
	public enum PhaseEnmu 	{Initial, Final}
	
	private static final long serialVersionUID = 1L;

	
	
	private JPanel panel;
	private JComboBox<Sport> comboSport;
	private JComboBox<Athlete> comboAthlete;
	private JComboBox<PhaseEnmu> comboPhase;
	private JTextField textCountry;
	private JTextField textSportGender;
	private JTextField textAthleteGender;
	private JLabel labelSport;
	private JLabel labelAthlete;
	private JLabel labelCountry;
	private JLabel labelGender;
	private JLabel labelPhase;
	private JButton buttonStartInitialPhase;
	private JButton buttonStartFinalPhase;
	private JButton buttonRegisterAthleteToSport;
	private JButton buttonRegisterAthlete;
	private JButton buttonRegisterSport;
	private JButton buttonRegisterCountry;
	private JTable tableResult;
	private DefaultTableModel defaultTableModel;
	private JScrollPane scrollResult;
	
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater
		(new Runnable() 
			{
				public void run() 
				{
					try 
					{
						Olympic window = new Olympic();
						window.setTitle("LAB BD - AV2 Olympic");
						window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						window.setBounds(200, 150, 1000, 500);
						window.setVisible(true);
					} 
					catch (Exception e) 
					{
						e.printStackTrace();
					}
				}
			}
		);
	}
	
	
	
	public Olympic()
	{
		//Panel setup
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(panel);
		panel.setLayout(null);
		
		//labelSport setup
		labelSport = new JLabel("Sport: ");
		labelSport.setBounds(20, 50, 80, 25);
		panel.add(labelSport);
		
		//comboSport setup
		comboSport = new JComboBox<Sport>();
		comboSport.setBounds(100, 50, 400, 25);
		panel.add(comboSport);
		
		//labelGenderSport setup
		labelGender = new JLabel("Gender: ");
		labelGender.setBounds(520, 50, 50, 20);
		panel.add(labelGender);
		
		//textSportGender setup
		textSportGender = new JTextField();
		textSportGender.setBounds(570, 50, 50, 25);
		textSportGender.setEnabled(false);
		panel.add(textSportGender);
		textSportGender.setColumns(3);
		
		//labelAthlete setup
		labelAthlete = new JLabel("Athlete: ");
		labelAthlete.setBounds(20, 100, 80, 20);
		panel.add(labelAthlete);
		
		//comboAthlete setup
		comboAthlete = new JComboBox<Athlete>();
		comboAthlete.setBounds(100, 100, 400, 25);
		panel.add(comboAthlete);
		
		//labelCountry setup
		labelCountry = new JLabel("Country: ");
		labelCountry.setBounds(640, 100, 50, 20);
		panel.add(labelCountry);
		
		//textCountry setup
		textCountry = new JTextField();
		textCountry.setBounds(690, 100, 50, 25);
		textCountry.setEnabled(false);
		panel.add(textCountry);
		textCountry.setColumns(3);
		
		//labelGenderAthlete setup
		labelGender = new JLabel("Gender: ");
		labelGender.setBounds(520, 100, 50, 20);
		panel.add(labelGender);
		
		//textAthleteGender setup
		textAthleteGender = new JTextField();
		textAthleteGender.setBounds(570, 100, 50, 25);
		textAthleteGender.setEnabled(false);
		panel.add(textAthleteGender);
		textAthleteGender.setColumns(3);
		
		//labelPhase setup
		labelPhase = new JLabel("Phase: ");
		labelPhase.setBounds(640, 50, 50, 20);
		panel.add(labelPhase);
		
		//comboPhase setup
		comboPhase = new JComboBox<PhaseEnmu>();
		comboPhase.setModel(new DefaultComboBoxModel<>(PhaseEnmu.values()));
		comboPhase.setBounds(690, 50, 200, 25);
		panel.add(comboPhase);
		
		//comboAthlete ActionListener
		ActionListener getAthleteGender = new OlympicController(comboAthlete, textCountry, textAthleteGender);
		comboAthlete.setActionCommand(ActionEnum.comboAthleteAction.name());
		comboAthlete.addActionListener(getAthleteGender);


		
		//scrollVerTotal setup
		scrollResult = new JScrollPane();
		scrollResult.setBounds(180, 200, 780, 250);
		panel.add(scrollResult);
		
		//tableVerSport setup
		tableResult = new JTable();
		scrollResult.setViewportView(tableResult);
		defaultTableModel = new DefaultTableModel (new Object[][] {},
													new String[] {"Athlete", "Country", "Phase", "Trial Round", "Result", "Situation"});
		tableResult.setModel(defaultTableModel);
		tableResult.getColumnModel().getColumn(0).setPreferredWidth(300);
		tableResult.getColumnModel().getColumn(1).setPreferredWidth(100);
		tableResult.getColumnModel().getColumn(2).setPreferredWidth(50);
		tableResult.getColumnModel().getColumn(3).setPreferredWidth(25);
		tableResult.getColumnModel().getColumn(4).setPreferredWidth(100);
		tableResult.getColumnModel().getColumn(5).setPreferredWidth(50);
		
		//comboSport ActionListener
		ActionListener getSportGender = new OlympicController(comboSport, textSportGender, comboPhase, tableResult);
		comboSport.setActionCommand(ActionEnum.comboSportAction.name());
		comboSport.addActionListener(getSportGender);
		
		
		
		//buttonStartInitialPhase setup
		buttonStartInitialPhase = new JButton("Start Initial Phase");
		buttonStartInitialPhase.setBounds(10, 250, 150, 25);
		panel.add(buttonStartInitialPhase);
		//buttonRegisterAthlete ActionListener
		ActionListener startInitialPhase = new OlympicController(comboSport, comboPhase, tableResult);
		buttonStartInitialPhase.setActionCommand(ActionEnum.ButtonStartInitialPhaseAction.name());
		buttonStartInitialPhase.addActionListener(startInitialPhase);
		
		//buttonStartFinalPhase setup
		buttonStartFinalPhase = new JButton("Start Final Phase");
		buttonStartFinalPhase.setBounds(10, 300, 150, 25);
		panel.add(buttonStartFinalPhase);
		//buttonRegisterAthlete ActionListener
		ActionListener startFinalPhase = new OlympicController(comboSport, comboPhase, tableResult);
		buttonStartFinalPhase.setActionCommand(ActionEnum.ButtonStartFinalPhaseAction.name());
		buttonStartFinalPhase.addActionListener(startFinalPhase);
		
		//buttonRegisterAthleteToSport setup
		buttonRegisterAthleteToSport = new JButton("Register Athlete to the selected Sport");
		buttonRegisterAthleteToSport.setBounds(100, 150, 250, 25);
		panel.add(buttonRegisterAthleteToSport);
		//buttonRegisterAthlete ActionListener
		ActionListener registerAthleteToSport = new OlympicController(comboSport, comboAthlete);
		buttonRegisterAthleteToSport.setActionCommand(ActionEnum.ButtonRegisterAction.name());
		buttonRegisterAthleteToSport.addActionListener(registerAthleteToSport);
		
		//buttonRegisterAthlete setup
		buttonRegisterAthlete = new JButton("New athlete");
		buttonRegisterAthlete.setBounds(0, 0, 200, 25);
		panel.add(buttonRegisterAthlete);
		//buttonRegisterAthlete ActionListener
		ActionListener registerAthlete = new AthleteView();
		buttonRegisterAthlete.addActionListener(registerAthlete);
		
		//buttonRegisterSport setup
		buttonRegisterSport = new JButton("New sport");
		buttonRegisterSport.setBounds(200, 0, 200, 25);
		panel.add(buttonRegisterSport);
		//buttonRegisterSport ActionListener
		ActionListener registerSport = new SportView();
		buttonRegisterSport.addActionListener(registerSport);
		
		//buttonRegisterCountry setup
		buttonRegisterCountry = new JButton("New country");
		buttonRegisterCountry.setBounds(400, 0, 200, 25);
		panel.add(buttonRegisterCountry);
		//buttonRegisterCountry ActionListener
		ActionListener registerCountry = new CountryView();
		buttonRegisterCountry.addActionListener(registerCountry);
		
		
		
		OlympicController olympicController = new OlympicController(comboSport, comboAthlete);
		olympicController.PopulateComboBoxAthlete();
		olympicController.PopulateComboBoxSport();
	}
}
