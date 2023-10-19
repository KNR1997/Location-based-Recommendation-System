package Locationbased.Recommendation.System.Neo4j.controllers;

import Locationbased.Recommendation.System.Neo4j.models.dto.PlaceRateDTO;
import Locationbased.Recommendation.System.Neo4j.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/ratePlace", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<PlaceRateDTO> ratePlace(@RequestBody PlaceRateDTO updateDTO) {
        PlaceRateDTO result = userService.saveOrUpdatePlaceRating(updateDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

//    @PostMapping("/getSimilarUser")
//    public ResponseEntity<?> getSimilarUser(@RequestBody FindSimilarUserRequest request){
//        return new ResponseEntity<>(userService.findSimilarUser(request.getUserName()), HttpStatus.OK);
//    }
}
