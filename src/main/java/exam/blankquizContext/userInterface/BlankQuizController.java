package exam.blankquizContext.userInterface;

import exam.blankquizContext.application.BlankQuizApplicationService;
import exam.blankquizContext.application.BlankQuizCommand;
import exam.blankquizContext.domain.model.blankquiz.BlankQuiz;
import exam.blankquizContext.domain.model.blankquiz.BlankQuizId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlankQuizController {
    private BlankQuizApplicationService blankQuizApplicationService;

    @Autowired
    public BlankQuizController(BlankQuizApplicationService blankQuizApplicationService) {
        this.blankQuizApplicationService = blankQuizApplicationService;
    }

    @GetMapping("/blankquizzes")
    List<BlankQuiz> getAll() {
        return blankQuizApplicationService.getAll();
    }

    @PostMapping("/blankquiz")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    BlankQuizDTO create(@RequestBody BlankQuizCommand command) {
        final BlankQuizId id = blankQuizApplicationService.create(command);
        return BlankQuizDTO.from(id);
    }

    @PutMapping("/blankquiz/{blankQuizId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void revise(@PathVariable String blankQuizId, @RequestBody BlankQuizCommand command) {
        blankQuizApplicationService.update(blankQuizId, command);
    }

    @PutMapping("/blankquiz/delete/{blankQuizId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable String blankQuizId) {
        blankQuizApplicationService.delete(blankQuizId);
    }
}
