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
public class ResponseOption {

    @Id
    @GeneratedValue
    private int option_id;
    private String answer;
    

    @OneToOne
    @JoinColumn(name = "response_id")
    private Response Response;	
}
