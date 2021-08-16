package com.project.survey.model;

import javax.management.relation.RelationNotification;
import javax.persistence.*;


@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userRoleId;


    //user
    @ManyToOne(fetch=FetchType.EAGER)
    private User user;

    public void setRole(Role role) {
        this.role = role;
    }

    @ManyToOne
    private Role role;


    public RelationNotification getRole() {
        return null;
    }
}
