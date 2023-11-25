package Locationbased.Recommendation.System.Neo4j.models;

import lombok.Data;

import java.util.Date;

@Data
public class AuditableEntity {

    private String status;
//    private String createdBy;
//    private String updatedBy;
//    private Date createdAt;
//    private Date updatedAt;

    // getters and setters for the above fields

//    protected void onCreate() {
//        createdAt = new Date();
//        // Set createdBy based on your authentication or system logic
//        createdBy = "system"; // Replace with actual logic to get the current user
//    }
//
//    protected void onUpdate() {
//        updatedAt = new Date();
//        // Set updatedBy based on your authentication or system logic
//        updatedBy = "system"; // Replace with actual logic to get the current user
//    }
}
