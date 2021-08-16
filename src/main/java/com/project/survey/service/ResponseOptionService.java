package com.project.survey.service;

import com.project.survey.model.ResponseOption;
import com.project.survey.repo.ResponseOptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseOptionService {

    private final ResponseOptionRepo responseOptionRepo;

    @Autowired
    public ResponseOptionService(ResponseOptionRepo responseOptionRepo) {
        this.responseOptionRepo = responseOptionRepo;
    }

    public ResponseOption addResponseOption(ResponseOption responseOption) {
        return responseOptionRepo.save(responseOption);

    }

    public List<ResponseOption> getAllResponseOptions(){
        return responseOptionRepo.findAll();
    }

    public  ResponseOption findResponseOptionById(int option_id) {
        return responseOptionRepo.findById(option_id).orElse(null);
    }

}

