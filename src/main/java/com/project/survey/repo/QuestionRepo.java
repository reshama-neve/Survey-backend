package com.project.survey.repo;

import com.project.survey.model.Question;
import com.project.survey.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface QuestionRepo extends JpaRepository<Question, Integer> {
    Set<Question> findBySurvey(Survey survey);
}
