package com.predictionmarketing.ItemRecommender;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class spliting {
public static void main(String args[])
{
	try{
	BufferedReader br2 = new BufferedReader(new FileReader("data/movies.csv")) ;
	String line;
	String line2;
	
	while((line = br2.readLine())!=null)

	{
		int nor=0;
		String values1[] = line.split(",");
		String s=values1[0];
		BufferedReader br3 = new BufferedReader(new FileReader("data/movies.csv")) ;
		while((line2=br3.readLine())!=null)
		{
			String values2[]=line2.split(",");
			if(s.equals(values2[0]))
			{
				nor++;
				
			}	
		
		
		}
		if(nor<30)
		{
			FileWriter fw = new FileWriter("data/under20.csv", true);
			 BufferedWriter bw = new BufferedWriter(fw);
			 bw.write(line+"\n");
			 bw.close();
		}
		else
		{
			FileWriter fw = new FileWriter("data/over20.csv", true);
			 BufferedWriter bw = new BufferedWriter(fw);
			 bw.write(line+"\n");
			 bw.close();
	
		}
	
	}
	System.out.println("Done");
			
	}
	catch(Exception e)
	{
		
	}
	
}
}
