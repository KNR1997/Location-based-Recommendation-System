package Locationbased.Recommendation.System.Neo4j.service.command;

import Locationbased.Recommendation.System.Neo4j.commons.command.CommandExecutor;
import Locationbased.Recommendation.System.Neo4j.service.UserService;
import Locationbased.Recommendation.System.Neo4j.service.context.UserRecommendedPlacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SimilarUsersFinder extends CommandExecutor<UserRecommendedPlacesContext> {

    @Autowired
    private UserService userService;

    @Override
    public UserRecommendedPlacesContext execute(UserRecommendedPlacesContext context) {
        List<String> similarUsers = this.userService.findSimilarUsers(context.getUserName());
        context.setSimilarUsers(similarUsers);

        return context;
    }
}
