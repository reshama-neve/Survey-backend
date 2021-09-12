package com.project.survey.controller;

import com.project.survey.model.Response;
import com.project.survey.model.Survey;
import com.project.survey.model.User;
import com.project.survey.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("survey")
@CrossOrigin("*")
public class SurveyController {

    private final SurveyService surveyService;

    @Autowired
    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @PostMapping("/addSurvey")
    public ResponseEntity<Survey> addSurvey(@RequestBody Survey survey){
        Survey newSurvey = surveyService.addSurvey(survey);
        return new ResponseEntity<>(newSurvey, HttpStatus.CREATED);
    }

    @GetMapping("/allSurveys")
    public ResponseEntity<List<Survey>> getAllSurveys(){
        List<Survey> surveys = surveyService.getAllSurveys();
        return new ResponseEntity<>(surveys, HttpStatus.OK);
    }

    @GetMapping("/{survey_id}")
    public Survey getSurveyById(@PathVariable int survey_id) {
        return surveyService.getSurveyById(survey_id);
    }

    @GetMapping("/user/{user_id}")
    public ResponseEntity<?> getSurveysofUser(@PathVariable("user_id") int user_id) {
        {
            User user = new User();
            user.setUser_id(user_id);
            Set<Survey> surveySet = this.surveyService.getSurveysofUser(user);
            return ResponseEntity.ok(surveySet);
        }
    }
}
