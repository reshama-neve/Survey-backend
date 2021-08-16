package com.project.survey.repo;

import com.project.survey.model.Response;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponseRepo  extends JpaRepository<Response,Integer> {
}
