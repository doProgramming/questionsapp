package app.view;

import app.enity.Answer;
import app.enity.Question;
import app.services.impl.AnswersServiceImpl;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Component
public class View {


    private AnswersServiceImpl answerService = new AnswersServiceImpl();

    private JPanel panel1;
    private JRadioButton yesRadioButton;
    private JRadioButton radioButton8;
    private JTextArea textArea1;
    private JButton nextQuestionButton;
    private JTextPane textPane1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    private JRadioButton radioButton5;
    private JRadioButton radioButton6;
    private JRadioButton radioButton7;
    private JButton Save;
    private JButton startTestButton;

    String pitanje = "pitanje";
    Collection<Answer> answers = new ArrayList<>();
    public View() {
        nextQuestionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextQuestion(e);
            }
        });
        startTestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextQuestion(e);

            }
        });
    }

    public void run() throws Exception {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrame jFrame = new JFrame("Java interview test");
                    jFrame.setContentPane(new View().panel1);
                    jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
                    jFrame.pack();
                    nextQuestionButton.setVisible(false);
                    Dimension dimension = new Dimension();
                    dimension.setSize(400,400);
                    jFrame.setMinimumSize(dimension);
                    jFrame.setVisible(true);
                    View frame = new View();
                    frame.panel1.setVisible(true);
                    panel1.setVisible(true);
                    yesRadioButton.setVisible(false);
                    Font font = new Font("Good Morning.ttf",2,12);
                    textPane1.setFont(font);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void nextQuestion(ActionEvent e){
        startTestButton.setVisible(false);
        Question question = new Question();
        try{
            question = answerService.askQuestion();
            if(question != null){
                answers = question.getAnswers();
            }
        }catch (Exception el){}
        textPane1.setText(question.getQuestionText());
        String allAnswers = null;
        int i=0;
        for(Answer answer : answers){
            ++i;
            switch (i){
                case 0:
                    radioButton2.setText(answer.getAnswerText());
                    radioButton2.updateUI();
                    break;
                case 1:
                    radioButton3.setText(answer.getAnswerText());
                    radioButton3.updateUI();
                    break;
                case 2:
                    radioButton4.setText(answer.getAnswerText());
                    radioButton4.updateUI();
                    break;
                case 3:
                    radioButton5.setText(answer.getAnswerText());
                    radioButton5.updateUI();
                    break;
                case 4:
                    radioButton6.setText(answer.getAnswerText());
                    radioButton6.updateUI();
                    radioButton2.setName(answer.getAnswerText());
                    break;
                case 5:
                    radioButton7.setText(answer.getAnswerText());
                    radioButton7.updateUI();
                    break;
                case 6:
                    yesRadioButton.setText(answer.getAnswerText());
                    yesRadioButton.updateUI();
                    break;
                case 7:
                    radioButton8.setText(answer.getAnswerText());
                    radioButton8.updateUI();
                    break;
            }
            allAnswers = allAnswers + answer.getAnswerText();
        }
        textArea1.isVisible();
    }
}