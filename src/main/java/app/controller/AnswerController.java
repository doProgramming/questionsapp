package app.controller;

import app.enity.Answer;
import app.enity.Question;
import app.services.impl.AnswersServiceImpl;
import app.view.View;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import app.services.AnswerService;

import java.util.Random;

@RestController
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @Autowired
    private View view;

    @RequestMapping(value = "/updateAnswer", method = RequestMethod.GET)
    public void save(@RequestParam(name = "question") String question,
                     @RequestParam("answer") String answer,
                     @RequestParam("idQuestion") int idQuestion,
                     @RequestParam("isTrue") Boolean isTrue,
                     @RequestParam("type") int type){
        Answer answers = new Answer();
        Question questions = new Question();
        questions.setType(2);
        questions.setQuestionText(question);
        questions.setType(type);
        answers.setAnswerText(answer);
        answers.setQuestionId(idQuestion);
        answers.setTrue(isTrue);
        answerService.saveAnswerAndQuestion(answers,questions);
    }

    @RequestMapping(value = "/saveQuestion",method = RequestMethod.GET)
    public void saveMethod(@RequestParam(name = "question") String question,@RequestParam(name = "type") int type){
        Question questions = new Question();
        questions.setQuestionText(question);
        questions.setType(type);
        answerService.saveQuestion(questions);
    }

    //For creating new question and new answers
    @RequestMapping(value = "/saveQuestionWithAnswer",method = RequestMethod.GET)
    public Answer insertNewQuestion(@RequestParam(name = "question") String question,
                                    @RequestParam(name = "type") int type,
                                    @RequestParam(name = "answer") String answer,
                                    @RequestParam(name = "isTrue") Boolean isTrue){
        Question questions = new Question();
        Answer answers = new Answer();
        questions.setQuestionText(question);
        questions.setType(type);
        answers.setAnswerText(answer);
        answers.setTrue(isTrue);
        answers.setAnswerId(questions.getQuestionId());
        answerService.saveAnswerAndQuestion(answers,questions);
        return  answers;
    }

    @RequestMapping(value = "/askQuestion", method = RequestMethod.GET)
    public String test (){
       return  answerService.askQuestion().getQuestionText();
    }

    @RequestMapping(value = "/getAnswer", method = RequestMethod.GET)
    public Answer question (@RequestParam (name = "id") int id){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Answer answer = session.load( Answer.class, new Integer(id) );
        return answer;
    }

}
