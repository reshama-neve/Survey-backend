package com.project.survey.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Response {

    @Id
    @GeneratedValue
    private int response_id;
    private boolean save_unsave;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;


//    @OneToOne
//    @JoinColumn(name = "surveyResponse_id")
//    private SurveyResponse surveyResponse;

    @OneToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @OneToOne
    @JoinColumn(name = "survey_id")
    private Survey survey;

    //    @OneToOne
//    @JoinColumn(name = "user_id")
//    private User user;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
