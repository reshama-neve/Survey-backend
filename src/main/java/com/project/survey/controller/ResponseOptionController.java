package com.project.survey.controller;

import com.project.survey.model.ResponseOption;
import com.project.survey.service.ResponseOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("responseOption")
public class ResponseOptionController {

    private final ResponseOptionService responseOptionService;

    @Autowired
    public ResponseOptionController(ResponseOptionService responseOptionService) {
        this.responseOptionService = responseOptionService;
    }

    @PostMapping("/addResponseOption")
    public ResponseEntity<ResponseOption> addResponseOption(@RequestBody ResponseOption responseOption){
        ResponseOption newResponseOption =responseOptionService.addResponseOption(responseOption);
        return new ResponseEntity<>(newResponseOption, HttpStatus.CREATED);

    }
    @GetMapping("/allResponseOptions")
    public ResponseEntity<List<ResponseOption>> getAllResponseOptions(){
        List<ResponseOption> responseOptions=responseOptionService.getAllResponseOptions();
        return new ResponseEntity<>(responseOptions,HttpStatus.CREATED);

    }

    @GetMapping("responseOptionById/{option_id}")
    public ResponseEntity<ResponseOption> getResponseOptionById(@PathVariable("option_id") int option_id){
        ResponseOption resoption1 = responseOptionService.findResponseOptionById(option_id);
        return new ResponseEntity<>(resoption1,HttpStatus.CREATED);

    }
}
