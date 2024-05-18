package com.telusko.quizApp.dao;

import com.telusko.quizApp.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//we use @Repository
//      but even if we create the method we have to fetch data from the database.InJDBC we have to write the 7 steps
//      ie, file the sql query...alot but with the help of data jpa we just have to extend JpaRepository to do all that work
//      thus we change public class QuestionDao to below
//      jpa needs only two things 1. type of table your working with, 2.the type of primary key
@Repository
public interface QuestionDao extends JpaRepository<Question, Integer>
{
//    thus here things like fetching, saving data from database will be handled by jpa
}
