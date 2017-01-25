package com.predictionmarketing.ItemRecommender;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
//import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame1 extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField pwdPassword;
	private JPasswordField pwdConfirm;
	private JTextField txtOccupation;
	private JTextField txtAge;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("username");
		lblUsername.setBounds(10, 11, 118, 29);
		frame.getContentPane().add(lblUsername);
		
		txtUsername = new JTextField();
		
		txtUsername.setBounds(87, 15, 86, 20);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setBounds(10, 51, 46, 14);
		frame.getContentPane().add(lblPassword);
		
		JLabel label = new JLabel("");
		label.setBounds(10, 91, 46, 14);
		frame.getContentPane().add(label);
		
		pwdPassword = new JPasswordField();
		
		pwdPassword.setBounds(84, 48, 89, 17);
		frame.getContentPane().add(pwdPassword);
		
		JLabel lblConfirm = new JLabel("confirm");
		lblConfirm.setBounds(10, 91, 46, 14);
		frame.getContentPane().add(lblConfirm);
		
		pwdConfirm = new JPasswordField();
		
		pwdConfirm.setBounds(87, 91, 86, 20);
		frame.getContentPane().add(pwdConfirm);
		
		JLabel lblOccupation = new JLabel("occupation");
		lblOccupation.setBounds(10, 128, 59, 14);
		frame.getContentPane().add(lblOccupation);
		
		txtOccupation = new JTextField();
	
		txtOccupation.setBounds(87, 125, 86, 20);
		frame.getContentPane().add(txtOccupation);
		txtOccupation.setColumns(10);
		
		JLabel lblGender = new JLabel("gender");
		lblGender.setBounds(10, 161, 46, 14);
		frame.getContentPane().add(lblGender);
		
		JRadioButton rdbtnMale = new JRadioButton("male");
		rdbtnMale.setBounds(87, 157, 109, 23);
		frame.getContentPane().add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("female");
		rdbtnFemale.setBounds(87, 183, 109, 23);
		frame.getContentPane().add(rdbtnFemale);
		
		JLabel lblAge = new JLabel("age");
		lblAge.setBounds(10, 221, 46, 14);
		frame.getContentPane().add(lblAge);
		
		txtAge = new JTextField();
		
		txtAge.setBounds(67, 218, 86, 20);
		frame.getContentPane().add(txtAge);
		txtAge.setColumns(10);
		
		JLabel lblZipCode = new JLabel("zip code");
		lblZipCode.setBounds(10, 246, 46, 14);
		frame.getContentPane().add(lblZipCode);
		
		textField = new JTextField();
		textField.setBounds(67, 243, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnRegister.setBounds(64, 306, 89, 23);
		frame.getContentPane().add(btnRegister);
	}

	
}
