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
@RequestMapping("/blankquiz")
public class BlankQuizController {
    private BlankQuizApplicationService blankQuizApplicationService;

    @Autowired
    public BlankQuizController(BlankQuizApplicationService blankQuizApplicationService) {
        this.blankQuizApplicationService = blankQuizApplicationService;
    }

    @GetMapping("/all")
    List<BlankQuiz> getAll() {
        return blankQuizApplicationService.getAll();
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    BlankQuizDTO create(@RequestBody BlankQuizCommand command) {
        final BlankQuizId id = blankQuizApplicationService.create(command);
        return BlankQuizDTO.from(id.toString());
    }

    @PutMapping("/{blankQuizId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void revise(@PathVariable String blankQuizId, @RequestBody BlankQuizCommand command) {
        blankQuizApplicationService.revise(blankQuizId, command);
    }

    @DeleteMapping("/delete/{blankQuizId}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable String blankQuizId) {
        blankQuizApplicationService.delete(blankQuizId);
    }

    @GetMapping("/{blankQuizId}")
    BlankQuiz find(@PathVariable String blankQuizId) {
        return blankQuizApplicationService.find(blankQuizId);
    }
}
