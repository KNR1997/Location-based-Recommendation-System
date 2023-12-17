package Locationbased.Recommendation.System.Neo4j.service.UserService;

import Locationbased.Recommendation.System.Neo4j.algorithm.ContentBasedFiltering;
import Locationbased.Recommendation.System.Neo4j.models.dto.UserDTO;
import Locationbased.Recommendation.System.Neo4j.models.dto.UserRecordDTO;
import Locationbased.Recommendation.System.Neo4j.models.mongoEntity.UserRecord;
import Locationbased.Recommendation.System.Neo4j.models.node.User;
import Locationbased.Recommendation.System.Neo4j.repositories.mongodb.UserRecordRepository;
import Locationbased.Recommendation.System.Neo4j.repositories.neo4j.UserNodeRepository;
import Locationbased.Recommendation.System.Neo4j.repositories.neo4j.UserRecordNodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
            user = this.userNodeRepository.findUserByID(userDTO.getUserID());
            userRecord = this.userRecordRepository.findByUserID(userDTO.getUserID());

        } else {
            user = new User();

            user.setUsername(userDTO.getUsername());
            user.setEmail(userDTO.getEmail());
            user.setRoles(userDTO.getRoles());
            user.setPassword(this.passwordEncoder.encode(userDTO.getPassword()));

        }

        user = this.userNodeRepository.save(user);
        return new UserDTO(user);
    }

    public UserRecordDTO saveOrUpdateUserRecord(UserRecordDTO userRecordDTO) {

        UserRecord userRecord;
        boolean isNewUserRecord = (userRecordDTO.getUserRecordID() == null);
        User user = this.userNodeRepository.findUserByID(userRecordDTO.getUserID());

        if (!isNewUserRecord) {
            userRecord = this.userRecordRepository.findByUserID(userRecordDTO.getUserID());

            userRecord.setLikeSubCategories(userRecordDTO.getLikeSubCategories());
            userNodeRepository.deleteUserLikeSubCategories(user.getUsername());
        } else {
            userRecord = new UserRecord();

            userRecord.setUserID(userRecordDTO.getUserID());
            userRecord.setLikeSubCategories(userRecordDTO.getLikeSubCategories());
        }

        userNodeRepository.createUserLikeSubCategories(user.getUsername(), userRecordDTO.getLikeSubCategories());

        userRecord = this.userRecordRepository.save(userRecord);
        return new UserRecordDTO(userRecord);
    }

}
