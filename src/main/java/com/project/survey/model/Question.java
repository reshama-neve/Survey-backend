package com.project.survey.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int question_id;
    private String question_text;
    private String answer_type;

//    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    private Set<QuestionOption> optionSet;

//    @JsonIgnore
//    @OneToMany(mappedBy = "question")
//    private List<QuestionOption> questionOptionList;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "survey_id", nullable = false)
    private Survey survey;

}



