package exam.blankquizContext.domain.model.blankquiz;

public class IllegalScoreException extends IllegalArgumentException {
    public IllegalScoreException(int score) {
        super("IllegalScoreException: exception score range is (0, 100) )" + score);
    }
}
