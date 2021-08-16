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

    @OneToOne
    @JoinColumn(name = "surveyResponse_id")
    private SurveyResponse surveyResponse;
    @OneToOne
    @JoinColumn(name = "question_id")
    private Question question;
}
