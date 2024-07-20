package com.example.Quizzz.service;

import com.example.Quizzz.dao.QuestionDao;
import com.example.Quizzz.dao.Quizdao;
import com.example.Quizzz.model.Question;
import com.example.Quizzz.model.QuestionWrapper;
import com.example.Quizzz.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    Quizdao quizdao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int noQ,String title){
        List<Question> qlist=questionDao.findRandomQuestionsByCategory(category,noQ);

        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(qlist);
        quizdao.save(quiz);
        return new ResponseEntity<>("success",HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {

        Optional<Quiz> quiz=quizdao.findById(id);
        List<Question> qByDb=quiz.get().getQuestions();
        List<QuestionWrapper> qForUsers=new ArrayList<>();

        for(Question q:qByDb){
            QuestionWrapper qw=new QuestionWrapper(q.getId(), q.getQuestion(), q.getOption1(),q.getOption2(),q.getOption3());
            qForUsers.add(qw);
        }

        return new ResponseEntity<>(qForUsers,HttpStatus.OK);
    }
}
