package com.bigmakk.quizapp.controller;

import com.bigmakk.quizapp.model.Question;
import com.bigmakk.quizapp.model.QuestionWrapper;
import com.bigmakk.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int num,@RequestParam String title){
        return quizService.createQuiz(category,num,title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id ){
        return quizService.getQuizQuestions(id);
    }
}
