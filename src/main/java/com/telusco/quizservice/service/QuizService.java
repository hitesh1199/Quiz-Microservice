package com.telusco.quizservice.service;

import com.telusco.quizservice.dao.QuizDao;
import com.telusco.quizservice.feign.QuizInterface;
import com.telusco.quizservice.model.QuestionWrapper;
import com.telusco.quizservice.model.Quiz;
import com.telusco.quizservice.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;


@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;

    @Autowired
    QuizInterface quizInterface;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Integer> questions = quizInterface.getQuestionsForQuiz(category , numQ).getBody();
        Quiz quiz = new Quiz();
        quiz.setQuestionIds(questions);
        quiz.setTitle(title);
        quizDao.save(quiz);
        return new ResponseEntity<>("Success" , HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {

        //Have to fetch data from Question service : Use Rest Template
        List<QuestionWrapper> questionsForUser = new ArrayList<>();

        Quiz quiz = quizDao.findById(id).get();
        List<Integer> questionIds = quiz.getQuestionIds();
        ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionsFromId(questionIds);

        return questions;
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        ResponseEntity<Integer> score = quizInterface.getScore(responses);
        return score;
    }
}
