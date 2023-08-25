package Locationbased.Recommendation.System.Neo4j.controllers;

import Locationbased.Recommendation.System.Neo4j.dtos.InterestedFieldsDTO;
import Locationbased.Recommendation.System.Neo4j.queryResult.UserLikeQueryResult;
import Locationbased.Recommendation.System.Neo4j.requests.UserLikeFieldRequest;
import Locationbased.Recommendation.System.Neo4j.services.InterestFieldService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/interestFields")
public class InterestController {

    private final InterestFieldService interestFieldService;

    public InterestController(InterestFieldService interestFieldService) {
        this.interestFieldService = interestFieldService;
    }

    @PostMapping("/created")
    public ResponseEntity<InterestedFieldsDTO> userLikeFieldCreate(@RequestBody UserLikeFieldRequest request, Principal principal) {
        UserLikeQueryResult userLikeQueryResult = interestFieldService.userLikeFieldsCreated(principal.getName(), request.getInterestFields());

        InterestedFieldsDTO interestedFieldsDTO = new InterestedFieldsDTO();

        interestedFieldsDTO.setName(userLikeQueryResult.getUser().getName());
        interestedFieldsDTO.setInterestFields(userLikeQueryResult.getFieldName());

        return new ResponseEntity<>(interestedFieldsDTO, HttpStatus.OK);
    }
}
