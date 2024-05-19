package com.telusko.quizApp.service;

import com.telusko.quizApp.model.Question;
import com.telusko.quizApp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
//NB- the below service is just supposed to get data from the dao layer
//below we use @Service annotation to enable this class to handle objects such as the one in QuestionController class
//@Service is just like @Components, they serve same purpose but here we use @Service just because this is a service layer
@Service
public class QuestionService
{

//    here we want access to Dao class thus we  get question dao object here
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category)
    {
        try {
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
//        if something goes wrong we return an empty array
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
//        we dont have a method to get by category thus we go to dao jpa and describe it.

    }

    //    below is a method of get all questions
    public ResponseEntity<List<Question>> getAllQuestions()
    {
//        using this dao I file a method to get the questions.
//        but in questionDao class we don't have that method thus we should create the method.
//        we want this method to return the list of questions gotten from the database thus we use questionDao and findAll method which will return all the questions//        instead of returning a list of questions, we can create a new object, response which is in a form of an entity
//        responseEntity has 2 parameters, 1. Actual data we want to return, 2. status code
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
//        if something goes wrong we return an empty array
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question) {
//        here we add the question but how?
//        the way we did findAll, findByCategory there should be a method in dao which you don't have to define
         questionDao.save(question);
            return new ResponseEntity<>("success",HttpStatus.CREATED);
    }
}
