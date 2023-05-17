package com.robertgordon.valoracademy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.robertgordon.valoracademy.model.Quiz_Question;
import com.robertgordon.valoracademy.service.QuizService;
import com.robertgordon.valoracademy.service.Quiz_QuestionService;

@RestController
@RequestMapping("/api/v1/")
public class Quiz_QuestionController {

    @Autowired
    private Quiz_QuestionService quiz_questionService;

    @Autowired
    private QuizService quizService;

    @PostMapping("/quizzes/{quizid}/questions")
    public ResponseEntity<Quiz_Question> createQuiz_Question(@PathVariable("quizid") Long quizId,
            @RequestBody Quiz_Question quiz_questionRequest) {

        this.quizService.getQuizById(quizId).getQuestions().add(quiz_questionRequest);

        Quiz_Question quiz_question = this.quiz_questionService.saveQuiz_Question(quiz_questionRequest);

        return ResponseEntity.ok(quiz_question);
    }

    @GetMapping("questions")
    public List<Quiz_Question> getAllQuiz_Questions() {
        return this.quiz_questionService.getAllQuiz_Questions();
    }

    @GetMapping("questions/{id}")
    public ResponseEntity<Quiz_Question> getQuiz_QuestionById(@PathVariable("id") Long quiz_questionId) {

        Quiz_Question quiz_question = this.quiz_questionService.getQuiz_QuestionById(quiz_questionId);

        return ResponseEntity.ok(quiz_question);
    }

    @PutMapping("questions/{id}")
    public ResponseEntity<Quiz_Question> updateQuiz_Question(@PathVariable("id") Long quiz_questionId,
            @RequestBody Quiz_Question quiz_question) {

        Quiz_Question existingQuiz_Question = this.quiz_questionService.updateQuiz_Question(quiz_questionId,
                quiz_question);
        return ResponseEntity.ok(existingQuiz_Question);
    }

    @DeleteMapping("questions/{id}")
    public ResponseEntity<String> deleteQuiz_Question(@PathVariable("id") Long quiz_questionId) {

        this.quiz_questionService.deleteQuiz_Question(quiz_questionId);
        return ResponseEntity.ok("Quiz Question with ID: " + quiz_questionId + " has been deleted");
    }
}
