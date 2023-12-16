package Locationbased.Recommendation.System.Neo4j.service.UserService;

import Locationbased.Recommendation.System.Neo4j.algorithm.ContentBasedFiltering;
import Locationbased.Recommendation.System.Neo4j.models.dto.UserRecordDTO;
import Locationbased.Recommendation.System.Neo4j.models.node.User;
import Locationbased.Recommendation.System.Neo4j.models.node.UserRecord;
import Locationbased.Recommendation.System.Neo4j.repositories.neo4j.UserNodeRepository;
import Locationbased.Recommendation.System.Neo4j.repositories.neo4j.UserRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceNew {

    @Autowired
    private UserRecordRepository userRecordRepository;

    @Autowired
    private UserNodeRepository userNodeRepository;

    @Autowired
    private ContentBasedFiltering contentBasedFiltering;

    public UserRecordDTO saveOrUpdateUserRecord(UserRecordDTO userRecordDTO) {

        UserRecord userRecord;
        boolean isNewUserRecord = (userRecordDTO.getUserRecordID() == null);
        Optional<User> userOptional = userNodeRepository.findById(userRecordDTO.getUserID());
        User user = userOptional.orElseThrow(() -> new RuntimeException("User not found"));

        if (!isNewUserRecord) {
            userRecord = this.userRecordRepository.findUserRecordByID(userRecordDTO.getUserRecordID());

            userRecord.setLikeSubCategories(userRecordDTO.getLikeSubCategories());
            userNodeRepository.deleteUserLikeSubCategories(user.getUsername());
        } else {
            userRecord = new UserRecord();

            userRecord.setUserID(userRecordDTO.getUserID());
            userRecord.setLikeSubCategories(userRecordDTO.getLikeSubCategories());
        }

        userRecord.setRecommendPlaces(contentBasedFiltering.contentBasedRecommendedPlaces(userRecord.getLikeSubCategories()));
        userNodeRepository.createUserLikeSubCategories(user.getUsername(), userRecordDTO.getLikeSubCategories());

        userRecord = this.userRecordRepository.save(userRecord);
        return new UserRecordDTO(userRecord);
    }

}
