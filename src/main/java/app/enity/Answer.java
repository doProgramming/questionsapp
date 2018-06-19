package app.enity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "answers")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Answer {

    @Id
    @SequenceGenerator(name="answers_answer_id_seq",sequenceName="answers_answer_id_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="answers_answer_id_seq")
    @Column(name = "answer_id")
    private int answerId;

    @Column(name = "answer_text")
    private String answerText;

    @Column(name = "fk_question_id")
    private int questionId;

    @Column(name = "is_true")
    private Boolean isTrue;

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public String getAnswerText() {
        return answerText;
    }

    public int getQuestions() {
        return questionId;
    }

    public void setQuestionId(int questions) {
        this.questionId = questions;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public Boolean getTrue() {
        return isTrue;
    }

    public void setTrue(Boolean aTrue) {
        isTrue = aTrue;
    }
}
