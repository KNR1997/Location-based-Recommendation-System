package Locationbased.Recommendation.System.Neo4j.service.UserService;

import Locationbased.Recommendation.System.Neo4j.models.dto.UserDTO;
import Locationbased.Recommendation.System.Neo4j.models.dto.UserRecordDTO;
import Locationbased.Recommendation.System.Neo4j.models.mongoEntity.UserRecord;
import Locationbased.Recommendation.System.Neo4j.models.node.User;
import Locationbased.Recommendation.System.Neo4j.repositories.mongodb.UserRecordRepository;
import Locationbased.Recommendation.System.Neo4j.repositories.neo4j.UserNodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceNew {


    @Autowired
    private UserNodeRepository userNodeRepository;

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
}
