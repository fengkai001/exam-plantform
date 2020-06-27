package exam.blankquizContext.domain.model.blankquiz;

import exam.blankquizContext.domain.shared.Entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode(of = {"blankQuizId"})
public class BlankQuiz implements Entity<BlankQuiz> {
    private BlankQuizId blankQuizId;
    private String teacherId;
    private String context;
    private String referenceAnswer;
    private int score;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    private BlankQuiz(BlankQuizId blankQuizId, String teacherId, String context, String referenceAnswer, int score) {
        this.teacherId = teacherId;
        this.context = context;
        this.referenceAnswer = referenceAnswer;
        this.score = score;
        this.createTime = LocalDateTime.now();
        this.blankQuizId = blankQuizId;
    }

    public static BlankQuiz create(BlankQuizId id, String teacherId, String context, String referenceAnswer, int score) {
        validateBlankQuiz(score);
        return new BlankQuiz(id, teacherId, context, referenceAnswer, score);
    }

    public void revise(String teacherId, String context, String referenceAnswer, int score) {
        validateBlankQuiz(score);
        this.teacherId = teacherId;
        this.context = context;
        this.referenceAnswer = referenceAnswer;
        this.score = score;
        this.updateTime = LocalDateTime.now();
    }

    private static void validateBlankQuiz(int score) {
        if (0 >= score || score >= 100) {
            throw new IllegalScoreException(score);
        }
    }

    @Override
    public boolean sameIdentityAs(BlankQuiz other) {
        return blankQuizId.sameValueAs(other.blankQuizId);
    }
}
