package com.bigmakk.quizapp.service;

import com.bigmakk.quizapp.dao.QuestionDao;
import com.bigmakk.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions() {
        List<Question>qlist=new ArrayList<>();
        qlist=questionDao.findAll();
        return qlist;
    }

    public List<Question> getQuestionsByCategory(String category) {

        List<Question>qlist=new ArrayList<>();
        qlist=questionDao.findByCategory(category);
        return qlist;
    }
}
