package Locationbased.Recommendation.System.Neo4j.service.UserService;

import Locationbased.Recommendation.System.Neo4j.models.queryResult.CreateSimilarityRelationshipWithExistingUsersQueryResult;
import Locationbased.Recommendation.System.Neo4j.models.queryResult.UserNameAndLikedCategoriesQueryResult;
import Locationbased.Recommendation.System.Neo4j.repositories.neo4j.UserNodeRepository;
import Locationbased.Recommendation.System.Neo4j.userFiltering.UserMatching;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Lazy
public class UserProcess {
    private static final Logger logger = LoggerFactory.getLogger(UserProcess.class);

    private final UserNodeRepository userNodeRepository;

    public UserProcess(UserNodeRepository userNodeRepository) {
        this.userNodeRepository = userNodeRepository;
    }

    @Async
    public void createSimilarityRelationshipWithOtherUsers(String userName) {
        logger.info("Create Similarity Relationships {} with other users", userName);
        // Get all users
        UserMatching.userProfiles = getAllUsersWithLikeCategories();
        // Get new User like subCategories
        List<String> interestFields = userNodeRepository.getUserLikedSubCategories(userName);
        Set<String> categoriesSet = new HashSet<>(interestFields);

        Map<String, Double> result = UserMatching.calculateSimilarityWithExistingUsers(userName, categoriesSet);
        List<CreateSimilarityRelationshipWithExistingUsersQueryResult> queryResults = userNodeRepository.createSimilarityRelationshipWithExistingUsers(userName, result);
    }

    public List<String> findSimilarUsers(String username) {
        UserMatching.userProfiles = getAllUsersWithLikeCategories();
        List<String> interestFields = userNodeRepository.getUserLikedSubCategories(username);
        Set<String> categoriesSet = new HashSet<>();
        categoriesSet.addAll(interestFields);
        List<String> similarUsers = UserMatching.findSimilarUsers(categoriesSet, username);
        // Convert the List to a String array
        String[] stringArray = similarUsers.toArray(new String[0]);
        createSimilarUsersRelationships(username, stringArray);
        return similarUsers;
    }

    public List<String> getUserLikeSubCategories(String userName) {
        return userNodeRepository.getUserLikedSubCategories(userName);
    }

    public Map<String, Set<String>> getAllUsersWithLikeCategories() {
        Map<String, Set<String>> userProfiles = new HashMap<>();
        List<UserNameAndLikedCategoriesQueryResult> result = userNodeRepository.getAllUsersWithLikeCategories();
        for (UserNameAndLikedCategoriesQueryResult data : result) {
            if (userProfiles.containsKey(data.getUserName())) {
                Set<String> stringSet = userProfiles.get((data.getUserName()));
                stringSet.add(data.getCategoryName());
            } else {
                Set<String> mutableSet = new HashSet<>();
                mutableSet.add(data.getCategoryName());
                userProfiles.put(data.getUserName(), mutableSet);
            }
        }
        return userProfiles;
    }

    public void createSimilarUsersRelationships(String userName, String[] similarUsers) {
        if (userNodeRepository.userAlreadyHasSimilarUsers(userName)) {
            this.deleteUserSimilarUserRelationships(userName);
        }
        userNodeRepository.createSimilarUsers(userName, similarUsers);
    }

    void deleteUserSimilarUserRelationships(String userName) {
        userNodeRepository.deleteExistingSimilarUsersRelationships(userName);
    }
}
