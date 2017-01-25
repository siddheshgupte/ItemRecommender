package com.predictionmarketing.ItemRecommender;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Gui2 extends JFrame {

	private JPanel contentPane;
	private JTextField u;
	private JPasswordField p;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		login nf1=new login();
		nf1.setTitle("Login");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui2 frame = new Gui2();
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
	public Gui2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(90, 72, 86, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(90, 119, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		u = new JTextField();
		u.setBounds(234, 69, 86, 20);
		contentPane.add(u);
		u.setColumns(10);
		
		JButton l = new JButton("Login");
		l.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try{
					BufferedReader br = new BufferedReader(new FileReader("data/userswpass.csv")) ;
					String line;
					int id=0;
					boolean flag=false;
					while((line = br.readLine())!= null )
					{
						String values[] = line.split(",");
						 if(values[2].equalsIgnoreCase(u.getText()))
						 {
							 if(values[1].equals(p.getPassword()));
							 flag=true;
							 id=Integer.parseInt(values[0]);
							 Gui2.this.dispose();
							 break;
						 }
						
					}
					if(flag)
					{
						
						
						
						Welcome frame1 = new Welcome(u.getText(),id,0);
						frame1.setVisible(true);
						
						
					}
					else
					{ Invalid emp = new Invalid();
					emp.setVisible(true);
					}
					br.close();
				}
				catch(IOException ex){
					
					
				}
			
				}
				
				
		
		});
		l.setBounds(141, 191, 89, 23);
		contentPane.add(l);
		
		p = new JPasswordField();
		p.setBounds(234, 116, 86, 20);
		contentPane.add(p);
	}
}
