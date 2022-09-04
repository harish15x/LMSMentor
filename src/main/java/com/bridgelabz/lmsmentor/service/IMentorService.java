package com.bridgelabz.lmsmentor.service;

import com.bridgelabz.lmsmentor.dto.MentorDTO;
import com.bridgelabz.lmsmentor.model.MentorModel;

import java.util.List;

public interface IMentorService {
    MentorModel addMentor(MentorDTO mentorDTO);

    MentorModel updateMentor(String token, MentorDTO mentorDTO, Long id);

    List<MentorModel> getMentorData(String token);

    MentorModel deleteMentor(long id, String token);

    MentorModel getMentor(Long id, String token);
}
