package Locationbased.Recommendation.System.Neo4j.config;

import Locationbased.Recommendation.System.Neo4j.models.node.User;
import Locationbased.Recommendation.System.Neo4j.repositories.neo4j.UserNodeRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public class AuthenticatedUserUtil {

    public static String getAuthenticatedUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof UserDetails userDetails) {
            return userDetails.getUsername();
        }
        return null;
    }

    public static User getAuthenticatedUser(UserNodeRepository userNodeRepository) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof UserDetails userDetails) {
            Optional<User> optionalUser = userNodeRepository.findUserByUsername(userDetails.getUsername());
            return optionalUser.orElseThrow(() -> new RuntimeException("User not found"));
        }
        return null;
    }
}
