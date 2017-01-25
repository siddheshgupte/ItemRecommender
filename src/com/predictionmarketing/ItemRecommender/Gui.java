package com.predictionmarketing.ItemRecommender;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
//import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;



public class Gui {
	//private JPanel contentPane;
	private static JTextField userField;
	private static JPasswordField passField;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args)throws Exception {
		Scanner sc=new Scanner(System.in);

		BufferedReader br = new BufferedReader(new FileReader("data/testformovies.csv")) ;
		BufferedWriter bw = new BufferedWriter(new FileWriter("data/numOfRatings.csv"));
		
		
		bw.close();
		sc.close();
		br.close();
		login nf1=new login();
		nf1.setTitle("Login");
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(89, 62, 80, 14);
		nf1.getContentPane().add(lblUsername);
		
		userField = new JTextField();
		userField.setBounds(199, 59, 86, 20);
		nf1.getContentPane().add(userField);
		userField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(90, 120, 79, 14);
		nf1.getContentPane().add(lblPassword);
		
		passField = new JPasswordField();
		passField.setBounds(199, 117, 86, 20);
		nf1.getContentPane().add(passField);
		nf1.setVisible(true);
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Reg r=new Reg();
				r.setVisible(true);
			}
		});
		btnRegister.setBounds(271, 193, 89, 23);
		nf1.getContentPane().add(btnRegister);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				try{
					BufferedReader br = new BufferedReader(new FileReader("data/userswpass.csv")) ;
					String line;
					int id=0;
					boolean flag1=false;
					if((userField.getText()).equalsIgnoreCase("Admin"))
						if((passField.getText()).equalsIgnoreCase("Admin"))
						{
							addMovies a=new addMovies();
							a.setVisible(true);
						}
					while((line = br.readLine())!= null )
					{
						String values[] = line.split(",");
						 if(values[2].equalsIgnoreCase(userField.getText()))
						 {	
							 System.out.println(flag1);
							 if(values[1].equals(passField.getText()))
							 {
								 flag1=true;
							 id=Integer.parseInt(values[0]);
							 nf1.dispose();
							 break;
							 }
							 
							
							 
						 }
						
					}
					if(flag1)
					{			
												
						Welcome frame1 = new Welcome(userField.getText(),id,1);
						frame1.setVisible(true);
						
						
					}
					else
					{ 
						if((userField.getText()).equalsIgnoreCase("Admin"))
						{	if((passField.getText()).equalsIgnoreCase("Admin"))
							{
							}
						}
						else{
						Invalid emp = new Invalid();
					emp.setVisible(true);
						}
					}
					br.close();
					
					
					
					
				}
				catch(IOException ex){
					
					
				}
			
				}
				
			
		});
		btnLogin.setBounds(133, 193, 89, 23);
		nf1.getContentPane().add(btnLogin);
		
		
	
		
			}
}
