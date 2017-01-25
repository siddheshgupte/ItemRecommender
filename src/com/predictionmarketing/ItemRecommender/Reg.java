package com.predictionmarketing.ItemRecommender;

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Reg extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reg frame = new Reg();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Reg() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("username");
		lblUsername.setBounds(10, 11, 63, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setBounds(10, 41, 63, 14);
		contentPane.add(lblPassword);
		
		JLabel lblConfirm = new JLabel("confirm");
		lblConfirm.setBounds(10, 75, 63, 14);
		contentPane.add(lblConfirm);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					if(con.getText().equals(passwordField.getText()))
					{
					BufferedReader br = new BufferedReader(new FileReader("data/userswpass.csv")) ;
					String line;
					int currid=1;
					while((line = br.readLine())!= null )
					{
						String values[] = line.split(",");
						 currid= Integer.parseInt(values[0]);
						
					}
				FileWriter fw = new FileWriter("data/userswpass.csv", true);
				String u=textField.getText();
				@SuppressWarnings("deprecation")
				String p=passwordField.getText();
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write((currid+1)+","+p+","+u+"\n");
				Reg.this.dispose();
				bw.close();
				br.close();
				Comrate c=new Comrate(currid+1);
				c.setVisible(true);
				}else
				{
					Invalidpass in=new Invalidpass();
					in.setVisible(true);
				}
					Reg.this.dispose();}
				catch(Exception e)
				{
					
				}
			}
		});
		btnNewButton.setBounds(79, 132, 89, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(79, 8, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(79, 36, 86, 20);
		contentPane.add(passwordField);
		
		con = new JPasswordField();
		con.setBounds(79, 72, 86, 20);
		contentPane.add(con);
	}
}
