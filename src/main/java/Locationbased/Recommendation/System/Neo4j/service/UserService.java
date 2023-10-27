package Locationbased.Recommendation.System.Neo4j.service;

import Locationbased.Recommendation.System.Neo4j.models.User;
import Locationbased.Recommendation.System.Neo4j.models.dto.PlaceRateDTO;
import Locationbased.Recommendation.System.Neo4j.models.queryResult.UserRatePlaceQueryResult;
import Locationbased.Recommendation.System.Neo4j.repositories.UserRepository;
import Locationbased.Recommendation.System.Neo4j.requests.CreateUserRequest;
import Locationbased.Recommendation.System.Neo4j.service.context.UserRecommendedPlacesContext;
import Locationbased.Recommendation.System.Neo4j.service.generate.UserRecommendedPlacesGenerator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRecommendedPlacesGenerator userRecommendedPlacesGenerator;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       UserRecommendedPlacesGenerator userRecommendedPlacesGenerator
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRecommendedPlacesGenerator = userRecommendedPlacesGenerator;
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

    public PlaceRateDTO saveOrUpdatePlaceRating(PlaceRateDTO updateDTO) {

        boolean isNew = (!userRepository.userRatedPlace(updateDTO.getUserName(), updateDTO.getPlaceName()));
        UserRatePlaceQueryResult result = null;

        if (isNew) {
            result = userRepository.createUserRatePlaceRelationship(updateDTO.getUserName(), updateDTO.getPlaceName(), updateDTO.getRating());
        } else {
            result = userRepository.updateUserRatePlaceRelationship(updateDTO.getUserName(), updateDTO.getPlaceName(), updateDTO.getRating());
        }

        return new PlaceRateDTO(result);
    }

    @Async
    public void generateRecommendedPlacesForUser(String userName) {
        UserRecommendedPlacesContext context = new UserRecommendedPlacesContext();

        context.setUserName(userName);
        userRecommendedPlacesGenerator.execute(context);
    }
}
