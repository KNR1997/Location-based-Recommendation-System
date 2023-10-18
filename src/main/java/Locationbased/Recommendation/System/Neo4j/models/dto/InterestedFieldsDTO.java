package Locationbased.Recommendation.System.Neo4j.dtos;

import lombok.Data;

@Data
public class InterestedFieldsDTO {

    private String name;

    private String interestFields;

    public InterestedFieldsDTO() {
    }
}
