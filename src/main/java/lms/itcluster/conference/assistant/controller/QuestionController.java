package lms.itcluster.conference.assistant.controller;

import lms.itcluster.conference.assistant.service.QuestionService;
import lms.itcluster.conference.assistant.service.dto.QuestionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @PostMapping("/add-question")
    public String addQuestion(QuestionDto question) {
        questionService.addQuestion(question);

        return "redirect:/topic/" + question.getTopicId();
    }
}
