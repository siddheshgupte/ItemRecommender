package com.predictionmarketing.ItemRecommender;
/*DON'T RUN THIS PROGRAM*//*DON'T RUN THIS PROGRAM*/
/*DON'T RUN THIS PROGRAM*/
/*DON'T RUN THIS PROGRAM*/
/*DON'T RUN THIS PROGRAM*/
/*DON'T RUN THIS PROGRAM*/
/*DON'T RUN THIS PROGRAM*/
/*DON'T RUN THIS PROGRAM*/
/*DON'T RUN THIS PROGRAM*/
/*DON'T RUN THIS PROGRAM*/
/*DON'T RUN THIS PROGRAM*/
/*DON'T RUN THIS PROGRAM*/
/*DON'T RUN THIS PROGRAM*/
/*DON'T RUN THIS PROGRAM*/
/*DON'T RUN THIS PROGRAM*/
/*DON'T RUN THIS PROGRAM*/
/*DON'T RUN THIS PROGRAM*/
/*DON'T RUN THIS PROGRAM*/
/*DON'T RUN THIS PROGRAM*/
/*DON'T RUN THIS PROGRAM*/
/*DON'T RUN THIS PROGRAM*/
/*DON'T RUN THIS PROGRAM*/
/*DON'T RUN THIS PROGRAM*/
/*DON'T RUN THIS PROGRAM*/
/*DON'T RUN THIS PROGRAM*/
/*DON'T RUN THIS PROGRAM*/
/*DON'T RUN THIS PROGRAM*/

/*DON'T RUN THIS PROGRAM*/
/*DON'T RUN THIS PROGRAM*/
/*DON'T RUN THIS PROGRAM*/
/*DON'T RUN THIS PROGRAM*/
/*DON'T RUN THIS PROGRAM*/
/*DON'T RUN THIS PROGRAM*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class convertData {

	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		BufferedReader br = new BufferedReader(new FileReader("data/u.data")) ;
		BufferedWriter bw = new BufferedWriter(new FileWriter("data/movies.csv"));
		//BufferedWriter bw3 = new BufferedWriter(new FileWriter("data/1234.csv")); userid,moviename,rating
		String line;
		while((line = br.readLine())!= null )
		{
			String values[] = line.split("\\t");
			bw.write(values[0] + "," + values[1] + "," + values[2] + "\n");
		}
		
		BufferedReader br2 = new BufferedReader(new FileReader("data/u.item"));
		BufferedWriter bw2 = new BufferedWriter(new FileWriter("data/testformovies.csv"));
		String line2;
		while((line2=br2.readLine())!=null)
		{
			String values2[]=line2.split("\\|");
			bw2.write(values2[0]+","+values2[1]+","+values2[2]+","+values2[4]+"\n");
			
		}
		br2.close();
		br.close();
		bw.close();
		//int flag=0;
		//int count=0;
		BufferedReader br1 = new BufferedReader(new FileReader("data/u.data")) ;
		sc.close();
	/*	while((line = br1.readLine())!= null )
		{	
			count++;
			String values[] = line.split("\\t");
			BufferedReader br3 = new BufferedReader(new FileReader("data/u.item"));
			while((line2=br3.readLine())!=null)
			{	
				String values2[]=line2.split("\\|");
				if(Integer.parseInt(values[1])==Integer.parseInt(values2[0]))
				{
					flag++;
					
					bw3.write(values[0] + "," + values2[1] + "," + values[2] + "\n");
				}
				
			}*/
			//br3.close();
		bw2.close();
		br1.close();	
		BufferedReader br3 = new BufferedReader(new FileReader("data/u.user")) ;
		BufferedWriter bw3 = new BufferedWriter(new FileWriter("data/userswpass.csv"));
		String line3;
		while((line3 = br3.readLine())!= null )
		{
			String values3[] = line3.split("\\|");
			bw3.write(values3[0] + "," +"abc"+","+"Dataset User number "+values3[0]+"\n");
		}
		
		bw3.close();
		br3.close();
		System.out.println("done");
		}
		//System.out.println(flag);
	//	System.out.println(count);
	//	sc.close();
		
		//br.close();
	//	bw.close();
	
		
		
	///	bw3.close();
	
	}
	


