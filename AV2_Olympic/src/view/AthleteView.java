package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.AthleteController;
import model.Country;

public class AthleteView extends JFrame implements ActionListener
{
	public enum GenderEnum  { M, F; }

	private static final long serialVersionUID = 1L;
	
	
	
	private JPanel panel;
	private JComboBox<Country> comboCountry;
	private JComboBox<GenderEnum> comboGender;
	private JTextField textCodeAthlete;
	private JTextField textName;
	private JLabel labelCodeAthlete;
	private JLabel labelName;
	private JLabel labelCountry;
	private JLabel labelGender;
	private JButton buttonInsertAthlete;
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		EventQueue.invokeLater
		(new Runnable() 
			{
				public void run() 
				{
					try 
					{
						AthleteView registerAthlete = new AthleteView();
						registerAthlete.setTitle("LAB BD - AV2 Olympic - Register Athlete");
						registerAthlete.setBounds(200, 500, 1000, 350);
						registerAthlete.setVisible(true);
					} 
					catch (Exception e) 
					{
						e.printStackTrace();
					}
				}
			}
		);
	}
	
	
	
	public AthleteView() 
	{
		//Panel setup
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(panel);
		panel.setLayout(null);
		
		//labelCodeAthlete setup
		labelCodeAthlete = new JLabel("Code Athlete: ");
		labelCodeAthlete.setBounds(20, 50, 80, 25);
		panel.add(labelCodeAthlete);
		
		//textCodeAthlete setup
		textCodeAthlete = new JTextField();
		textCodeAthlete.setBounds(100, 50, 50, 25);
		textCodeAthlete.setEnabled(false);
		panel.add(textCodeAthlete);
		textCodeAthlete.setColumns(3);
		
		//labelName setup
		labelName = new JLabel("Name: ");
		labelName.setBounds(20, 100, 80, 25);
		panel.add(labelName);
		
		//textName setup
		textName = new JTextField();
		textName.setBounds(100, 100, 400, 25);
		panel.add(textName);
		textName.setColumns(3);
		
		//labelCountry setup
		labelCountry = new JLabel("Country: ");
		labelCountry.setBounds(20, 150, 80, 25);
		panel.add(labelCountry);
		
		//comboAthlete setup
		comboCountry = new JComboBox<Country>();
		comboCountry.setBounds(100, 150, 400, 25);
		panel.add(comboCountry);
		
		//labelGender setup
		labelGender = new JLabel("Gender: ");
		labelGender.setBounds(20, 200, 80, 25);
		panel.add(labelGender);
		
		//comboGender setup
		comboGender = new JComboBox<GenderEnum>();
		comboGender.setModel(new DefaultComboBoxModel<>(GenderEnum.values()));
		comboGender.setBounds(100, 200, 80, 25);
		panel.add(comboGender);
		
		
		
		//buttonInsertAthlete setup
		buttonInsertAthlete = new JButton("Register");
		buttonInsertAthlete.setBounds(300, 250, 200, 25);
		panel.add(buttonInsertAthlete);
		//buttonRegisterAthlete ActionListener
		ActionListener insertAthlete = new AthleteController(textCodeAthlete, textName, comboCountry, comboGender);
		buttonInsertAthlete.addActionListener(insertAthlete);
		
		
		
		AthleteController athleteControllerTextField = new AthleteController(textCodeAthlete);
		athleteControllerTextField.NextCode();
		
		AthleteController athleteControllerComboBox = new AthleteController(comboCountry);
		athleteControllerComboBox.PopulateComboBoxCountry();
	}
}
