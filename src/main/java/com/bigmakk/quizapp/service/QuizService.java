package com.bigmakk.quizapp.service;

import com.bigmakk.quizapp.dao.QuestionDao;
import com.bigmakk.quizapp.dao.QuizDao;
import com.bigmakk.quizapp.model.Question;
import com.bigmakk.quizapp.model.QuestionWrapper;
import com.bigmakk.quizapp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<String> createQuiz(String category, int num, String title) {
        try{
            List<Question> questions=questionDao.findRandomQuestionsByCategory(category,num);
            Quiz quiz=new Quiz();
            quiz.setTitle(title);
            quiz.setQuestions(questions);
            quizDao.save(quiz);
            return new ResponseEntity<>("success",HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("fail", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
     Optional<Quiz> q= quizDao.findById(id);
     List<Question> questionsFromDb=q.get().getQuestions();
     List<QuestionWrapper> questionsForUser=new ArrayList<>();
     for(Question qu:questionsFromDb){
         QuestionWrapper qw=new QuestionWrapper(qu.getId(),qu.getDescription(), qu.getOption1(), qu.getOption2(),qu.getOption3(),qu.getOption4());
         questionsForUser.add(qw);
     }
     return new ResponseEntity<>(questionsForUser,HttpStatus.OK);
    }
}
