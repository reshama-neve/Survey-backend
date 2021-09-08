package com.project.survey.controller;

import com.project.survey.model.Question;
import com.project.survey.model.Response;
import com.project.survey.model.Survey;
import com.project.survey.model.User;
import com.project.survey.repo.ResponseRepo;
import com.project.survey.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("response")
@CrossOrigin("*")
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

    @GetMapping("/question/{question_id}")
    public ResponseEntity<?> getResponsesofQuestion(@PathVariable("question_id") int question_id) {
        {
            Question question = new Question();
            question.setQuestion_id(question_id);
            Set<Response> responseSet = this.responseService.getResponsesofQuestion(question);
            return ResponseEntity.ok(responseSet);
        }
    }

    @GetMapping("/user/{user_id}")
    public ResponseEntity<?> getResponsesofUser(@PathVariable("user_id") int user_id) {
        {
            User user = new User();
            user.setUser_id(user_id);
            Set<Response> responseSet = this.responseService.getResponsesofUser(user);
            return ResponseEntity.ok(responseSet);
        }
    }

}
