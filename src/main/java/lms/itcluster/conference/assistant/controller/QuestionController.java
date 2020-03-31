package lms.itcluster.conference.assistant.controller;

import lms.itcluster.conference.assistant.repo.GuestRepository;
import lms.itcluster.conference.assistant.service.QuestionService;
import lms.itcluster.conference.assistant.service.dto.QuestionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @Autowired
    GuestRepository guestRepository;

    @PostMapping("/add-question")
    public String addQuestion(QuestionDto question) {
        questionService.addQuestion(question);

        return "redirect:/topic/" + question.getTopicId();
    }

    @GetMapping("/like/{questionId}")
    public String likeQuestion(@PathVariable Long questionId,
                               @AuthenticationPrincipal UserDetails ud) {
        long guestId = guestRepository.getByEmail(ud.getUsername()).getId();
        QuestionDto dto = questionService.like(questionId, guestId);

        return "redirect:/topic/" + dto.getTopicId();
    }
}
