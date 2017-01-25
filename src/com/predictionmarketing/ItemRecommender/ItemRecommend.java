package com.predictionmarketing.ItemRecommender;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

//import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
//import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
//import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;


public class ItemRecommend   {
	 List<RecommendedItem> recommendations;
	
	public static void main(String args[])throws Exception
	{
		
		
				Scanner sc = new Scanner(System.in);
			    DataModel model = new FileDataModel(new File("data/movies.csv"));

			    UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
			    
			    UserNeighborhood neighborhood =
			    		new NearestNUserNeighborhood(2, similarity, model);

			    Recommender recommender = new GenericUserBasedRecommender(
			        model, neighborhood, similarity);
			    System.out.println("Enter the user for which you want the recommendation:");
			    int n=sc.nextInt();
			    
			 
			      List<RecommendedItem> recommendations =
			        recommender.recommend(n,5);
			   // String="abc";
			String line;
			    for (RecommendedItem recommendation : recommendations) {
			    	BufferedReader br = new BufferedReader(new FileReader("data/testformovies.csv"));
			    	while((line = br.readLine())!= null )
			    	{
			    		String values[]=line.split(",");
			    		String ls=Long.toString(recommendation.getItemID());
			    		if(ls.equals((values[0])))
			    		{	
			    			if(values[2].contains("The"))
			    			{
			    				String s1=values[2].trim();
			    				String s[]=s1.split(" ");
			    				System.out.println("Movie::"+s[0]+" "+values[1]+s[1]+"\t"+"Expected value of rating::"+recommendation.getValue()+"\tlink::"+values[4]);
			    				
			    			}
			    			else
			    			System.out.println("Movie::"+values[1]+"\t"+"Expected value of rating::"+recommendation.getValue()+"\tlink::"+values[3]);
			    		}
			      //System.out.println(recommendation);
			    }
			    
			   // RecommenderEvaluator evaluator = new AverageAbsoluteDifferenceRecommenderEvaluator();
			    
			    //double result = evaluator.evaluate(builder, null, model, 0.9, 1.0);
			   // System.out.println(result);
			    sc.close();
			    br.close();
			
	}
			   
}
	public static List<RecommendedItem> recc(int id)throws Exception
	{	
		
		Scanner sc = new Scanner(System.in);
	    DataModel model = new FileDataModel(new File("data/movies.csv"));
	   String line;
	   int count=0;
	  String l=Integer.toString(id);
	    	BufferedReader br = new BufferedReader(new FileReader("data/testformovies.csv"));
	    	while((line = br.readLine())!= null )
	    	{
	    		String values[]=line.split(",");
	    		if(values[0].equals(l))
	    		{
	    			count++;
	    		}
	    	}
	    
	    	 
	    	if(count>30)
	    	{
	    UserSimilarity similarity = new LogLikelihoodSimilarity(model);

		UserNeighborhood neighborhood =
	    		new NearestNUserNeighborhood(2, similarity, model);

	    Recommender recommender = new GenericUserBasedRecommender(
	        model, neighborhood, similarity);

	      List<RecommendedItem> recommendations =
	        recommender.recommend(id,5);
	      return recommendations;
	      
	    
	    	}
	    	else
	    	{
	    		UserSimilarity similarity = new PearsonCorrelationSimilarity(model);

	    		UserNeighborhood neighborhood =
	    	    		new NearestNUserNeighborhood(2, similarity, model);

	    	    Recommender recommender = new GenericUserBasedRecommender(
	    	        model, neighborhood, similarity);

	  	      List<RecommendedItem> recommendations =
	  	        recommender.recommend(id,5);
	  	    return recommendations;
	    	    
	    	}
	  
		
	   
	    
	 
	      
	  /*  String abc="abc";
	String line;
	    for (RecommendedItem recommendation : recommendations) {
	    	BufferedReader br = new BufferedReader(new FileReader("data/testformovies.csv"));
	    	while((line = br.readLine())!= null )
	    	{
	    		String values[]=line.split(",");
	    		String ls=Long.toString(recommendation.getItemID());
	    		if(ls.equals((values[0])))
	    		{	
	    			if(values[2].contains("The"))
	    			{
	    				String s1=values[2].trim();
	    				String s[]=s1.split(" ");
	    				System.out.println("Movie::"+s[0]+" "+values[1]+s[1]+"\t"+"Expected value of rating::"+recommendation.getValue()+"\tlink::"+values[4]);
	    				
	    			}
	    			else
	    			System.out.println("Movie::"+values[1]+"\t"+"Expected value of rating::"+recommendation.getValue()+"\tlink::"+values[3]);
	    		}
	      //System.out.println(recommendation);
	    }
	    
	   // RecommenderEvaluator evaluator = new AverageAbsoluteDifferenceRecommenderEvaluator();
	    
	    //double result = evaluator.evaluate(builder, null, model, 0.9, 1.0);
	   // System.out.println(result);*/
	  
	    //br.close();
	  
	}
	
}