package com.project.survey.service;

import com.project.survey.model.Response;
import com.project.survey.repo.ResponseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseService {

    private final ResponseRepo responseRepo;

    @Autowired
    public ResponseService(ResponseRepo responseRepo) {
        this.responseRepo = responseRepo;
    }

    public Response addResponse(Response response) {
        return responseRepo.save(response);

    }

    public  List<Response> getAllResponses(){
        return responseRepo.findAll();
    }

    public  Response getResponseById(int response_id) {
        return responseRepo.findById(response_id).orElse(null);
    }

}
