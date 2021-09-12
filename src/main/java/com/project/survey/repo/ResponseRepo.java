package com.project.survey.repo;

import com.project.survey.model.Question;
import com.project.survey.model.Response;
import com.project.survey.model.Survey;
import com.project.survey.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ResponseRepo  extends JpaRepository<Response,Integer> {
    Set<Response> findByQuestion(Question question);

    Set<Response> findByUser(User user);

    Set<Response> findBySurvey(Survey survey);
}
