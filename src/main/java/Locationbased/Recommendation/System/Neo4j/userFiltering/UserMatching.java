package Locationbased.Recommendation.System.Neo4j.userFiltering;

import java.util.*;

public class UserMatching {
    // Sample user profiles with liked categories
    private static Map<String, Set<String>> userProfiles = new HashMap<>();

    public static void main(String[] args) {
        // Create user profiles
        userProfiles.put("User1", new HashSet<>(Arrays.asList("beach", "wildlife", "restaurants")));
        userProfiles.put("User2", new HashSet<>(Arrays.asList("beach", "restaurants")));
        userProfiles.put("User3", new HashSet<>(Arrays.asList("wildlife", "restaurants")));

        // New user's liked categories
        Set<String> newUserCategories = new HashSet<>(Arrays.asList("beach", "wildlife"));

        // Calculate Jaccard similarity and find similar users
        List<String> similarUsers = findSimilarUsers(newUserCategories);

        // Print similar users
        System.out.println("Similar Users:");
        for (String user : similarUsers) {
            System.out.println(user);
        }
    }

    // Calculate Jaccard similarity between two sets
    private static double calculateJaccardSimilarity(Set<String> set1, Set<String> set2) {
        Set<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        Set<String> union = new HashSet<>(set1);
        union.addAll(set2);

        return (double) intersection.size() / union.size();
    }

    // Find similar users based on Jaccard similarity
    private static List<String> findSimilarUsers(Set<String> newUserCategories) {
        List<String> similarUsers = new ArrayList<>();

        for (Map.Entry<String, Set<String>> entry : userProfiles.entrySet()) {
            double similarity = calculateJaccardSimilarity(newUserCategories, entry.getValue());

            // Threshold for similarity (adjust as needed)
            if (similarity >= 0.5) {
                similarUsers.add(entry.getKey());
            }
        }

        return similarUsers;
    }
}

