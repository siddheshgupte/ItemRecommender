package com.predictionmarketing.ItemRecommender;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;

//import java.awt.BorderLayout;
//import java.awt.EventQueue;

import javax.swing.JFrame;
//import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import org.apache.mahout.cf.taste.recommender.RecommendedItem;

public class Welcome extends JFrame {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String user;
	private int id;
	private String url;
	

	/**
	 * Launch the application.
	 */



	/**
	 * Create the frame.
	 */
	
	public Welcome(String usr,int id,int flag) {

		Scanner sc=new Scanner(System.in);
		int a[]=new int[5];
		try{
		BufferedReader br = new BufferedReader(new FileReader("data/testformovies.csv")) ;
		String line;
		int currid=1;
		while((line = br.readLine())!= null )
		{
			String values[] = line.split(",");
			 currid= Integer.parseInt(values[0]);
			
			
		}
		

		int count=0;
		for(int i=currid;i>(currid-5);i--)
		{
			a[count++]=i;
		}
		
		sc.close();
		br.close();
		BufferedReader br2 = new BufferedReader(new FileReader("data/movies.csv")) ;
		String line2;
		int nor=0;
		String mov="more than 5 rated";
		int rat=0;
		while((line2 = br2.readLine())!= null )
		{
			String values2[] = line2.split(",");
			String s=Integer.toString(id);
			if(s.equals(values2[0]))
			{
				nor++;
				int r=Integer.parseInt(values2[2]);
				if(nor<5)
				if(r>rat)
				{
					mov=values2[1];
					rat=r;
					flag=0;
					this.id=Integer.parseInt(mov);
				}
			}
			
			
		}
				System.out.println("highest rated movie id:"+mov);
				
		System.out.println("Number of ratings given"+nor);
		br2.close();
		
		}
		catch(Exception e)
		{
			
		}
		
		this.user=usr;
		this.id=id;
		
		
		
		setTitle("Welcome");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 687);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHello = new JLabel("Hello");
		lblHello.setBounds(126, 14, 63, 17);
		contentPane.add(lblHello);
		
		JLabel lblRecentMovies = new JLabel("Recent movies");
		lblRecentMovies.setBounds(68, 66, 100, 33);
		contentPane.add(lblRecentMovies);
		
		JLabel lblRecommendedMoviesFor = new JLabel("Recommended movies for you");
		lblRecommendedMoviesFor.setBounds(20, 312, 248, 14);
		contentPane.add(lblRecommendedMoviesFor);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(44, 282, 424, 2);
		contentPane.add(separator);
		
		JLabel lbl = new JLabel("New label");
		lbl.setBounds(201, 15, 233, 14);
		contentPane.add(lbl);
		lbl.setText(user);
		
		JLabel Label = new JLabel("New label");
		Label.setBounds(201, 40, 46, 14);
		contentPane.add(Label);
		String idd=Integer.toString(id);
		Label.setText(idd);
		
		JLabel lblYourId = new JLabel("Your id");
		lblYourId.setBounds(126, 40, 46, 14);
		contentPane.add(lblYourId);
		String iddqdidkfa[]=new String[5];
		for(int i=0;i<5;i++)
		{
			iddqdidkfa[i]=Integer.toString(a[i]);
		}
		String url[]=new String [5];
		String name[]=new String[5];
		
		for(int i=0;i<5;i++)
		{
			String mid=Integer.toString(a[i]);
			try{
			BufferedReader br = new BufferedReader(new FileReader("data/testformovies.csv")) ;
			String line;
			
			while((line = br.readLine())!= null )
			{
				String values[] = line.split(",");
				 if(mid.equals(values[0]))
				 {
					name[i]=values[1] ;
					if(values[2].contains("The"))
						url[i]=values[4];
					else
					url[i]=values[3];
				 }
				
			}
			
		br.close();
			}
			catch(Exception e)
			{
				
			}
			
		}
		JLabel Label_1 = new JLabel("New label");
		Label_1.setBounds(20, 106, 224, 14);
		contentPane.add(Label_1);
		Label_1.setText(name[0]);
		
		JLabel Label_2 = new JLabel("New label");
		Label_2.setBounds(20, 143, 224, 14);
		contentPane.add(Label_2);
		Label_2.setText(name[1]);
		
		JLabel Label_3 = new JLabel("New label");
		Label_3.setBounds(20, 188, 224, 14);
		contentPane.add(Label_3);
		Label_3.setText(name[2]);
		
		JLabel Label_4 = new JLabel("New label");
		Label_4.setBounds(20, 225, 224, 14);
		contentPane.add(Label_4);
		Label_4.setText(name[3]);
		
		JLabel Label_5 = new JLabel("New label");
		Label_5.setBounds(20, 260, 248, 14);
		contentPane.add(Label_5);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 66, 478, 17);
		contentPane.add(separator_1);
		Label_5.setText(name[4]);
		String nnn=url[0];
		
		
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
				open(nnn);
				Rating rr=new Rating(user,id,iddqdidkfa[0]);
				rr.setVisible(true);
				rr.toFront();
				Welcome.this.dispose();
				
			}
			
		});
		 
		
		
		btnNewButton.setBounds(409, 109, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Link");
		btnNewButton_1.addActionListener(new ActionListener() {
						public void open(String url)
				{
					try{
						java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
					}catch(java.io.IOException e)
					{
						
					}
				}
						
						
				public void actionPerformed(ActionEvent e) {
					open(url[1]);
					Rating rr=new Rating(user,id,iddqdidkfa[1]);
					rr.setVisible(true);
					Welcome.this.dispose();
					
				}
				
			
		});
		btnNewButton_1.setBounds(409, 143, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Link");
		btnNewButton_2.addActionListener(new ActionListener() {
		
				public void open(String url)
				{
					try{
						java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
					}catch(java.io.IOException e)
					{
						
					}
				}
				public void actionPerformed(ActionEvent e) {
					open(url[2]);
					Rating rr=new Rating(user,id,iddqdidkfa[2]);
					rr.setVisible(true);
					Welcome.this.dispose();
									}
				
			
		});
		btnNewButton_2.setBounds(409, 177, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Link");
		btnNewButton_3.addActionListener(new ActionListener() {
			
				public void open(String url)
				{
					try{
						java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
					}catch(java.io.IOException e)
					{
						
					}
				}
				public void actionPerformed(ActionEvent e) {
					open(url[3]);
					Rating rr=new Rating(user,id,iddqdidkfa[3]);
					rr.setVisible(true);
					Welcome.this.dispose();
					
				}
				
			
		});
		btnNewButton_3.setBounds(409, 211, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Link");
		btnNewButton_4.addActionListener(new ActionListener() {
			
				public void open(String url)
				{
					try{
						java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
					}catch(java.io.IOException e)
					{
						
					}
				}
				public void actionPerformed(ActionEvent e) {
					open(url[4]);
					Rating rr=new Rating(user,id,iddqdidkfa[4]);
					rr.setVisible(true);
					Welcome.this.dispose();
					
				}
		});
		
		btnNewButton_4.setBounds(409, 245, 89, 23);
		contentPane.add(btnNewButton_4);
		
		String ll[]=new String[5];
		String rm[]=new String[5];
		String um[]=new String[5];
		try{
			if(flag==1)
			{
			List<RecommendedItem> li=ItemRecommend.recc(id);
			
			String line;
			int i=0;
			int j=0;
			int k=0;
			for (RecommendedItem x : li) 
			 {
				BufferedReader br = new BufferedReader(new FileReader("data/testformovies.csv"));
		    	while((line = br.readLine())!= null )
		    	{
		    		String values3[]=line.split(",");
		    		String ls=Long.toString(x.getItemID());
		    		if(ls.equals((values3[0])))
		    		{	
		    			ll[k++]=ls;
		    			rm[i++]=values3[1];
		    			if(values3[2].contains("The"))
		    				um[j++]=values3[4];
		    			else
		    				um[j++]=values3[3];
		    			
		    		}
			 }
		br.close();}
			
		}else
		{
	/*this*/		BufferedReader br = new BufferedReader(new FileReader("data/movies.csv")) ;
			String line;
		String idm=null;
			while((line = br.readLine())!= null )
			{
				
				String values[] = line.split(",");
				String ids=Integer.toString(id);
				if(ids.equals(values[0]))
					{
					  idm=values[1];
					}
				 
				
			}
			int idmm=Integer.parseInt(idm);
			List<RecommendedItem> li=itemtoitem.itt(idmm);
			
			String line1;
			int i=0;
			int j=0;
			int k=0;
			for (RecommendedItem x : li) 
			 {
				System.out.println(x);
				BufferedReader br1 = new BufferedReader(new FileReader("data/testformovies.csv"));
		    	while((line1 = br1.readLine())!= null )
		    	{
		    		String values6[]=line1.split(",");
		    		String ls=Long.toString(x.getItemID());
		    		if(ls.equals((values6[0])))
		    		{	
		    			ll[k++]=ls;
		    			rm[i++]=values6[1];
		    			if(values6[2].contains("The"))
		    				um[j++]=values6[4];
		    			else
		    				um[j++]=values6[3];
		    			
		    		}
			 }
		br1.close();}
		}
		}catch(Exception e)
		{
		}
		JLabel l1 = new JLabel("New label");
		l1.setBounds(20, 350, 227, 14);
		contentPane.add(l1);
		l1.setText(rm[0]);
	
		
		JLabel l2 = new JLabel("New label");
		l2.setBounds(20, 403, 227, 14);
		contentPane.add(l2);
		l2.setText(rm[1]);
		
		JLabel l3 = new JLabel("New label");
		l3.setBounds(20, 456, 227, 14);
		contentPane.add(l3);
		l3.setText(rm[2]);
		
		JLabel l4 = new JLabel("New label");
		l4.setBounds(20, 511, 227, 14);
		contentPane.add(l4);
		l4.setText(rm[3]);
		
		JLabel l5 = new JLabel("New label");
		l5.setBounds(20, 564, 227, 14);
		contentPane.add(l5);
		
		JButton b1 = new JButton("Link");
		b1.addActionListener(new ActionListener() {
			
				public void open(String url)
				{
					try{
						java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
					}catch(java.io.IOException e)
					{
						
					}
				}
				public void actionPerformed(ActionEvent e) {
					
					Rating rr=new Rating(user,id,ll[0]);
					rr.setVisible(true);
					open(um[0]);
					Welcome.this.dispose();
				}
			
		});
		b1.setBounds(409, 346, 89, 23);
		contentPane.add(b1);
		
		JButton b2 = new JButton("Link");
		b2.addActionListener(new ActionListener() {
			public void open(String url)
			{
				try{
					java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
				}catch(java.io.IOException e)
				{
					
				}
			}
			public void actionPerformed(ActionEvent e) {
				open(um[1]);
				Rating rr=new Rating(user,id,ll[1]);
				rr.setVisible(true);
				Welcome.this.dispose();
								}
			
		});
		b2.setBounds(409, 399, 89, 23);
		contentPane.add(b2);
		
		JButton b3 = new JButton("Link");
		b3.addActionListener(new ActionListener() {
			public void open(String url)
			{
				try{
					java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
				}catch(java.io.IOException e)
				{
					
				}
			}
			public void actionPerformed(ActionEvent e) {
				open(um[2]);
				Rating rr=new Rating(user,id,ll[2]);
				rr.setVisible(true);
				Welcome.this.dispose();
								}
		});
		b3.setBounds(409, 452, 89, 23);
		contentPane.add(b3);
		
		JButton b4 = new JButton("Link");
		b4.addActionListener(new ActionListener() {
			public void open(String url)
			{
				try{
					java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
				}catch(java.io.IOException e)
				{
					
				}
			}
			public void actionPerformed(ActionEvent e) {
				open(um[3]);
				Rating rr=new Rating(user,id,ll[3]);
				rr.setVisible(true);
				Welcome.this.dispose();
								}
		});
		b4.setBounds(409, 507, 89, 23);
		contentPane.add(b4);
		
		JButton b5 = new JButton("Link");
		b5.addActionListener(new ActionListener() {
			public void open(String url)
			{
				try{
					java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
				}catch(java.io.IOException e)
				{
					
				}
			}
			public void actionPerformed(ActionEvent e) {
				open(um[4]);
				Rating rr=new Rating(user,id,ll[4]);
				rr.setVisible(true);
				Welcome.this.dispose();
								}
		});
		b5.setBounds(409, 560, 89, 23);
		contentPane.add(b5);
		l5.setText(rm[4]);
		
		JButton btnNewButton_5 = new JButton("Logout");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Welcome.this.dispose();
			}
		});
		btnNewButton_5.setBounds(559, 31, 89, 23);
		contentPane.add(btnNewButton_5);
		
		
	}
}
