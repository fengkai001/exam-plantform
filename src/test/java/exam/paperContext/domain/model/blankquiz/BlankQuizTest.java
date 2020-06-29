package exam.paperContext.domain.model.blankquiz;


import exam.blankquizContext.domain.model.blankquiz.BlankQuiz;
import exam.blankquizContext.domain.model.blankquiz.BlankQuizId;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class BlankQuizTest {

    @Test
    public void test_blankquiz() {
        // create
        final BlankQuizId blankQuizId = new BlankQuizId("blankquiz-00000");
        final String teacherId = "teacher-11111";
        final String context = "good good study";
        final String referenceAnswer = "day day up";
        final int score = 20;

        BlankQuiz blankQuiz = BlankQuiz.create(blankQuizId, teacherId, context, referenceAnswer, score);
        assertThat(blankQuiz, is(notNullValue()));
        System.out.println("create");

        // update
        final String teacherId2 = "teacher-22222";
        blankQuiz.revise(teacherId2, context, referenceAnswer, score);
        assertThat(blankQuiz.getTeacherId(), is(teacherId2));
        System.out.println("update");
    }
}
