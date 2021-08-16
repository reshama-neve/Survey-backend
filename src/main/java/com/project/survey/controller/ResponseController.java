package com.project.survey.controller;

import com.project.survey.model.Response;
import com.project.survey.repo.ResponseRepo;
import com.project.survey.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("response")
public class ResponseController {

    private final ResponseRepo responseRepo;
    private final ResponseService responseService;

    @Autowired
    public ResponseController(ResponseRepo responseRepo, ResponseService responseService) {
        this.responseRepo = responseRepo;
        this.responseService = responseService;
    }

    @PostMapping("/addResponse")
    public ResponseEntity<Response> addResponse(@RequestBody Response response){
        Response newResponse=responseService.addResponse(response);
        return new ResponseEntity<>(newResponse, HttpStatus.CREATED);

    }

    @GetMapping("/allResponses")
    public ResponseEntity<List<Response>> getAllResponses(){
        List<Response> response=responseService.getAllResponses();
        return new ResponseEntity<>(response,HttpStatus.CREATED);

    }

    @GetMapping("/responseById/{response_id}")
    public ResponseEntity<Response> getResponseById(@PathVariable("response_id") int response_id){
        Response response1=responseService.getResponseById(response_id);
        return new ResponseEntity<>(response1,HttpStatus.CREATED);

    }

}
