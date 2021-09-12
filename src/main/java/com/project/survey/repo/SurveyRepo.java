package com.project.survey.repo;

import com.project.survey.model.Survey;
import com.project.survey.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface SurveyRepo extends JpaRepository<Survey, Integer> {


    Set<Survey> findByUser(User user);
}
