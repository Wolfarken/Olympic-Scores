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

import controller.SportController;
import view.AthleteView.GenderEnum;

public class SportView extends JFrame implements ActionListener
{
	public enum MeasurementEnum {Metric, Time}

	private static final long serialVersionUID = 1L;
	
	
	
	private JPanel panel;
	private JComboBox<GenderEnum> comboGender;
	private JComboBox<MeasurementEnum> comboMeasurement;
	private JTextField textIdSport;
	private JTextField textName;
	private JLabel labelId;
	private JLabel labelName;
	private JLabel labelGender;
	private JLabel labelMeasurementType;
	private JButton buttonInsertSport;
	
	
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
						SportView registerSport = new SportView();
						registerSport.setTitle("LAB BD - AV2 Olympic - Register Sport");
						registerSport.setBounds(200, 500, 1000, 350);
						registerSport.setVisible(true);
					} 
					catch (Exception e) 
					{
						e.printStackTrace();
					}
				}
			}
		);
	}
	
	
	
	public SportView() 
	{
		//Panel setup
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(panel);
		panel.setLayout(null);
		
		//labelId setup
		labelId = new JLabel("ID: ");
		labelId.setBounds(20, 50, 80, 20);
		panel.add(labelId);
		
		//textIdSport setup
		textIdSport = new JTextField();
		textIdSport.setBounds(150, 50, 50, 25);
		textIdSport.setEnabled(false);
		panel.add(textIdSport);
		textIdSport.setColumns(3);
		
		//labelName setup
		labelName = new JLabel("Name: ");
		labelName.setBounds(20, 100, 80, 20);
		panel.add(labelName);
		
		//textName setup
		textName = new JTextField();
		textName.setBounds(150, 100, 400, 25);
		panel.add(textName);
		textName.setColumns(3);
		
		//labelGender setup
		labelGender = new JLabel("Gender: ");
		labelGender.setBounds(20, 150, 80, 20);
		panel.add(labelGender);
		
		//comboGender setup
		comboGender = new JComboBox<GenderEnum>();
		comboGender.setModel(new DefaultComboBoxModel<>(GenderEnum.values()));
		comboGender.setBounds(150, 150, 80, 25);
		panel.add(comboGender);
		
		//labelMeasurementType setup
		labelMeasurementType = new JLabel("Measurement Type: ");
		labelMeasurementType.setBounds(20, 200, 150, 20);
		panel.add(labelMeasurementType);
		
		//comboMeasurement setup
		comboMeasurement = new JComboBox<MeasurementEnum>();
		comboMeasurement.setModel(new DefaultComboBoxModel<>(MeasurementEnum.values()));
		comboMeasurement.setBounds(150, 200, 400, 25);
		panel.add(comboMeasurement);
		
		
		
		//buttonInsertSport setup
		buttonInsertSport = new JButton("Register");
		buttonInsertSport.setBounds(350, 250, 200, 25);
		panel.add(buttonInsertSport);
		//buttonRegisterAthlete ActionListener
		ActionListener insertSport = new SportController(textIdSport, textName, comboGender, comboMeasurement);
		buttonInsertSport.addActionListener(insertSport);
		
		
		
		SportController sportController = new SportController(textIdSport);
		sportController.NextCode();
	}
}
