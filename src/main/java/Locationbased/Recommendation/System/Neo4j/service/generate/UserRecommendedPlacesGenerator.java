package Locationbased.Recommendation.System.Neo4j.service.generate;

import Locationbased.Recommendation.System.Neo4j.commons.command.CommandExecutor;
import Locationbased.Recommendation.System.Neo4j.service.command.RecommendedPlacesFinder;
import Locationbased.Recommendation.System.Neo4j.service.command.SetRecommendedPlaces;
import Locationbased.Recommendation.System.Neo4j.service.command.SimilarUsersFinder;
import Locationbased.Recommendation.System.Neo4j.service.context.UserRecommendedPlacesContext;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class UserRecommendedPlacesGenerator extends CommandExecutor<UserRecommendedPlacesContext>{

    private final SimilarUsersFinder similarUsersFinder;

    private final RecommendedPlacesFinder recommendedPlacesFinder;

    private final SetRecommendedPlaces setRecommendedPlaces;

    public UserRecommendedPlacesGenerator(SimilarUsersFinder similarUsersFinder,
                                          RecommendedPlacesFinder recommendedPlacesFinder,
                                          SetRecommendedPlaces setRecommendedPlaces) {
        this.similarUsersFinder = similarUsersFinder;
        this.recommendedPlacesFinder = recommendedPlacesFinder;
        this.setRecommendedPlaces = setRecommendedPlaces;
    }

    @Override
    public UserRecommendedPlacesContext execute(UserRecommendedPlacesContext context) {
        return super.execute(context);
    }

    @PostConstruct
    public void initialize() {
        addCommand(this.similarUsersFinder);
        addCommand(this.recommendedPlacesFinder);
        addCommand(this.setRecommendedPlaces);
    }
}
