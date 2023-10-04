package Locationbased.Recommendation.System.Neo4j.controllers;

import Locationbased.Recommendation.System.Neo4j.dtos.InterestedFieldsDTO;
import Locationbased.Recommendation.System.Neo4j.models.Interest;
import Locationbased.Recommendation.System.Neo4j.queryResult.UserLikeQueryResult;
import Locationbased.Recommendation.System.Neo4j.requests.UserLikeFieldRequest;
import Locationbased.Recommendation.System.Neo4j.services.InterestFieldService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/interestFields")
public class InterestController {

    private final InterestFieldService interestFieldService;

    public InterestController(InterestFieldService interestFieldService) {
        this.interestFieldService = interestFieldService;
    }

    @PostMapping("/create")
    public ResponseEntity<InterestedFieldsDTO> userLikeFieldCreate(@RequestBody UserLikeFieldRequest request, Principal principal) {
        UserLikeQueryResult userLikeQueryResult = interestFieldService.createUserLikeFields(principal.getName(), request.getInterestArrayList());

        InterestedFieldsDTO interestedFieldsDTO = new InterestedFieldsDTO();

        interestedFieldsDTO.setName(userLikeQueryResult.getUser().getName());
        interestedFieldsDTO.setInterestFields(userLikeQueryResult.getFieldName());

        return new ResponseEntity<>(interestedFieldsDTO, HttpStatus.OK);
    }

    @GetMapping("/getAllInterestFields")
    public ResponseEntity<List<Interest>> getAllInterestedFields() {
        return new ResponseEntity<>(interestFieldService.getAllInterestFields(), HttpStatus.OK);
    }

    @GetMapping("/getUserLikedInterestFields")
    public ResponseEntity<List<Interest>> getUserLikedFields(Principal principal) {
        List<Interest> userLikedInterestFields = interestFieldService.getUserLikedFields(principal.getName());
        return new ResponseEntity<>(userLikedInterestFields, HttpStatus.OK);
    }
}
