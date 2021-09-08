package com.project.survey.service;

import com.project.survey.model.Question;
import com.project.survey.model.Response;
import com.project.survey.model.User;
import com.project.survey.repo.ResponseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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

    public Set<Response> getResponsesofQuestion(Question question) {
        return this.responseRepo.findByQuestion(question);
    }

    public Set<Response> getResponsesofUser(User user) {
        return this.responseRepo.findByUser(user);
    }
}
