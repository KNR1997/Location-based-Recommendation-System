package Locationbased.Recommendation.System.Neo4j.controllers;

import Locationbased.Recommendation.System.Neo4j.models.dto.UserRecordDTO;
import Locationbased.Recommendation.System.Neo4j.service.userRecord.UserRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/userRecord")
public class UserRecordController {

    @Autowired
    private UserRecordService userRecordService;

    @PreAuthorize("hasAuthority('USER')")
    @RequestMapping(value = "/saveOrUpdateUserRecord", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<UserRecordDTO> saveOrUpdateUserRecord(@RequestBody UserRecordDTO updateDTO) {
        UserRecordDTO result = userRecordService.saveOrUpdateUserRecord(updateDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
