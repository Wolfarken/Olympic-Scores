package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.CountryController;

public class CountryView extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	
	
	private JPanel panel;
	private JTextField textCoi;
	private JTextField textName;
	private JLabel labelCoi;
	private JLabel labelName;
	private JButton buttonInsertCountry;
	
	
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
						CountryView registerCountry = new CountryView();
						registerCountry.setTitle("LAB BD - AV2 Olympic - Register Country");
						registerCountry.setBounds(200, 500, 1000, 350);
						registerCountry.setVisible(true);
					} 
					catch (Exception e) 
					{
						e.printStackTrace();
					}
				}
			}
		);
	}
	
	
	
	public CountryView() 
	{
		//Panel setup
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(panel);
		panel.setLayout(null);
		
		//labelCoi setup
		labelCoi = new JLabel("COI: ");
		labelCoi.setBounds(20, 50, 80, 25);
		panel.add(labelCoi);
		
		//textCoi setup
		textCoi = new JTextField();
		textCoi.setBounds(100, 50, 50, 25);
		panel.add(textCoi);
		textCoi.setColumns(3);
		
		//labelName setup
		labelName = new JLabel("Name: ");
		labelName.setBounds(20, 100, 80, 25);
		panel.add(labelName);
		
		//textName setup
		textName = new JTextField();
		textName.setBounds(100, 100, 400, 25);
		panel.add(textName);
		textName.setColumns(3);
		
		
		
		//buttonInsertCountry setup
		buttonInsertCountry = new JButton("Register");
		buttonInsertCountry.setBounds(300, 150, 200, 25);
		panel.add(buttonInsertCountry);
		//buttonRegisterAthlete ActionListener
		ActionListener insertCountry = new CountryController(textCoi, textName);
		buttonInsertCountry.addActionListener(insertCountry);
	}
}
