package com.project.survey.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "survey_id", nullable = false)
    private Survey survey;

    //    @OneToOne
//    @JoinColumn(name = "user_id")
//    private User user;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
