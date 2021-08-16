package com.project.survey.service;

import com.project.survey.model.Question;
import com.project.survey.model.QuestionOption;
import com.project.survey.repo.QuestionOptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionOptionService {

    private final QuestionOptionRepo questionOptionRepo;

    @Autowired
    public QuestionOptionService(QuestionOptionRepo questionOptionRepo) {
        this.questionOptionRepo = questionOptionRepo;
    }

    public QuestionOption addOption(QuestionOption questionOption) {
        return questionOptionRepo.save(questionOption);
    }

    public List<QuestionOption> getAllOptions() {
        return questionOptionRepo.findAll();
    }
}
