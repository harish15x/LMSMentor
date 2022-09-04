package com.bridgelabz.lmsmentor.model;

import com.bridgelabz.lmsmentor.dto.MentorDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "mentor")
public class MentorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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
    private LocalDateTime createdTimeStamp;
    private LocalDateTime updatedTimeStamp;

    public MentorModel(MentorDTO mentorDTO){

        this.employeeId = mentorDTO.getEmployeeId();
        this.firstName = mentorDTO.getFirstName();
        this.lastName = mentorDTO.getLastName();
        this.mentorType = mentorDTO.getMentorType();
        this.mentorRole = mentorDTO.getMentorRole();
        this.mobileNumber = mentorDTO.getMobileNumber();
        this.email = mentorDTO.getEmail();
        this.experienceYears = mentorDTO.getExperienceYears();
        this.preferredTime = mentorDTO.getPreferredTime();
        this.status = mentorDTO.getStatus();
        this.mentorDescription = mentorDTO.getMentorDescription();
        this.profileImageURL = mentorDTO.getProfileImageURL();
        this.profileImageURL = mentorDTO.getProfileImageURL();
        this.creatorUser = mentorDTO.getCreatorUser();
        this.supervisorId = mentorDTO.getSupervisorId();

    }


    public MentorModel() {

    }
}
