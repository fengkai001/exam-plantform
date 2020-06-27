package exam.blankquizContext.userInterface;


import exam.blankquizContext.domain.model.blankquiz.BlankQuizId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BlankQuizDTO {
    private String uri;

    public static BlankQuizDTO from(BlankQuizId blankQuizId) {
        return new BlankQuizDTO("papers/" + blankQuizId);
    }
}
