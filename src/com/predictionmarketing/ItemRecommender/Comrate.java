package com.predictionmarketing.ItemRecommender;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;

public class Comrate extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Comrate frame = new Comrate();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	String s5=null;
	int moid=0;
	
	public Comrate(int id) {
		setTitle("Rate");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		String s4=null;
		
		try{
		BufferedReader br = new BufferedReader(new FileReader("data/testformovies.csv")) ;
		String line;
		int currid=1;
		while((line = br.readLine())!= null )
		{
			String values[] = line.split(",");
			 currid= Integer.parseInt(values[0]);
			
		}
		Random rn=new Random ();
		 moid=rn.nextInt(999);
		
		System.out.println(moid);
		BufferedReader br2 = new BufferedReader(new FileReader("data/testformovies.csv"));
    	while((line = br2.readLine())!= null )
    	{
    		String values5[]=line.split(",");
    		String id10=Integer.toString(moid);
    		if(id10.equals((values5[0])))
    		{	
    			 s4=values5[1];
    			 if(values5[2].contains("The"))
    			 {
    				 s5=values5[4];
    			 }
    			 else
    				 s5=values5[3];
 
    	    }
        }
    	br2.close();
		br.close();
		}
		catch(Exception e)
		{
		}
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(118, 56, 166, 14);
		contentPane.add(lblNewLabel);
		lblNewLabel.setText(s4);
		
		JSlider slider = new JSlider();
		slider.setMajorTickSpacing(1);
		slider.setPaintLabels(true);
		slider.setSnapToTicks(true);
		slider.setMinorTickSpacing(1);
		slider.setMaximum(5);
		slider.setValue(0);
		slider.setBounds(101, 100, 200, 45);
		contentPane.add(slider);
		System.out.println(s5);
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					try{
				
				FileWriter fw = new FileWriter("data/movies.csv", true);
				String u=Integer.toString(id);
					String p=Integer.toString(moid);
				BufferedWriter bw = new BufferedWriter(fw);
				String r=Integer.toString(slider.getValue());
				bw.write("\n"+u+","+p+","+r);
				Comrate.this.dispose();
				/*this*/bw.close();
				Gui2 g=new Gui2();
				g.setVisible(true);
					}
					catch(Exception e){
						
					}
				}
		});
		
		btnSubmit.setBounds(161, 184, 89, 23);
		contentPane.add(btnSubmit);
		
		JButton btnNewButton = new JButton("Link");
		btnNewButton.addActionListener(new ActionListener() {
			

				public void open(String url)
				{
					try{
						java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
					}catch(java.io.IOException e)
					{
						
					}
				}
				public void actionPerformed(ActionEvent e) {
					
					try{
						
					
					open(s5);
					}
					catch(Exception exx)
					{
						
					}
				}
			
		});
		btnNewButton.setBounds(321, 52, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblUserId = new JLabel("User id");
		lblUserId.setBounds(10, 11, 46, 14);
		contentPane.add(lblUserId);
		
		JLabel lab1 = new JLabel("New label");
		lab1.setBounds(79, 11, 46, 14);
		contentPane.add(lab1);
		String s=Integer.toString(id);
		lab1.setText(s);
	}
}
