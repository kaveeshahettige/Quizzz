package com.example.Quizzz.controller;

import com.example.Quizzz.model.QuestionWrapper;
import com.example.Quizzz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int noQ,@RequestParam String title){
        return quizService.createQuiz(category,noQ,title);
        //return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable int id){
        return quizService.getQuizQuestions(id);

    }
}
