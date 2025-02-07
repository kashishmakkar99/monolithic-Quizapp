package com.bigmakk.quizapp.controller;


import com.bigmakk.quizapp.model.Question;
import com.bigmakk.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestions")
    public List<Question> getAllQuestions(){
        List<Question> qlist=new ArrayList<>();
        qlist=questionService.getAllQuestions();
        return qlist;
    }



    @GetMapping("category/{category}")
    public List<Question>getQuestionsByCategory(@PathVariable String category){
        List<Question> qlist=new ArrayList<>();
        qlist=questionService.getQuestionsByCategory(category);
        return qlist;
    }

    @PostMapping("add")
    public String  addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }
}
