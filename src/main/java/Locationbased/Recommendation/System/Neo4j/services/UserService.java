package Locationbased.Recommendation.System.Neo4j.services;

import Locationbased.Recommendation.System.Neo4j.models.SubCategory;
import Locationbased.Recommendation.System.Neo4j.models.User;
import Locationbased.Recommendation.System.Neo4j.queryResult.UserNameAndLikedCategoriesQueryResult;
import Locationbased.Recommendation.System.Neo4j.repositories.UserRepository;
import Locationbased.Recommendation.System.Neo4j.requests.CreateUserRequest;
import Locationbased.Recommendation.System.Neo4j.userFiltering.UserMatching;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(CreateUserRequest request) {
        User user = new User();

        user.setName(request.getName());
        // TODO: make sure this username doesn't exist.
        user.setUsername(request.getUsername());
        user.setRoles(request.getRoles());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);

        return user;
    }

    public Map<String, Set<String>> getAllUsersWithLikeCategories() {
        Map<String, Set<String>> userProfiles = new HashMap<>();
        List<UserNameAndLikedCategoriesQueryResult> result = userRepository.getAllUsersWithLikeCategories();
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

    public List<String> findSimilarUser(ArrayList<SubCategory> subCategories) {
        UserMatching.userProfiles = getAllUsersWithLikeCategories();
        Set<String> subCategoryList = new HashSet<>();
        for (SubCategory subCategory : subCategories) {
            subCategoryList.add(subCategory.getName());
        }
        return UserMatching.findSimilarUsers(subCategoryList);
    }

    public int add(int numberA, int numberB) {
        return numberA + numberB;
    }
}
