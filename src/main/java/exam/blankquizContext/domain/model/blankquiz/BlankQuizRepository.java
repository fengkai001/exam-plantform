package exam.blankquizContext.domain.model.blankquiz;

import java.util.List;

public interface BlankQuizRepository {
    BlankQuiz find(BlankQuizId id);

    void save(BlankQuiz blankQuiz);

    void delete(BlankQuizId id);

    BlankQuizId nextId();

    List<BlankQuiz> getAll();
}
