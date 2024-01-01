package Locationbased.Recommendation.System.Neo4j.service.userRecord;

import Locationbased.Recommendation.System.Neo4j.config.AuthenticatedUserUtil;
import Locationbased.Recommendation.System.Neo4j.models.dto.UserRecordDTO;
import Locationbased.Recommendation.System.Neo4j.models.mongoEntity.Tour;
import Locationbased.Recommendation.System.Neo4j.models.mongoEntity.UserRecord;
import Locationbased.Recommendation.System.Neo4j.models.node.SubCategory;
import Locationbased.Recommendation.System.Neo4j.models.node.User;
import Locationbased.Recommendation.System.Neo4j.repositories.mongodb.UserRecordRepository;
import Locationbased.Recommendation.System.Neo4j.repositories.neo4j.UserNodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserRecordService {

    @Autowired
    private UserNodeRepository userNodeRepository;

    @Autowired
    private UserRecordRepository userRecordRepository;

    public UserRecordDTO saveOrUpdateUserRecord(UserRecordDTO userRecordDTO) {

        UserRecord userRecord;
        List<String> likeSubCategories = new ArrayList<>();
        boolean isNewUserRecord = (userRecordDTO.getUserRecordID() == null);
        User user = AuthenticatedUserUtil.getAuthenticatedUser(userNodeRepository);

        if (!isNewUserRecord) {
            userRecord = this.userRecordRepository.findByUserID(user.getId());

            userRecord.setLikeSubCategories(userRecordDTO.getLikeSubCategories());
            userNodeRepository.deleteUserLikeSubCategories(user.getUsername());
        } else {
            userRecord = new UserRecord();
            List<Tour> tourList = new ArrayList<>();

            userRecord.setUserID(user.getId());
            userRecord.setLikeSubCategories(userRecordDTO.getLikeSubCategories());
            userRecord.setTour(tourList);
            userRecord.setTimeStamp(LocalDateTime.now());
        }

        for (SubCategory subCategory : userRecordDTO.getLikeSubCategories()) {
            likeSubCategories.add(subCategory.getName());
        }

        userNodeRepository.createUserLikeSubCategories(user.getUsername(), likeSubCategories.toArray(new String[0]));

        userRecord = this.userRecordRepository.save(userRecord);
        return new UserRecordDTO(userRecord);
    }

    public UserRecord getLatestUserRecord(String userName){

        UserRecord userRecord;
        User user = userNodeRepository.findUserByusername(userName);
        Sort sort = Sort.by(Sort.Order.desc("timeStamp"));
        boolean hasRecord = userRecordRepository.existsByUserID(user.getId());

        if (hasRecord){
            userRecord = userRecordRepository.findLatestUserRecord(user.getId(), sort);
        } else {
            userRecord = new UserRecord();

            userRecord.setUserID(user.getId());
            userRecord.setLikeSubCategories(new ArrayList<>());
            userRecord = this.userRecordRepository.save(userRecord);
        }

        return userRecord;
    }
}
