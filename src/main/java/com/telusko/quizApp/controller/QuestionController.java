package com.telusko.quizApp.controller;

import com.telusko.quizApp.Question;
import com.telusko.quizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//this is where we are going to accept the request thus we put annotation @RestController
//this questionController will only work with question
//in a quiz controller before answering any question you first asked what questions you want thus for that we would have a different controller ie. quizController

@RestController
//whatever request is coming for question this is the controller that will handle it
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

//    I want to accept that request of /allQuestions thus for that we have to create a method
//    for this to be accessed we need to map it with allQuestions
    @GetMapping("allQuestions")
//    below we want to return an object not a string thus we change public String getAllQuestions() to below
//    and remember we are returning a list of questions not one question thus we change this public Question getAllQuestions() to below
    public List<Question> getAllQuestions()
    {
//        below instead of returning the text I want to return data from the service layer
//        thus we create an object of the service layer which get's all wuestions
//        most of the time you will have the same method name but sometime it can be different
//        below we are assuming that in the service class we have the same method getAllQuestion
//        we also need to go above and create the object questionService
        return questionService.getAllQuestions();
    }
}
