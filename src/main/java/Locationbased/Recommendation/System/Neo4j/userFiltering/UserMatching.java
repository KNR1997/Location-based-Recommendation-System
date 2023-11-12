package Locationbased.Recommendation.System.Neo4j.userFiltering;

import Locationbased.Recommendation.System.Neo4j.service.UserService.UserProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class UserMatching {
    private static final Logger logger = LoggerFactory.getLogger(UserProcess.class);

    public static Map<String, Set<String>> userProfiles = new HashMap<>();

    private static double calculateJacquardSimilarity(Set<String> set1, Set<String> set2) {
        Set<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        Set<String> union = new HashSet<>(set1);
        union.addAll(set2);

        return (double) intersection.size() / union.size();
    }

    public static List<String> findSimilarUsers(Set<String> newUserCategories, String username) {
        List<String> similarUsers = new ArrayList<>();
        for (Map.Entry<String, Set<String>> entry : userProfiles.entrySet()) {
            if (!username.equals(entry.getKey())) {
                double similarity = calculateJacquardSimilarity(newUserCategories, entry.getValue());
                // Threshold for similarity (adjust as needed)
                if (similarity >= 0.5) {
                    similarUsers.add(entry.getKey());
                }
            }
        }
        return similarUsers;
    }

    public static Map<String, Double> calculateSimilarityWithExistingUsers(String userName, Set<String> newUserCategories) {
        logger.info("Calculate similarity with existing users {}", userName);
        Map<String, Double> allUsers = new HashMap<>();
        for (Map.Entry<String, Set<String>> entry : userProfiles.entrySet()) {
            if (!userName.equals(entry.getKey())) {
                double similarity = calculateJacquardSimilarity(newUserCategories, entry.getValue());
                allUsers.put(entry.getKey(), similarity);
            }
        }
        return allUsers;
    }
}

