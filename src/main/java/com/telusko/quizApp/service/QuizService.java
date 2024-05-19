package com.telusko.quizApp.service;

import com.telusko.quizApp.dao.QuizDao;
import com.telusko.quizApp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuizService
{
    @Autowired
    QuizDao quizDao;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title)
    {
        Quiz quiz = new Quiz();
        quiz.setTitle("title");

    }
}
