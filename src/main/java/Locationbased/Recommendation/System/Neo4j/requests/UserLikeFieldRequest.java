package Locationbased.Recommendation.System.Neo4j.requests;

import Locationbased.Recommendation.System.Neo4j.models.node.SubCategory;
import lombok.Data;

import java.util.ArrayList;

@Data
public class UserLikeFieldRequest {
    private ArrayList<SubCategory> likeSubCategories;
}
