package app.enity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "results")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Results {

    @Id
    @SequenceGenerator(name="results_id_result_seq",sequenceName="results_id_result_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="results_id_result_seq")
    @Column(name = "id_result",nullable = false)
    private int resultsId;

    @Column(name = "fk_test_id")
    private int testId;

    @Column(name = "fk_respodent_id")
    private int respodentId;

    @Column(name = "fk_answer_id")
    private int answerId;

    @Column(name = "max_points")
    private int maxPoints;

    @Column(name = "achived_question_points")
    private int achivedQuestionPoints;

    @Column(name = "acvied_test_points")
    private int achivedTestPoints;

    @OneToMany(mappedBy = "questionId")
    private Collection<Answer> answers = new ArrayList<Answer>();

    @OneToMany(mappedBy = "testId")
    private Collection<Test> tests = new ArrayList<Test>();

    @OneToMany(mappedBy = "userId")
    private Collection<Respodent> respodents = new ArrayList<Respodent>();

    public int getResultsId() {
        return resultsId;
    }

    public void setResultsId(int resultsId) {
        this.resultsId = resultsId;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public int getRespodentId() {
        return respodentId;
    }

    public void setRespodentId(int respodentId) {
        this.respodentId = respodentId;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public int getAchivedQuestionPoints() {
        return achivedQuestionPoints;
    }

    public void setAchivedQuestionPoints(int achivedQuestionPoints) {
        this.achivedQuestionPoints = achivedQuestionPoints;
    }

    public int getAchivedTestPoints() {
        return achivedTestPoints;
    }

    public void setAchivedTestPoints(int achivedTestPoints) {
        this.achivedTestPoints = achivedTestPoints;
    }

    public Collection<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Collection<Answer> answers) {
        this.answers = answers;
    }

    public Collection<Test> getTests() {
        return tests;
    }

    public void setTests(Collection<Test> tests) {
        this.tests = tests;
    }

    public Collection<Respodent> getRespodents() {
        return respodents;
    }

    public void setRespodents(Collection<Respodent> respodents) {
        this.respodents = respodents;
    }
}
