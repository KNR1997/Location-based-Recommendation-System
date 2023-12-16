package Locationbased.Recommendation.System.Neo4j.service.UserService;

import Locationbased.Recommendation.System.Neo4j.algorithm.ContentBasedFiltering;
import Locationbased.Recommendation.System.Neo4j.models.dto.UserDTO;
import Locationbased.Recommendation.System.Neo4j.models.dto.UserRecordDTO;
import Locationbased.Recommendation.System.Neo4j.models.mongoEntity.UserRecord;
import Locationbased.Recommendation.System.Neo4j.models.node.User;
import Locationbased.Recommendation.System.Neo4j.models.node.UserRecordNode;
import Locationbased.Recommendation.System.Neo4j.repositories.mongodb.UserRecordRepository;
import Locationbased.Recommendation.System.Neo4j.repositories.neo4j.UserNodeRepository;
import Locationbased.Recommendation.System.Neo4j.repositories.neo4j.UserRecordNodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceNew {

    @Autowired
    private UserRecordNodeRepository userRecordNodeRepository;

    @Autowired
    private UserNodeRepository userNodeRepository;

    @Autowired
    private ContentBasedFiltering contentBasedFiltering;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRecordRepository userRecordRepository;

    public UserDTO saveOrUpdateUser(UserDTO userDTO) {

        User user;
        UserRecord userRecord;
        boolean isNewUser = (userDTO.getUserID() == null);

        if (!isNewUser) {
            Optional<User> optionalUser = this.userNodeRepository.findById(userDTO.getUserID());
            user = optionalUser.orElseThrow(() -> new RuntimeException("User not found"));
            userRecord = this.userRecordRepository.findByUserID(userDTO.getUserID());

        } else {
            user = new User();
            userRecord = new UserRecord();

            user.setUsername(userDTO.getUsername());
            user.setEmail(userDTO.getEmail());
            user.setRoles(userDTO.getRoles());
            user.setPassword(this.passwordEncoder.encode(userDTO.getPassword()));
            userRecord.setUserID(user.getId());

        }

        user = this.userNodeRepository.save(user);
        this.userRecordRepository.save(userRecord);
        return new UserDTO(user);
    }

    public UserRecordDTO saveOrUpdateUserRecord(UserRecordDTO userRecordDTO) {

        UserRecordNode userRecordNode;
        boolean isNewUserRecord = (userRecordDTO.getUserRecordID() == null);
        Optional<User> userOptional = userNodeRepository.findById(userRecordDTO.getUserID());
        User user = userOptional.orElseThrow(() -> new RuntimeException("User not found"));

        if (!isNewUserRecord) {
            userRecordNode = this.userRecordNodeRepository.findUserRecordByID(userRecordDTO.getUserRecordID());

            userRecordNode.setLikeSubCategories(userRecordDTO.getLikeSubCategories());
            userNodeRepository.deleteUserLikeSubCategories(user.getUsername());
        } else {
            userRecordNode = new UserRecordNode();

            userRecordNode.setUserID(userRecordDTO.getUserID());
            userRecordNode.setLikeSubCategories(userRecordDTO.getLikeSubCategories());
        }

        userRecordNode.setRecommendPlaces(contentBasedFiltering.contentBasedRecommendedPlaces(userRecordNode.getLikeSubCategories()));
        userNodeRepository.createUserLikeSubCategories(user.getUsername(), userRecordDTO.getLikeSubCategories());

        userRecordNode = this.userRecordNodeRepository.save(userRecordNode);
        return new UserRecordDTO(userRecordNode);
    }

}
