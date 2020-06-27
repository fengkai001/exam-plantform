package exam.blankquizContext.application;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BlankQuizCommand {
    private String teacherId;
    private String content;
    private String referenceAnswer;
    private int score;
}
