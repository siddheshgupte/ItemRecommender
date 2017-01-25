
package com.predictionmarketing.ItemRecommender;

import java.awt.BorderLayout;
//import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
//import javax.swing.JList;
//import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class addMovies extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private static JTextField txtDd;
	private static JTextField txtMm;
	private static JTextField txtYy;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			addMovies dialog = new addMovies();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		txtDd.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				txtDd.setText("");
			}
		});
		txtMm.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				txtMm.setText("");
			}
		});
		txtYy.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				txtYy.setText("");
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public addMovies() {
		setTitle("Enter movies in DB");
		setBounds(100, 100, 684, 403);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setToolTipText("month");
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblMovieName = new JLabel("Movie name");
		lblMovieName.setBounds(30, 56, 80, 26);
		contentPanel.add(lblMovieName);
		
		textField = new JTextField();
		textField.setBounds(170, 59, 86, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblMovieReleaseDate = new JLabel("Movie Release Date");
		lblMovieReleaseDate.setBounds(30, 108, 114, 26);
		contentPanel.add(lblMovieReleaseDate);
		
		txtDd = new JTextField();
		txtDd.setText("dd");
		txtDd.setBounds(170, 111, 31, 20);
		contentPanel.add(txtDd);
		txtDd.setColumns(10);
		
		
		txtMm = new JTextField();
		txtMm.setText("mm");
		txtMm.setBounds(218, 111, 31, 20);
		contentPanel.add(txtMm);
		txtMm.setColumns(10);
		
		txtYy = new JTextField();
		txtYy.setText("yyyy");
		txtYy.setBounds(267, 111, 36, 20);
		contentPanel.add(txtYy);
		txtYy.setColumns(10);
		
		JLabel lblImdbLink = new JLabel("IMDB link");
		lblImdbLink.setBounds(30, 165, 80, 14);
		contentPanel.add(lblImdbLink);
		
		textField_1 = new JTextField();
		textField_1.setBounds(170, 162, 86, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnEnterInDatabase = new JButton("Enter ");
		btnEnterInDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
					try{
					BufferedReader br = new BufferedReader(new FileReader("data/testformovies.csv")) ;
					String line;
					int currid=1;
					while((line = br.readLine())!= null )
					{
						String values[] = line.split(",");
						 currid= Integer.parseInt(values[0]);
						
					}
					
				FileWriter fw = new FileWriter("data/testformovies.csv", true);
				 BufferedWriter bw = new BufferedWriter(fw);
				 String year=txtYy.getText();
				 int monthno=Integer.parseInt(txtMm.getText());
				 String month="Aug";
				 switch(monthno)
				 {
				 case(01):month="Jan";
				 		break;
				 case(02):month="Feb";
				 break;
				 case(03):month="Mar";
				 break;
				 case(04):month="Apr";
				 break;
				 case(05):month="May";
				 break;
				 case(06):month="Jun";
				 break;
				 case(07):month="Jul";
				 break;
				 case(8):month="Aug";
				 break;
				 case(9):month="Sep";
				 break;
				 case(10):month="Oct";
				 break;
				 case(11):month="Nov";
				 break;
				 case(12):month="Dec";
				 
				 }
				 String s=textField.getText();
					s.trim();
					String sa[]=s.split(" ");
					bw.write((currid+1)+",");
					if(sa[0].equalsIgnoreCase("The")||sa[0].equals("A"))
					{
						for(int i=1;i<sa.length;i++)
						{
							if(i==(sa.length)-1)
								bw.write(sa[i]);
							else
							    bw.write(sa[i]+" ");
						}
						bw.write(","+" The"+" ("+year+"),"+txtDd.getText()+"-"+month+"-"+year+","+textField_1.getText()+"\n");  //here
					
					}
					else
					{
						bw.write(s+" ("+year+"),"+txtDd.getText()+"-"+month+"-"+year+","+textField_1.getText()+"\n");                     //here
						
					}
										
				bw.close(); 
				br.close();
				
				}
				catch(IOException ex){
					
					
				}
					textField.setText("");
					txtDd.setText("");
					txtMm.setText("");
					txtYy.setText("");
					textField_1.setText("");
				
			}
		});
		btnEnterInDatabase.setBounds(112, 270, 89, 23);
		contentPanel.add(btnEnterInDatabase);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(null);
			{
				JButton okButton = new JButton("OK");
				okButton.setBounds(312, 5, 47, 23);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setBounds(364, 5, 65, 23);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
