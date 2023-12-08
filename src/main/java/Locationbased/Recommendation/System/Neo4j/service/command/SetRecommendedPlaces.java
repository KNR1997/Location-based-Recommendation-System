package Locationbased.Recommendation.System.Neo4j.service.command;

import Locationbased.Recommendation.System.Neo4j.commons.command.CommandExecutor;
import Locationbased.Recommendation.System.Neo4j.repositories.neo4j.UserNodeRepository;
import Locationbased.Recommendation.System.Neo4j.service.context.UserRecommendedPlacesContext;
import org.springframework.stereotype.Component;

@Component
public class SetRecommendedPlaces extends CommandExecutor<UserRecommendedPlacesContext> {

    private final UserNodeRepository userNodeRepository;

    public SetRecommendedPlaces(UserNodeRepository userNodeRepository) {
        this.userNodeRepository = userNodeRepository;
    }

    @Override
    public UserRecommendedPlacesContext execute(UserRecommendedPlacesContext context) {
        this.userNodeRepository.createUserRecommendPlacesRelationship(context.getUserName(),
                context.getRecommendedPlaces().toArray(new String[0]));

        return context;
    }
}
