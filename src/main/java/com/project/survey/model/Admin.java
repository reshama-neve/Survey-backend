package com.project.survey.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Admin
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer admin_id;

    private String first_name;
    private String last_name;
    private String username;
    private String password;

    @JsonIgnore
    @ManyToMany(mappedBy = "admin")
    private List<Survey> admin_survey;
}
