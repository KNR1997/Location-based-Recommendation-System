package Locationbased.Recommendation.System.Neo4j.controllers;

import Locationbased.Recommendation.System.Neo4j.models.dto.InterestFieldDTO;
import Locationbased.Recommendation.System.Neo4j.models.dto.InterestedFieldsDTO;
import Locationbased.Recommendation.System.Neo4j.models.Interest;
import Locationbased.Recommendation.System.Neo4j.models.queryResult.UserLikeQueryResult;
import Locationbased.Recommendation.System.Neo4j.requests.UserLikeFieldRequest;
import Locationbased.Recommendation.System.Neo4j.service.InterestFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/interestFields")
public class SubCategoryController {

    private final InterestFieldService interestFieldService;

    @Autowired
    public SubCategoryController(InterestFieldService interestFieldService) {
        this.interestFieldService = interestFieldService;
    }

    @PostMapping("/create")
    public ResponseEntity<InterestedFieldsDTO> userLikeFieldCreate(@RequestBody UserLikeFieldRequest request, Principal principal) {
        UserLikeQueryResult userLikeQueryResult = interestFieldService.createUserLikeFields(principal.getName(), request.getLikeSubCategories());

        InterestedFieldsDTO interestedFieldsDTO = new InterestedFieldsDTO();

        interestedFieldsDTO.setName(userLikeQueryResult.getUser().getName());
        interestedFieldsDTO.setInterestFields(userLikeQueryResult.getFieldName());

        return new ResponseEntity<>(interestedFieldsDTO, HttpStatus.OK);
    }

    @GetMapping("/getAllInterestFields")
    public ResponseEntity<List<InterestFieldDTO>> getAllInterestedFields() {
        List<InterestFieldDTO> interestFieldDTOList = interestFieldService.getAllInterestFields();
        return new ResponseEntity<>(interestFieldDTOList, HttpStatus.OK);
    }

    @GetMapping("/getUserLikedInterestFields")
    public ResponseEntity<List<Interest>> getUserLikedFields(Principal principal) {
        List<Interest> userLikedInterestFields = interestFieldService.getUserLikedFields(principal.getName());
        return new ResponseEntity<>(userLikedInterestFields, HttpStatus.OK);
    }
}
