package Locationbased.Recommendation.System.Neo4j.service.command;

import Locationbased.Recommendation.System.Neo4j.commons.command.CommandExecutor;
import Locationbased.Recommendation.System.Neo4j.service.PlaceRecommendationService;
import Locationbased.Recommendation.System.Neo4j.service.context.UserRecommendedPlacesContext;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class RecommendedPlacesFinder extends CommandExecutor<UserRecommendedPlacesContext> {

    private final PlaceRecommendationService placeRecommendationService;

    public RecommendedPlacesFinder(PlaceRecommendationService placeRecommendationService) {
        this.placeRecommendationService = placeRecommendationService;
    }

    @Override
    public UserRecommendedPlacesContext execute(UserRecommendedPlacesContext context) {
        Set<String> recommendPlaces = this.placeRecommendationService.recommendPlacesForUser(context.getUserName(), context.getSimilarUsers());
        context.setRecommendedPlaces(recommendPlaces);

        return context;
    }
}
