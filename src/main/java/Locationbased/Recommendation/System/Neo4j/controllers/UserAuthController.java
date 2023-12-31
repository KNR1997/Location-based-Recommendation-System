package Locationbased.Recommendation.System.Neo4j.controllers;

import Locationbased.Recommendation.System.Neo4j.models.dto.AuthRequest;
import Locationbased.Recommendation.System.Neo4j.models.dto.UserAuthDTO;
import Locationbased.Recommendation.System.Neo4j.models.dto.UserDTO;
import Locationbased.Recommendation.System.Neo4j.models.mongoEntity.UserRecord;
import Locationbased.Recommendation.System.Neo4j.models.node.User;
import Locationbased.Recommendation.System.Neo4j.requests.CreateUserRequest;
import Locationbased.Recommendation.System.Neo4j.service.JwtService;
import Locationbased.Recommendation.System.Neo4j.service.UserService.UserService;
import Locationbased.Recommendation.System.Neo4j.service.UserService.UserServiceNew;
import Locationbased.Recommendation.System.Neo4j.service.userRecord.UserRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/auth")
public class UserAuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserServiceNew userServiceNew;

    @Autowired
    private UserRecordService userRecordService;

    @GetMapping("/me")
    public String loggedUser(Principal principal) {
        return principal.getName();
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> signUp(@RequestBody CreateUserRequest request) {
        User user = userService.createUser(request);

        UserDTO responseUser = new UserDTO(user.getUsername(), user.getRoles());

        return new ResponseEntity<>(responseUser, HttpStatus.CREATED);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<UserAuthDTO> authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            String token = jwtService.generateToken(authRequest.getUsername());
            UserRecord userRecord = userRecordService.getLatestUserRecord(authRequest.getUsername());
            UserAuthDTO response = new UserAuthDTO(authRequest.getUsername(), token, userRecord);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }

    @RequestMapping(value = "/saveOrUpdateUser", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<UserDTO> saveOrUpdateUser(@RequestBody UserDTO updateDTO) {
        UserDTO result = userServiceNew.saveOrUpdateUser(updateDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
