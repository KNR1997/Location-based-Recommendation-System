package Locationbased.Recommendation.System.Neo4j.controllers;

import Locationbased.Recommendation.System.Neo4j.models.dto.InterestFieldDTO;
import Locationbased.Recommendation.System.Neo4j.models.Interest;
import Locationbased.Recommendation.System.Neo4j.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/interestFields")
public class SubCategoryController {

    private final SubCategoryService subCategoryService;

    @Autowired
    public SubCategoryController(SubCategoryService subCategoryService) {
        this.subCategoryService = subCategoryService;
    }

    @RequestMapping(value = "/getAllSubCategories", headers = "Accept=application/json", method = RequestMethod.GET)
    public ResponseEntity<List<InterestFieldDTO>> getAllSubCategories() {
        List<InterestFieldDTO> interestFieldDTOList = subCategoryService.getAllSubCategories();
        return new ResponseEntity<>(interestFieldDTOList, HttpStatus.OK);
    }

    @RequestMapping(value = "/getUserLikedSubCategories", headers = "Accept=application/json", method = RequestMethod.GET)
    public ResponseEntity<List<Interest>> getUserLikedSubCategories(Principal principal) {
        List<Interest> userLikedInterestFields = subCategoryService.getUserLikedSubCategories(principal.getName());
        return new ResponseEntity<>(userLikedInterestFields, HttpStatus.OK);
    }
}
