package Locationbased.Recommendation.System.Neo4j.service.context;

import Locationbased.Recommendation.System.Neo4j.commons.command.ExecutionContext;

import java.util.List;
import java.util.Set;

public class UserRecommendedPlacesContext extends ExecutionContext {

    private static final String USER_NAME = "user_name";

    private static final String SIMILAR_USERS = "similar_users";

    private static final String RECOMMENDED_PLACES = "recommended_places";

    public String getUserName() {return getParam(USER_NAME);}

    public void setUserName(String userName) {
        putParam(USER_NAME, userName);
    }

    public List<String > getSimilarUsers() {
        return getParam(SIMILAR_USERS);
    }

    public void setSimilarUsers(List<String> similarUsers) {
        putParam(SIMILAR_USERS, similarUsers);
    }

    public Set<String > getRecommendedPlaces() {
        return getParam(RECOMMENDED_PLACES);
    }

    public void setRecommendedPlaces(Set<String> recommendedPlaces){
        putParam(RECOMMENDED_PLACES, recommendedPlaces);
    }
}
