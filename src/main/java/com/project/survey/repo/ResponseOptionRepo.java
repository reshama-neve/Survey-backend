package com.project.survey.repo;

import com.project.survey.model.ResponseOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponseOptionRepo extends JpaRepository<ResponseOption,Integer>{
}
