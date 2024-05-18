package com.telusko.quizApp.controller;

import com.telusko.quizApp.Question;
import com.telusko.quizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
//    we also change below to mach our response entity below in return
    public ResponseEntity<List<Question>> getAllQuestions()
    {

//        below instead of returning the text I want to return data from the service layer
//        thus we create an object of the service layer which get's all wuestions
//        most of the time you will have the same method name but sometime it can be different
//        below we are assuming that in the service class we have the same method getAllQuestion
//        we also need to go above and create the object questionService

        return questionService.getAllQuestions();
    }


//    now we want to work on how we can access questions from a particular category
//    this getQuestionByCategory will accept a value because you have to mention the category
//    we are getting the category from client side thus we use GetMapping
//    @GetMapping("category/{category}") this part shows how we access this method in chrome thus "category" is how and {category} will store the variable of the category
//    @PathVariable is used to get the {category} and store it on that string category.And since they are same no need for this @PathVariable("cat") String category  if {cat) was used above there
    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category)
    {
//        we create this getQuestionByCategory in the service layer because it's the one to get from dao
        return questionService.getQuestionsByCategory(category);
    }


//    now we want to add questions
//    we might want to receive the questions from  client side
//    whatever we receive must be in the form of a question(json format)
//we include @RequestBody because we are sending data in the request from client side to server in a body.In the request we have multiple sections,in the body you have the data
//    when you fetch data from a server, we do Getmapping , when sending data to server use postmapping
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
//        once you receive the question, how do u add that in database, do below

        return questionService.addQuestion(question);
    }
}
