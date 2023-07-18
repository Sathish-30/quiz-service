package com.learning.quiz_service.controller;



import com.learning.quiz_service.dto.QuizDTO;
import com.learning.quiz_service.model.QuestionWrapper;
import com.learning.quiz_service.model.Response;
import com.learning.quiz_service.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDTO quizDTO){
        return quizService.createQuiz(quizDTO.getCategoryName() , quizDTO.getNumQuestions() , quizDTO.getTitle() );
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
        return quizService.getQuizById(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<String> submitQuiz(@PathVariable Integer id , @RequestBody List<Response> responses){
        return quizService.checkResponse(id , responses);
    }
}
