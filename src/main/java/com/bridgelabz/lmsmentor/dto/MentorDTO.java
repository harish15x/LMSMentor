package com.bridgelabz.lmsmentor.dto;

import lombok.Data;

@Data
public class MentorDTO {

    private String employeeId;
    private String firstName;
    private String lastName;
    private String mentorType;
    private String mentorRole;
    private String mobileNumber;
    private String email;
    private String experienceYears;
    private String preferredTime;
    private String status;
    private String mentorDescription;
    private String profileImageURL;
    private int creatorUser;
    private long supervisorId;

}
