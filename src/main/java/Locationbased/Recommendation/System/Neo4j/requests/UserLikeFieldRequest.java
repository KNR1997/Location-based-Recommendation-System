package Locationbased.Recommendation.System.Neo4j.requests;

import lombok.Data;

@Data
public class UserLikeFieldRequest {

    private String[] interestFields;
}
