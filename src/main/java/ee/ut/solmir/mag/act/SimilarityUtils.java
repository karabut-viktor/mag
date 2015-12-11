package ee.ut.solmir.mag.act;

import java.util.List;

import ee.ut.solmir.mag.act.model.ACT;

public class SimilarityUtils {
  private SimilarityUtils() {
  }

  public static double stringSimilarity(String s1, String s2) {
    int maxDistance = Math.max(s1.length(), s2.length());
    if (maxDistance == 0) {
      return 1.0;
    }
    return (maxDistance - stringLevenshteinDistance(s1, s2)) / (double) maxDistance;
  }

  public static double blockSimilarity(List<? extends ACT> b1, List<? extends ACT> b2) {
    double maxDistance = Math.max(b1.size(), b2.size());
    if (maxDistance == 0.0d) {
      return 1.0;
    }
    double livenshteinDistance = generalisedLevenshteinDistance(b1, b2, new EditDistanceStrategy<ACT>() {
      public double editDistance(ACT a, ACT b) {
        return 1 - a.similarity(b);
      }
    });

    return (maxDistance - livenshteinDistance) / maxDistance;
  }

  private interface EditDistanceStrategy<T> {
    public double editDistance(T a, T b);
  }

  public static <T> double generalisedLevenshteinDistance(List<? extends T> a, List<? extends T> b, EditDistanceStrategy<T> strategy) {
    double[][] distance = new double[a.size() + 1][b.size() + 1];

    for (int i = 0; i <= a.size(); i++) {
      distance[i][0] = i;
    }
    for (int j = 1; j <= b.size(); j++) {
      distance[0][j] = j;
    }

    for (int i = 1; i <= a.size(); i++) {
      for (int j = 1; j <= b.size(); j++) {
        distance[i][j] = minimum(
            distance[i - 1][j] + 1,
            distance[i][j - 1] + 1,
            distance[i - 1][j - 1] + strategy.editDistance(a.get(i - 1), b.get(j - 1)));
      }
    }

    return distance[a.size()][b.size()];
  }

  private static int minimum(int a, int b, int c) {
    return Math.min(Math.min(a, b), c);
  }

  private static double minimum(double a, double b, double c) {
    return Math.min(Math.min(a, b), c);
  }

  private static int stringLevenshteinDistance(String str1, String str2) {
    int[][] distance = new int[str1.length() + 1][str2.length() + 1];

    for (int i = 0; i <= str1.length(); i++)
      distance[i][0] = i;
    for (int j = 1; j <= str2.length(); j++)
      distance[0][j] = j;

    for (int i = 1; i <= str1.length(); i++) {
      for (int j = 1; j <= str2.length(); j++) {
        distance[i][j] = minimum(
            distance[i - 1][j] + 1,
            distance[i][j - 1] + 1,
            distance[i - 1][j - 1]
                + ((str1.charAt(i - 1) == str2.charAt(j - 1)) ? 0 : 1));
      }
    }

    return distance[str1.length()][str2.length()];
  }

}
