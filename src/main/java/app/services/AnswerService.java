package app.services;

import app.enity.Answer;
import app.enity.Question;

import java.util.List;

/**
 *
 * API for @see {@link app.services.impl.AnswersServiceImpl}
 *
 *
 * */

public interface AnswerService {

    void saveAnswerAndQuestion(Answer answer, Question question);
    void saveAnswer (Answer answer);
    void saveQuestion(Question question);
    Question askQuestion();
    List<String> getAnswers(Question question);
    List<Answer> getAllAnswers();
    List<Question> getAllQuestions();
    Answer getAnswer(int questionId);
    Question getQuestion(int questionId);
    Question getQuestion(String questionText);
}
