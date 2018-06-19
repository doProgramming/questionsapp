package app.enity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "questions")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Question {

    @Id
    @SequenceGenerator(name="questions_question_id_seq",sequenceName="questions_question_id_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="questions_question_id_seq")
    @Column(name = "question_id",nullable = false)
    private int questionId;

    @Column(name = "question_text")
    private String questionText;

    @Column(name = "type")
    private int type;

    @OneToMany(mappedBy = "questionId")
    private Collection<Answer> answers = new ArrayList<Answer>();

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public int getType() {
        return type;
    }

    public Collection<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Collection<Answer> questions) {
        this.answers = questions;
    }

    public void setType(int type) {
        this.type = type;

    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
}
