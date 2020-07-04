package exam.blankquizContext.application;

import exam.blankquizContext.domain.model.blankquiz.BlankQuiz;
import exam.blankquizContext.domain.model.blankquiz.BlankQuizId;
import exam.blankquizContext.domain.model.blankquiz.BlankQuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlankQuizApplicationService {
    private BlankQuizRepository blankQuizRepository;

    @Autowired
    public BlankQuizApplicationService(BlankQuizRepository blankQuizRepository) {
        this.blankQuizRepository = blankQuizRepository;
    }

    public BlankQuizId create(BlankQuizCommand command) {
        final String teacherId = command.getTeacherId();
        final String content = command.getContent();
        final String referanceAnswer = command.getReferenceAnswer();
        final int score = command.getScore();
        final BlankQuizId id = blankQuizRepository.nextId();

        final BlankQuiz blankQuiz = BlankQuiz.create(id, teacherId, content, referanceAnswer, score);
        blankQuizRepository.save(blankQuiz);
        return id;
    }

    public void revise(String blankQuizId, BlankQuizCommand command) {
        final BlankQuiz blankQuiz = blankQuizRepository.find(new BlankQuizId(blankQuizId));
        final String teacherId = command.getTeacherId();
        final String content = command.getContent();
        final String referenceAnswer = command.getReferenceAnswer();
        final int score = command.getScore();

        blankQuiz.revise(teacherId, content, referenceAnswer, score);
        blankQuizRepository.save(blankQuiz);
    }

    public void delete(String blankQuizId) {
        blankQuizRepository.delete(new BlankQuizId(blankQuizId));
    }

    public BlankQuiz find(String blankQuizId) {
        return blankQuizRepository.find(new BlankQuizId(blankQuizId));
    }

    public List<BlankQuiz> getAll() {
        return blankQuizRepository.getAll();
    }
}
