package com.project.survey.controller;

import com.project.survey.model.Survey;
import com.project.survey.model.SurveyResponse;
import com.project.survey.repo.SurveyResponseRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("SR_id")
public class SurveyResponseController {

    private final SurveyResponseRepo surveyResponseRepo;

    public SurveyResponseController(SurveyResponseRepo surveyResponseRepo) {
        this.surveyResponseRepo = surveyResponseRepo;
    }

    @PostMapping("/addSR_id")
    public ResponseEntity<SurveyResponse> addSurveyResponse(@RequestBody SurveyResponse surveyResponse){
        SurveyResponse newSurveyResponse = surveyResponseRepo.save(surveyResponse);
        return new ResponseEntity<>(newSurveyResponse, HttpStatus.CREATED);
    }

    @GetMapping("/allSR_id")
    public ResponseEntity<List<SurveyResponse>> getAllSurveyResponse(){
        List<SurveyResponse> surveyResponses = surveyResponseRepo.findAll();
        return new ResponseEntity<>(surveyResponses, HttpStatus.OK);
    }

}
