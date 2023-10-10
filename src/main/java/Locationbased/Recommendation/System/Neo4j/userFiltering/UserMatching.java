package Locationbased.Recommendation.System.Neo4j.userFiltering;

import java.util.*;

public class UserMatching {
    public static Map<String, Set<String>> userProfiles = new HashMap<>();

    private static double calculateJacquardSimilarity(Set<String> set1, Set<String> set2) {
        Set<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        Set<String> union = new HashSet<>(set1);
        union.addAll(set2);

        return (double) intersection.size() / union.size();
    }

    public static List<String> findSimilarUsers(Set<String> newUserCategories) {
        List<String> similarUsers = new ArrayList<>();

        for (Map.Entry<String, Set<String>> entry : userProfiles.entrySet()) {
            double similarity = calculateJacquardSimilarity(newUserCategories, entry.getValue());

            // Threshold for similarity (adjust as needed)
            if (similarity >= 0.5) {
                similarUsers.add(entry.getKey());
            }
        }
        return similarUsers;
    }
}

