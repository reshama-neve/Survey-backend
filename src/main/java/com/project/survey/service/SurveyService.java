package com.project.survey.service;
import com.project.survey.model.Survey;
import com.project.survey.repo.SurveyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyService {

    private final SurveyRepo surveyRepo;

    @Autowired
    public SurveyService(SurveyRepo surveyRepo) {
        this.surveyRepo = surveyRepo;
    }

    public Survey addSurvey(Survey survey) {
        return surveyRepo.save(survey);
    }

    public List<Survey> getAllSurveys() {
        return surveyRepo.findAll();
    }

    public Survey getSurveyById(int id){
        return surveyRepo.findById(id).orElse(null);

    }

}

