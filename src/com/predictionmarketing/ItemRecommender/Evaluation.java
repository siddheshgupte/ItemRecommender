package com.predictionmarketing.ItemRecommender;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.cli2.OptionException;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.RMSRecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
//import org.apache.mahout.cf.taste.impl.recommender.CachingRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.UncenteredCosineSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.ItemBasedRecommender;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public final class Evaluation
{private static UncenteredCosineSimilarity similarity = null;
private static ItemBasedRecommender recommender = null;

	public static void main(String args[]) throws IOException, TasteException, OptionException
	{
		RecommenderBuilder builder = new RecommenderBuilder() 
		{
			public Recommender buildRecommender(DataModel model) throws TasteException
			{
				 
				 similarity = new UncenteredCosineSimilarity(model);

				  recommender = new GenericItemBasedRecommender(model, similarity);
				 
			    return recommender;
			}
		};

		RecommenderEvaluator evaluator = new RMSRecommenderEvaluator();
		DataModel model = new FileDataModel(new File("data/movies.csv"));
		double score = evaluator.evaluate(builder,null,model,0.7,0.3);

		System.out.println(score);
	}
}