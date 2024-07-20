package com.example.Quizzz.controller;

import com.example.Quizzz.model.Question;
import com.example.Quizzz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

//    @GetMapping("getQuestionByIdAndCategory/{id}/{category}")
//    public Question getQuestionByIdAndCategory(@PathVariable int id,@PathVariable String category){
//        return questionService.getQuestionByIdAndCategory(id,category);
//
//    }

    @PutMapping("editCategory/{id}/{category}")
    public ResponseEntity<String> editCategoryById(@PathVariable int id,@PathVariable String category){
        return questionService.editCategoryById(id,category);
    }
}
