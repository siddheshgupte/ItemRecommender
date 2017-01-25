package com.predictionmarketing.ItemRecommender;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.ItemBasedRecommender;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
public class itemtoitem {
	List<RecommendedItem> recommendations;
				
	 private static String input = "data/movies.csv";
	 private static DataModel model = null;
	 private static PearsonCorrelationSimilarity similarity = null;
	 private static ItemBasedRecommender recommender = null;
	 public static void main(String args[]) throws IOException, TasteException {
		 Scanner sc=new Scanner(System.in);	
		  model = new FileDataModel(new File(input));
		  similarity = new PearsonCorrelationSimilarity(model);

		  recommender = new GenericItemBasedRecommender(model, similarity);
		  System.out.println("Enter the item to which thr similar item is to be found");
		  int item1=sc.nextInt();
		  System.out.println("Enter the number of similar items needed");
		  int num=sc.nextInt();
		  List<RecommendedItem> recommendations = recommender.recommend(item1,num );


		    for (RecommendedItem recommendation : recommendations) {
		      System.out.println(recommendation);
sc.close();
		 }
		}
	 public static List<RecommendedItem> itt(int itemid) throws Exception
	 {
		 Scanner sc=new Scanner(System.in);	
			model = new FileDataModel(new File(input));

			similarity = new PearsonCorrelationSimilarity(model);
	

		  recommender = new GenericItemBasedRecommender(model, similarity);
		 // System.out.println("Enter the item to which thr similar item is to be found");
		 // int item1=sc.nextInt();
		 // System.out.println("Enter the number of similar items needed");
		 // int num=sc.nextInt();
		  List<RecommendedItem> recommendations  = recommender.recommend(itemid,5 );
	

		  //  for (RecommendedItem recommendation : recommendations) {
		     // System.out.println(recommendation);
sc.close();
		// }
return  recommendations;
	 }
}
