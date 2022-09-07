package com.bridgelabz.lmsmentor.service;

import com.bridgelabz.lmsmentor.dto.MentorDTO;
import com.bridgelabz.lmsmentor.model.MentorModel;
import com.bridgelabz.lmsmentor.util.ResponseClass;

import java.util.List;

public interface IMentorService {
    ResponseClass addMentor(MentorDTO mentorDTO, String token);

    ResponseClass updateMentor(String token, MentorDTO mentorDTO, Long id);

    List<MentorModel> getMentorData(String token);

    ResponseClass deleteMentor(long id, String token);

    ResponseClass getMentor(Long id, String token);
}
