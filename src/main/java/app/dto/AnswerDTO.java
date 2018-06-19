package app.dto;

import lombok.Data;

@Data
public class AnswerDTO {

    private int answerId;
    private String answerText;
    private int questionId;
}
