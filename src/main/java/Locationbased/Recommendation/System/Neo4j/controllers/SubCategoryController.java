package Locationbased.Recommendation.System.Neo4j.controllers;

import Locationbased.Recommendation.System.Neo4j.models.node.Interest;
import Locationbased.Recommendation.System.Neo4j.models.node.SubCategory;
import Locationbased.Recommendation.System.Neo4j.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/subCategories")
public class SubCategoryController {
    @Autowired
    private SubCategoryService subCategoryService;

    @RequestMapping(value = "/getAllSubCategories", headers = "Accept=application/json", method = RequestMethod.GET)
    public ResponseEntity<List<SubCategory>> getAllSubCategories() {
        List<SubCategory> subCategories = subCategoryService.getAllActiveSubCategories();
        return new ResponseEntity<>(subCategories, HttpStatus.OK);
    }

    @RequestMapping(value = "/getUserLikedSubCategories", headers = "Accept=application/json", method = RequestMethod.GET)
    public ResponseEntity<List<Interest>> getUserLikedSubCategories(Principal principal) {
        List<Interest> userLikedInterestFields = subCategoryService.getUserLikedSubCategories(principal.getName());
        return new ResponseEntity<>(userLikedInterestFields, HttpStatus.OK);
    }
}
