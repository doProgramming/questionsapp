package app.enity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "test")
//lombok not working it is deprecated for this version of Java
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Test {

    @Id
    @SequenceGenerator(name="test_test_id_seq",sequenceName="test_test_id_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="test_test_id_seq")
    @Column(name = "test_id",nullable = false)
    private int testId;

    @Column(name = "number_points")
    private int numberOfPoints;

    @OneToMany(mappedBy = "questionId")
    private Collection<Question> questions = new ArrayList<Question>();

    //It must be mapped by questionId bcs all answers are grouped by there question it's unique on a group level
    @OneToMany(mappedBy = "questionId")
    private Collection<Answer> answers = new ArrayList<Answer>();

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    public Collection<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Collection<Question> questions) {
        this.questions = questions;
    }

    public Collection<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Collection<Answer> answers) {
        this.answers = answers;
    }
}
