package com.bridgelabz.lmsmentor.service;

import com.bridgelabz.lmsmentor.dto.MentorDTO;
import com.bridgelabz.lmsmentor.exception.MentorNotFoundException;
import com.bridgelabz.lmsmentor.model.MentorModel;
import com.bridgelabz.lmsmentor.repository.MentorRepository;
import com.bridgelabz.lmsmentor.util.ResponseClass;
import com.bridgelabz.lmsmentor.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MentorService implements IMentorService{

    @Autowired
    MentorRepository mentorRepository;

    @Autowired
    MailService mailService;

    @Autowired
    TokenUtil tokenUtil;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public ResponseClass addMentor(MentorDTO mentorDTO, String token) {
        boolean isMentor = restTemplate.getForObject("http://localhost:8083/admin/validate" + token, Boolean.class);
        if (isMentor){
        MentorModel mentorModel = new MentorModel(mentorDTO);
        mentorModel.setCreatedTimeStamp(LocalDateTime.now());
        mentorRepository.save(mentorModel);
        String body = "Mentor added sucessfully " + mentorModel.getId();
        String subject = "Mentor registration completed";
        mailService.send(mentorModel.getEmail(),body, subject);
        return new ResponseClass("Sucussfull", 200, mentorModel);
    }
        throw new MentorNotFoundException(400,  "Mentor not found");
    }

    @Override
    public ResponseClass updateMentor(String token, MentorDTO mentorDTO, Long id) {
        boolean isMentor = restTemplate.getForObject("http://localhost:8083/admin/validate" + token, Boolean.class);
        if(isMentor){
        Long userId = tokenUtil.decodeToken(token);
        Optional<MentorModel> isMentorPresent = mentorRepository.findById(userId);
        if (isMentorPresent.isPresent()) {
            Optional<MentorModel> isMentorAvailable = mentorRepository.findById(id);
            if (isMentorAvailable.isPresent()) {
                isMentorAvailable.get().setEmployeeId(mentorDTO.getEmployeeId());
                isMentorAvailable.get().setFirstName(mentorDTO.getFirstName());
                isMentorAvailable.get().setLastName(mentorDTO.getLastName());
                isMentorAvailable.get().setMentorType(mentorDTO.getMentorType());
                isMentorAvailable.get().setMentorRole(mentorDTO.getMentorRole());
                isMentorAvailable.get().setMobileNumber(mentorDTO.getMobileNumber());
                isMentorAvailable.get().setEmail(mentorDTO.getEmail());
                isMentorAvailable.get().setExperienceYears(mentorDTO.getExperienceYears());
                isMentorAvailable.get().setPreferredTime(mentorDTO.getPreferredTime());
                isMentorAvailable.get().setStatus(mentorDTO.getStatus());
                isMentorAvailable.get().setMentorDescription(mentorDTO.getMentorDescription());
                isMentorAvailable.get().setProfileImageURL(mentorDTO.getProfileImageURL());
                isMentorAvailable.get().setCreatorUser(mentorDTO.getCreatorUser());
                isMentorAvailable.get().setSupervisorId(mentorDTO.getSupervisorId());
                isMentorAvailable.get().setUpdatedTimeStamp(LocalDateTime.now());
                mentorRepository.save(isMentorAvailable.get());
                String body = "Mentor is added successfully with mentorId " + isMentorAvailable.get().getId();
                String subject = "Mentor registration successfully";
                mailService.send(isMentorAvailable.get().getEmail(), subject, body);
                return new ResponseClass("Sucessfull", 200,isMentorAvailable.get());
            } else {
                throw new MentorNotFoundException(400, "Mentor not found");
            }
        }}
        throw new MentorNotFoundException(400, "Token is wrong");
    }

    @Override
    public List<MentorModel> getMentorData(String token) {
        boolean isMentor = restTemplate.getForObject("http://localhost:8083/admin/validate" + token, Boolean.class);
        if(isMentor){
        Long userId = tokenUtil.decodeToken(token);
        Optional<MentorModel> isMentorPresent= mentorRepository.findById(userId);
        if (isMentorPresent.isPresent()) {
            List<MentorModel> isMentorAvailable = mentorRepository.findAll();
            if (isMentorAvailable.size() > 0) {
                return isMentorAvailable;
            } else {
                throw new MentorNotFoundException(400, "No mentor is present");
            }
        }}
        throw new MentorNotFoundException(400, "Token is wrong");
    }

    @Override
    public ResponseClass deleteMentor(long id, String token) {
        boolean isMentor = restTemplate.getForObject("http://localhost:8083/admin/validate" + token, Boolean.class);
        if(isMentor){
        Long userId = tokenUtil.decodeToken(token);
        Optional<MentorModel> isMentorPresent = mentorRepository.findById(userId);
        if (isMentorPresent.isPresent()) {
            Optional<MentorModel> isMentorAvailable = mentorRepository.findById(id);
            if (isMentorAvailable.isPresent()) {
                mentorRepository.delete(isMentorAvailable.get());
                return new ResponseClass("Sucessfull",200 ,isMentorAvailable.get());
            } else {
                throw new MentorNotFoundException(400, "Mentor not found");
            }
        }}
        throw new MentorNotFoundException(400, "Token is wrong");
    }

    @Override
    public ResponseClass getMentor(Long id, String token) {
        boolean isMentor = restTemplate.getForObject("http://localhost:8083/admin/validate" + token, Boolean.class);
        if(isMentor){
        Long userId = tokenUtil.decodeToken(token);
        Optional<MentorModel> isMentorPresent = mentorRepository.findById(userId);
        if (isMentorPresent.isPresent()) {
            Optional<MentorModel> isMentorAvailable = mentorRepository.findById(id);
            if (isMentorAvailable.isPresent()) {
                return new ResponseClass("sucessfully", 200, isMentorAvailable.get());
            } else {
                throw new MentorNotFoundException(400, "Mentor not found");
            }
        }}
        throw new MentorNotFoundException(400, "Token is wrong");
    }


}
