package Locationbased.Recommendation.System.Neo4j.controllers;

import Locationbased.Recommendation.System.Neo4j.models.dto.PlaceRateDTO;
import Locationbased.Recommendation.System.Neo4j.models.dto.UserLikedNotLikedSubCategoryDTO;
import Locationbased.Recommendation.System.Neo4j.models.dto.UserRecordDTO;
import Locationbased.Recommendation.System.Neo4j.models.dto.UserSubCategoryDTO;
import Locationbased.Recommendation.System.Neo4j.models.node.UserRecord;
import Locationbased.Recommendation.System.Neo4j.models.queryResult.UserLikedFieldsResult;
import Locationbased.Recommendation.System.Neo4j.service.UserService.UserService;
import Locationbased.Recommendation.System.Neo4j.service.UserService.UserServiceNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserServiceNew userServiceNew;

    @RequestMapping(value = "/ratePlace", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<PlaceRateDTO> ratePlace(@RequestBody PlaceRateDTO updateDTO) {
        PlaceRateDTO result = userService.saveOrUpdatePlaceRating(updateDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

//    @PreAuthorize("hasAuthority('USER')")
//    @RequestMapping(value = "/createUserLikeSubCategories", headers = "Accept=application/json", method = RequestMethod.POST)
//    public ResponseEntity<UserSubCategoryDTO> createUserLikeSubCategories(@RequestBody UserSubCategoryDTO updateDTO) {
//        UserSubCategoryDTO result = userService.saveOrUpdateUserLikeSubCategories(updateDTO);
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }

    @PreAuthorize("hasAuthority('USER')")
    @RequestMapping(value = "/saveOrUpdateUserRecord", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<UserRecordDTO> saveOrUpdateUserRecord(@RequestBody UserRecordDTO updateDTO) {
        UserRecordDTO result = userServiceNew.saveOrUpdateUserRecord(updateDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('USER')")
    @RequestMapping(value = "/getUserLikedSubCategories", headers = "Accept=application/json", method = RequestMethod.GET)
    public ResponseEntity<List<UserLikedFieldsResult>> getUserLikedSubCategories() {
        List<UserLikedFieldsResult> result = userService.getUserLikeSubCategories();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('USER')")
    @RequestMapping(value = "/getUserLikedNotLikedSubCategories", headers = "Accept=application/json", method = RequestMethod.GET)
    public ResponseEntity<UserLikedNotLikedSubCategoryDTO> getUserLikedNotLikedSubCategories() {
        UserLikedNotLikedSubCategoryDTO result = userService.getUserLikedAndNotLikedSubCategories();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('USER')")
    @RequestMapping(value = "/saveUserDestination", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<UserRecord> saveUserDestination(@RequestBody UserRecordDTO updateDTO) {
        UserRecord result = userService.saveUserDestination(updateDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
