package com.project.survey.repo;

import com.project.survey.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepo extends JpaRepository<Survey, Integer> {


}
