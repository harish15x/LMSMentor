package com.bridgelabz.lmsmentor.controller;


import com.bridgelabz.lmsmentor.dto.MentorDTO;
import com.bridgelabz.lmsmentor.model.MentorModel;
import com.bridgelabz.lmsmentor.service.IMentorService;
import com.bridgelabz.lmsmentor.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/mentor")
public class MentorController {

    @Autowired
    IMentorService mentorService;

    @PostMapping("/addmentor")
    public MentorModel addMentor(@Valid @RequestBody MentorDTO mentorDTO){
        return mentorService.addMentor(mentorDTO);
    }

    @PutMapping("update/{id}")
    public MentorModel updateMentor(@RequestHeader String token, @Valid @RequestBody MentorDTO mentorDTO, @PathVariable Long id){
        return mentorService.updateMentor(token, mentorDTO, id);
    }

    @GetMapping("getmentordata")
    public List<MentorModel> getMentorData(@RequestHeader String token){
        return mentorService.getMentorData(token);
    }

    @DeleteMapping("deletementor/{id}")
    public MentorModel deleteMentor(@PathVariable long id, @RequestHeader String token){
        return mentorService.deleteMentor(id, token);
    }

    @GetMapping("getmmentor/{id}")
    public MentorModel getMentor (@PathVariable Long id , @RequestHeader String token){
        return mentorService.getMentor(id, token);
    }






}
