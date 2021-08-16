package com.project.survey.controller;

import com.project.survey.model.Question;
import com.project.survey.repo.QuestionRepo;
import com.project.survey.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//import static com.project.survey.service.ResponseUtil.resourceUri;

@RestController
@RequestMapping("question")
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/addQuestion")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question){
        Question newQuestion = questionService.addQuestion(question);
        return new ResponseEntity<>(newQuestion, HttpStatus.CREATED);
    }

//    public ResponseEntity<Question> addQuestion(@RequestBody Question question){
//        return Optional.of(question)
//                .map(questionRepo::save)
//                .map(
//                        author -> ResponseEntity
//                                .created(resourceUri(question.getQuestion_id()))
//                                .body(question)
//                )
//                .orElseThrow(IllegalArgumentException::new);
//    }
//
//    @GetMapping("/allQuestions")
//    public Page<Question> getAllQuestions(Pageable pageable) {
//        return questionRepo.findAll(pageable);
//    }
//    @PutMapping("/updateQuestion/{question_id}")
//    public ResponseEntity<Question> updateQuestion(
//            @PathVariable final Long authorId,
//            @Valid @RequestBody Author request
//    ) {
//        return authorRepository.findById(authorId)
//                .map(
//                        author -> {
//                            author.setAge(request.getAge());
//                            author.setBirthDate(request.getBirthDate());
//                            author.setName(request.getName());
//                            return author;
//                        }
//                )
//                .map(authorRepository::save)
//                .map(author -> ResponseEntity
//                        .ok()
//                        .location(resourceUri(authorId))
//                        .body(author))
//                .orElseThrow(
//                        () -> new ResourceNotFoundException(
//                                "AuthorID " + authorId + " not found"
//                        )
//                );
//    }
//
    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        List<Question> questions = questionService.getAllQuestions();
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

}
