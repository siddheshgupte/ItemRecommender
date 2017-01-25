package com.predictionmarketing.ItemRecommender;

import java.awt.EventQueue;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class rframe  {

	private JFrame frmRating;
	private JTextField id;
	private JTextField id1;
   
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)throws IOException {
		
		FileWriter fw = new FileWriter("C:\\Users\\siddhesh.gupte2468\\Desktop\\testcsv.csv", true);
        BufferedWriter bw = new BufferedWriter(fw);
	      
     
        //
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rframe window = new rframe();
					window.frmRating.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		bw.flush();
        bw.close();
	}

	/**
	 * Create the application.
	 */
	public rframe()throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws IOException{
		
	      

		frmRating = new JFrame();
		frmRating.setTitle("Rating");
		frmRating.setBounds(100, 100, 450, 300);
		frmRating.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRating.getContentPane().setLayout(null);
		
		id = new JTextField();
		id.setBounds(142, 42, 86, 20);
		frmRating.getContentPane().add(id);
		id.setColumns(10);
		
		id1 = new JTextField();
		id1.setBounds(142, 97, 86, 20);
		frmRating.getContentPane().add(id1);
		id1.setColumns(10);
		
		JLabel lblRating = new JLabel("Rating");
		lblRating.setBounds(50, 148, 46, 14);
		frmRating.getContentPane().add(lblRating);
		
		JLabel lblMovieId = new JLabel("Movie ID");
		lblMovieId.setBounds(50, 100, 58, 14);
		frmRating.getContentPane().add(lblMovieId);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setBounds(50, 45, 46, 14);
		frmRating.getContentPane().add(lblUserId);
		
		JSlider id2 = new JSlider();
		id2.setValue(0);
		id2.setPaintLabels(true);
		id2.setMajorTickSpacing(1);
		id2.setMinorTickSpacing(1);
		id2.setMaximum(5);
		id2.setBounds(130, 146, 200, 40);
		frmRating.getContentPane().add(id2);
		
		JButton btnSubmit = new JButton("submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				try{
				FileWriter fw = new FileWriter("C:\\Users\\siddhesh.gupte2468\\Desktop\\testcsv.csv", true);
				  BufferedWriter bw = new BufferedWriter(fw);
				  bw.write( id.getText()+",");
				  bw.write(id1.getText()+",");
				  bw.write( id2.getValue()+"\n");
				  
				  bw.flush();
			        bw.close();
				}
				catch(IOException ex){
					
					
				}
				
				}
			
		});
		btnSubmit.setBounds(139, 213, 89, 23);
		frmRating.getContentPane().add(btnSubmit);
	
	}
	
}

