package exam.blankquizContext.infrastructure;

import exam.blankquizContext.domain.model.blankquiz.BlankQuiz;
import exam.blankquizContext.domain.model.blankquiz.BlankQuizId;
import exam.blankquizContext.domain.model.blankquiz.BlankQuizRepository;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class MemoryBlankQuizRepository implements BlankQuizRepository {
    private Set<BlankQuiz> blankQuizSet = new HashSet<>();

    @Override
    public BlankQuiz find(BlankQuizId id) {
        return blankQuizSet.stream().filter(
                blankQuiz -> {
                    return blankQuiz.getBlankQuizId().equals(id);
                }
        ).findFirst().orElseThrow(NullPointerException::new);
    }

    @Override
    public void save(BlankQuiz blankQuiz) {
        blankQuizSet.add(blankQuiz);
    }

    @Override
    public void delete(BlankQuizId id) {
        blankQuizSet.remove(find(id));
    }

    @Override
    public BlankQuizId nextId() {
        return new BlankQuizId("BlankQuiz-" + UUID.randomUUID().toString());
    }

    @Override
    public List<BlankQuiz> getAll() {
        return blankQuizSet.stream().collect(Collectors.toList());
    }
}
