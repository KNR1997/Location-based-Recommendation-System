package Locationbased.Recommendation.System.Neo4j.controllers;

import Locationbased.Recommendation.System.Neo4j.queryResult.UserRatePlaceQueryResult;
import Locationbased.Recommendation.System.Neo4j.requests.FindSimilarUserRequest;
import Locationbased.Recommendation.System.Neo4j.requests.UserRatePlaceRequest;
import Locationbased.Recommendation.System.Neo4j.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/ratePlace")
    public ResponseEntity<?> ratePlace(@RequestBody UserRatePlaceRequest request) {
        UserRatePlaceQueryResult userRatePlaceQueryResult = userService.ratePlace(request.getUserName(), request.getPlaceName(), request.getRating());
        return new ResponseEntity<>(userRatePlaceQueryResult, HttpStatus.OK);
    }

    @PostMapping("/getSimilarUser")
    public ResponseEntity<?> getSimilarUser(@RequestBody FindSimilarUserRequest request){
        return new ResponseEntity<>(userService.findSimilarUser(request.getUserName()), HttpStatus.OK);
    }
}
