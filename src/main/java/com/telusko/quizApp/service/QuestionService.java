package com.telusko.quizApp.service;

import com.telusko.quizApp.Question;
import com.telusko.quizApp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Question> getQuestionsByCategory(String category)
    {
//        we dont have a method to get by category thus we go to dao jpa and describe it.
        return questionDao.findByCategory(category);
    }

    //    below is a method of get all questions
    public List<Question> getAllQuestions()
    {
//        using this dao I file a method to get the questions.
//        but in questionDao class we dont have that method thus we should create the method.
//        we want this method to return the list of questions gotten from the database thus we use questionDao and findAll method which will return all the questions
        return questionDao.findAll();
    }

    public String addQuestion(Question question) {
//        here we add the question but how?
//        the way we did findAll, findByCategory there should be a method in dao which you don't have to define
         questionDao.save(question);
            return "success";
    }
}
