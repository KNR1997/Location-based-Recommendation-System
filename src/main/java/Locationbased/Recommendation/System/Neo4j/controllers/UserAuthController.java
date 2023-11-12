package Locationbased.Recommendation.System.Neo4j.controllers;

import Locationbased.Recommendation.System.Neo4j.models.User;
import Locationbased.Recommendation.System.Neo4j.models.dto.AuthRequest;
import Locationbased.Recommendation.System.Neo4j.models.dto.UserDTO;
import Locationbased.Recommendation.System.Neo4j.requests.CreateUserRequest;
import Locationbased.Recommendation.System.Neo4j.service.JwtService;
import Locationbased.Recommendation.System.Neo4j.service.UserService.UserService;
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
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }
}
