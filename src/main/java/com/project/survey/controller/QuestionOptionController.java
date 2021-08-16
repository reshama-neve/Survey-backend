package com.project.survey.controller;

import com.project.survey.model.Question;
import com.project.survey.model.QuestionOption;
import com.project.survey.repo.QuestionOptionRepo;
import com.project.survey.repo.QuestionRepo;
import com.project.survey.service.QuestionOptionService;
import com.project.survey.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//import static com.project.survey.service.ResponseUtil.resourceUri;

@RestController
@RequestMapping("question")
public class QuestionOptionController {

    private final QuestionOptionService questionOptionService;

    @Autowired
    public QuestionOptionController(QuestionOptionService questionOptionService)
    {
        this.questionOptionService = questionOptionService;
    }

    @GetMapping("/allOptions")
    public ResponseEntity<List<QuestionOption>> getAllOptions(){
        List<QuestionOption> options = questionOptionService.getAllOptions();
        return new ResponseEntity<>(options, HttpStatus.OK);
    }

    @PostMapping("/addOption")
    public ResponseEntity<QuestionOption> addQuestionOption(@RequestBody QuestionOption questionOption){
        QuestionOption newQuestionOption = questionOptionService.addOption(questionOption);
        return new ResponseEntity<>(newQuestionOption, HttpStatus.CREATED);
    }

//    @GetMapping("/{question_id}/getOptions")
//    public Page<QuestionOption> getAllOptionsByQuestionId(
//            @PathVariable(value = "question_id") int question_id,Pageable pageable)
//    {
//        return questionOptionRepo.findByQuestionId(question_id, pageable);
//    }
//
//    @PostMapping("{question_id}/addOptions")
//    public ResponseEntity<QuestionOption> addOption(
//            @PathVariable(value = "question_id") int question_id,
//            @RequestBody QuestionOption questionOption)
//    {
//        return questionRepo.findById(question_id)
//                .map(question -> {
//                    questionOption.set(question);
//                    return questionOption.save(questionOption);
//                })
//                .map(
//                        book -> ResponseEntity.created(resourceUri(book.getId()))
//                                .body(book)
//                ).orElseThrow(
//                        () -> new ResourceNotFoundException(
//                                "AuthorId " + authorId + " not found"
//                        )
//                );
//    }

}
