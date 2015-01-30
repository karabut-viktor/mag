package ee.ut.solmir.mag.act;

import java.util.List;

import ee.ut.solmir.mag.act.model.ACT;

public class SimilarityUtils {
	private SimilarityUtils() {}
	
	public static double stringSimilarity(String s1, String s2) {
		// TODO
		return s1.equals(s2) ? 1 : 0;
	}
	
	public static double blockSimilarity(List<? extends ACT> b1, List<? extends ACT> b2) {
		// TODO
		int min = Math.min(b1.size(), b2.size());
		int max = Math.max(b1.size(), b2.size());
		double sum = 0d;
		double weight = 1d / max;
		for (int i = 0; i < min; i++) {
	    sum += weight * b1.get(i).similarity(b2.get(i));
    }
		return sum;
	}
}
