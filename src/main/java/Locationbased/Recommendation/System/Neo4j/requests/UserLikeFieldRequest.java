package Locationbased.Recommendation.System.Neo4j.requests;

import Locationbased.Recommendation.System.Neo4j.models.Interest;
import lombok.Data;

import java.util.ArrayList;

@Data
public class UserLikeFieldRequest {
    private ArrayList<Interest> interestArrayList;
}
