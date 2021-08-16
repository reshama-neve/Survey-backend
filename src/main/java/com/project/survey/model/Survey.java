package com.project.survey.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Survey {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    private int survey_id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String link;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate = new Date(System.currentTimeMillis());
    @Column
    private String lastEditedBy;

    @ManyToMany
    @JoinTable(name = "admin_survey",
            joinColumns = @JoinColumn(name = "survey_id"),
            inverseJoinColumns = @JoinColumn(name = "admin_id"))
    private List<Admin> admin;

//    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    private Set<QuestionOption> optionSet;

}
