package Locationbased.Recommendation.System.Neo4j.service.command;

import Locationbased.Recommendation.System.Neo4j.commons.command.CommandExecutor;
import Locationbased.Recommendation.System.Neo4j.repositories.UserRepository;
import Locationbased.Recommendation.System.Neo4j.service.context.UserRecommendedPlacesContext;
import org.springframework.stereotype.Component;

@Component
public class SetRecommendedPlaces extends CommandExecutor<UserRecommendedPlacesContext> {

    private final UserRepository userRepository;

    public SetRecommendedPlaces(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserRecommendedPlacesContext execute(UserRecommendedPlacesContext context) {
        this.userRepository.createUserRecommendPlacesRelationship(context.getUserName(),
                context.getRecommendedPlaces().toArray(new String[0]));

        return context;
    }
}
