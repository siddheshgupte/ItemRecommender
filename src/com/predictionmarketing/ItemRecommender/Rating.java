package com.predictionmarketing.ItemRecommender;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.awt.event.ActionEvent;


public class Rating extends JFrame {
	private String user;
	private String mid;
	private int id4;
	private JPanel contentPane;
	private JTextField id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		       
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Rating frame = new Rating();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});}
	

	/**
	 * Create the frame.
	 */
	public Rating(String usr,int id,String mid) {
		
		 this.user=usr;
		this.id4=id;
		this.mid=mid;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserId = new JLabel("user id");
		lblUserId.setBounds(25, 24, 54, 14);
		contentPane.add(lblUserId);
		
		JLabel lblMovieId = new JLabel("movie id");
		lblMovieId.setBounds(25, 71, 60, 14);
		contentPane.add(lblMovieId);
		
		JSlider id2 = new JSlider();
		id2.setValue(0);
		id2.setBounds(113, 131, 200, 26);
		contentPane.add(id2);
		
		//JSlider slider = new JSlider();
		id2.setPaintLabels(true);
		id2.setMajorTickSpacing(1);
		id2.setMinorTickSpacing(1);
		id2.setMaximum(5);
		id2.setBounds(130, 146, 200, 40);
		
		

			
		
	/*	id = new JTextField();
		id.setBounds(113, 21, 86, 20);
		contentPane.add(id);
		id.setColumns(10);
		*/

		JLabel lblNewLabel = new JLabel("Rating");
		lblNewLabel.setBounds(25, 131, 46, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			     try{
			    	 FileWriter fw=new FileWriter("data/movies.csv",true);
			    	 BufferedWriter bw=new BufferedWriter(fw);
			    	 bw.write(id4+","+mid+","+id2.getValue()+"\n");
			    	
			    	bw.flush();
			    	 bw.close();
			    	
			    	 Rating.this.dispose();
			    	 Welcome wc = new Welcome(user,id4,1);
					 wc.setVisible(true);
			    	 
			     }catch(IOException ex)
			     {
			    	 
			     }
			}

			
		});
		btnNewButton.setBounds(110, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblId = new JLabel("id");
		lblId.setBounds(128, 24, 46, 14);
		contentPane.add(lblId);
		String s=Integer.toString(id4);
		lblId.setText(s);
		
		JLabel lblMid = new JLabel("mid");
		lblMid.setBounds(130, 71, 46, 14);
		contentPane.add(lblMid);
		lblMid.setText(mid);
		
	
		
		
	
	}
}
