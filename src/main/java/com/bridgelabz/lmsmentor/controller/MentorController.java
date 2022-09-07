package com.bridgelabz.lmsmentor.controller;


import com.bridgelabz.lmsmentor.dto.MentorDTO;
import com.bridgelabz.lmsmentor.model.MentorModel;
import com.bridgelabz.lmsmentor.service.IMentorService;
import com.bridgelabz.lmsmentor.service.MentorService;
import com.bridgelabz.lmsmentor.util.ResponseClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/mentor")
public class MentorController {

    @Autowired
    IMentorService mentorService;

    @PostMapping("/addmentor")
    public ResponseEntity<ResponseClass> addMentor(@Valid @RequestBody MentorDTO mentorDTO, @RequestHeader String token){
        ResponseClass responseClass = mentorService.addMentor(mentorDTO, token);
        return new ResponseEntity<>(responseClass, HttpStatus.OK);

    }

    @PutMapping("update/{id}")
    public ResponseEntity<ResponseClass> updateMentor(@RequestHeader String token, @Valid @RequestBody MentorDTO mentorDTO, @PathVariable Long id){
        ResponseClass responseClass = mentorService.updateMentor(token, mentorDTO, id);
        return new ResponseEntity<>(responseClass, HttpStatus.OK);
    }

    @GetMapping("getmentordata")
    public ResponseEntity <List<?>> getMentorData(@RequestHeader String token){
        List<MentorModel> responseClass =  mentorService.getMentorData(token);
        return new ResponseEntity<>(responseClass, HttpStatus.OK);
    }

    @DeleteMapping("deletementor/{id}")
    public ResponseEntity<ResponseClass> deleteMentor(@PathVariable long id, @RequestHeader String token){
        ResponseClass responseClass = mentorService.deleteMentor(id, token);
        return new ResponseEntity<>(responseClass, HttpStatus.OK);

    }

    @GetMapping("getmentor/{id}")
    public ResponseEntity<ResponseClass> getMentor (@PathVariable Long id , @RequestHeader String token){
        ResponseClass responseClass = mentorService.getMentor(id, token);
        return new ResponseEntity<>(responseClass, HttpStatus.OK);
    }

}
