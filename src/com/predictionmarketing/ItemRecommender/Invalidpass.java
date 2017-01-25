package com.predictionmarketing.ItemRecommender;

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Invalidpass extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Invalid frame = new Invalid();
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
	public Invalidpass() {
		
		setTitle("Password MissMatch");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 316, 142);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInvalidUser = new JLabel("Password MissMatch");
		lblInvalidUser.setBounds(30, 11, 231, 14);
		contentPane.add(lblInvalidUser);
		
		JButton btnOk = new JButton("Cancel");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
             System.exit(0);
			}
		});
		btnOk.setBounds(172, 69, 89, 23);
		contentPane.add(btnOk);
		
		JButton btnOk_1 = new JButton("OK");
		btnOk_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Invalidpass.this.dispose();
			}
		});
		btnOk_1.setBounds(30, 69, 89, 23);
		contentPane.add(btnOk_1);
	}
}
