package app.view.impl;

import app.enity.Answer;
import app.enity.Question;
import app.enity.Respodent;
import app.enity.Test;
import app.services.impl.AnswersServiceImpl;
import app.view.TypeOfQuestions;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Component
public class View implements TypeOfQuestions {


    private AnswersServiceImpl answerService = new AnswersServiceImpl();

    private JPanel panel1;
    private JTextArea textArea1;
    private JButton nextQuestionButton;
    private JTextPane textPane1;
    private JRadioButton yesRadioButton;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    private JRadioButton radioButton5;
    private JRadioButton radioButton6;
    private JRadioButton radioButton7;
    private JRadioButton radioButton8;
    private JButton Save;
    private JButton startTestButton;
    private JProgressBar progressBar1;
    private JTextArea pointsText;
    private JPanel Points;
    int counterProgress = 0;
    int points;


    Collection<Answer> answers = new ArrayList<>();
    public View() {
        //buttonList.addAll(radioButton2,radioButton3,radioButton4,radioButton5,radioButton6,radioButton7,radioButton8,yesRadioButton);
//        radioButton2.setVisible(true);
//        radioButton3.setVisible(false);
//        radioButton4.setVisible(false);
//        radioButton5.setVisible(false);
//        radioButton6.setVisible(false);
//        radioButton7.setVisible(false);
//        radioButton8.setVisible(false);
//        yesRadioButton.setVisible(false);
        progressBar1.setMaximum(10);
        progressBar1.setStringPainted(true);
        textArea1.setText("John Test");
        textArea1.setVisible(true);
        textArea1.setEditable(false);

        nextQuestionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //progress bar
                progressBar1.setValue(counterProgress);
                counterProgress++;
                //Next question + adding answers
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
                    panel1.setBorder(new BevelBorder(22));
                    frame.panel1.setVisible(true);
                    panel1.setVisible(true);
                    Font font = new Font("Good Morning.ttf",2,25);
                    font.isBold();
                    textPane1.setFont(font);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }

    @Override
    public void nextQuestion(ActionEvent e){
        radioButton2.setVisible(false);
        radioButton3.setVisible(false);
        radioButton4.setVisible(false);
        radioButton5.setVisible(false);
        radioButton6.setVisible(false);
        radioButton7.setVisible(false);
        radioButton8.setVisible(false);
        yesRadioButton.setVisible(false);
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
        int i = 0;
        int point = 0;

        //Set credentials of user
        Test test = new Test();
        Respodent respodent = new Respodent();
        respodent.setName("Pero");
        respodent.setLastName("John");

        for(Answer answer : answers){
            ++i;
            switch (i){
                case 0:
                    //TODO make private method for test and answer tables
                    if(radioButton2.isSelected()){
                        if(answer.getTrue()){
                            point++;
                            points = points + point;
                        test.setNumberOfPoints(point);
                        test.setAnswers(question.getAnswers());
                        pointsText.setText(String.valueOf(points));
                        }
                    }
                    radioButton2.setText(answer.getAnswerText());
                    radioButton2.setVisible(true);
                    radioButton2.updateUI();
                    break;
                case 1:
                    if(radioButton3.isSelected()){
                        if(answer.getTrue()){
                            point++;
                            test.setNumberOfPoints(point);
                            test.setAnswers(question.getAnswers());
                            pointsText.setText(String.valueOf(point));
                        }
                    }
                    radioButton3.setText(answer.getAnswerText());
                    radioButton3.setVisible(true);
                    radioButton3.updateUI();
                    break;
                case 2:
                    radioButton4.setText(answer.getAnswerText());
                    radioButton4.setVisible(true);
                    radioButton4.updateUI();
                    break;
                case 3:
                    radioButton5.setText(answer.getAnswerText());
                    radioButton5.setVisible(true);
                    radioButton5.updateUI();
                    break;
                case 4:
                    radioButton6.setText(answer.getAnswerText());
                    radioButton6.setVisible(true);
                    radioButton6.updateUI();
                    break;
                case 5:
                    radioButton7.setText(answer.getAnswerText());
                    radioButton7.setVisible(true);
                    radioButton7.updateUI();
                    break;
                case 6:
                    yesRadioButton.setText(answer.getAnswerText());
                    yesRadioButton.setVisible(true);
                    yesRadioButton.updateUI();
                    break;
                case 7:
                    radioButton8.setText(answer.getAnswerText());
                    radioButton8.setVisible(true);
                    radioButton8.updateUI();
                    break;
            }
            allAnswers = allAnswers + answer.getAnswerText();
        }
        textArea1.isVisible();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

}