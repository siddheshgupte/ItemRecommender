package com.predictionmarketing.ItemRecommender;
	
	 
	import org.apache.mahout.cf.taste.impl.model.file.*;
	import org.apache.mahout.cf.taste.impl.neighborhood.*;
	import org.apache.mahout.cf.taste.impl.recommender.*;
	import org.apache.mahout.cf.taste.impl.similarity.*;
	import org.apache.mahout.cf.taste.model.*;
	import org.apache.mahout.cf.taste.neighborhood.*;
	import org.apache.mahout.cf.taste.recommender.*;
	import org.apache.mahout.cf.taste.similarity.*;
	import java.io.*;
	import java.util.*;
	 
	public class loglikelihood {
	 
	  	 
	  public static void main(String[] args) throws Exception {
	 
	    DataModel model = new FileDataModel(new File("data/movies.csv"));  
	    UserSimilarity similarity = new LogLikelihoodSimilarity(model); 
	    UserNeighborhood neighborhood =  new NearestNUserNeighborhood(2, similarity, model); 
	 
	    Recommender recommender = new GenericUserBasedRecommender(  model, neighborhood, similarity); 
	    List<RecommendedItem>recommendations =   recommender.recommend(4, 4);
	
	    for (RecommendedItem recommendation : recommendations) {
	      System.out.println(recommendation);
	    }
	 
	  }
	 
	}


