package app.services.impl;

import app.enity.Answer;
import app.enity.Question;
import app.enity.Test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import app.services.AnswerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class AnswersServiceImpl implements AnswerService {

    private SessionFactory sessionFactory = null;

    @Override
    public void saveAnswer(Answer answer){
        Session session = createSessino();
        session.beginTransaction();
        session.save(answer);
        session.getTransaction().commit();
    }

    @Override
    public void saveQuestion(Question question) {
        Session session = createSessino();
        session.beginTransaction();
        session.save(question);
        session.getTransaction().commit();
    }

    @Override
    public List<String> getAnswers(Question question){
        Session session = createSessino();
        List<String> answers = new ArrayList<>();
        Object answerObject = session.load("questionId", question.getQuestionId());
        return answers;
    }

    @Override
    public List<Answer> getAllAnswers() {
        return null;
    }

    @Override
    public List<Question> getAllQuestions() {
        Session session = createSessino();
        session.beginTransaction();
        List<Question> questions = session.createCriteria(Question.class).list();
        session.close();
        return questions;
    }

    @Override
    public Answer getAnswer(int questionId) {
        return null;
    }

    @Override
    public Question getQuestion(int questionId) {
        return null;
    }

    @Override
    public Question getQuestion(String questionText) {
        Session session = createSessino();
        session.beginTransaction();
        Question question = (Question) session.createCriteria(questionText);
        return question;
    }

    @Override
    public Question askQuestion() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Random random = new Random();
        int getId = 0;
        Question question = null;

        //Here we get random question from DB
        while (question == null){
            getId = random.nextInt(2) + 1;
            try {
                question = session.load( Question.class, new Integer(getId) );
            }
            catch (NullPointerException e){}
            }
        return question;
    }

    @Override
    public void saveAnswerAndQuestion(Answer answer, Question question){
        Session session = createSessino();
        session.beginTransaction();
        session.save(question);
        answer.setQuestionId(question.getQuestionId());
        session.save(answer);
        session.getTransaction().commit();
        session.close();
    }

    private Session createSessino(){
        sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        return session;
    }

}
