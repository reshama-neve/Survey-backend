package com.project.survey.repo;

import com.project.survey.model.QuestionOption;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionOptionRepo extends JpaRepository<QuestionOption, Integer> {

}
