package com.bridgelabz.lmsmentor.repository;

import com.bridgelabz.lmsmentor.model.MentorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorRepository extends JpaRepository<MentorModel, Long> {
}
