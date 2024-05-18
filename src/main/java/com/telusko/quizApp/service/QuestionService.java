package com.telusko.quizApp.service;

import com.telusko.quizApp.Question;
import org.springframework.stereotype.Service;

import java.util.List;
//NB- the below service is just supposed to get data from the dao layer
//below we use @Service annotation to enable this class to handle objects such as the one in QuestionController class
//@Service is just like @Components, they serve same purpose but here we use @Service just because this is a service layer
@Service
public class QuestionService
{
//    below is a method of get all questions
    public List<Question> getAllQuestions()
    {

    }
}
