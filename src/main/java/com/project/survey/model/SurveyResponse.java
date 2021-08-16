package com.project.survey.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SurveyResponse {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int surveyResponse_id;

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
