package exam.blankquizContext.userInterface;


import exam.blankquizContext.domain.model.blankquiz.BlankQuizId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BlankQuizDTO {
    private String blankQuizId;

    public static BlankQuizDTO from(String blankQuizId) {
        return new BlankQuizDTO(blankQuizId);
    }
}
