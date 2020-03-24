package lms.itcluster.conference.assistant.controller;

import lms.itcluster.conference.assistant.domain.Guest;
import lms.itcluster.conference.assistant.domain.Topic;
import lms.itcluster.conference.assistant.repo.GuestRepository;
import lms.itcluster.conference.assistant.service.QuestionService;
import lms.itcluster.conference.assistant.service.TopicService;
import lms.itcluster.conference.assistant.service.dto.QuestionDto;
import lms.itcluster.conference.assistant.service.dto.TopicDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class TopicController {

    @Autowired
    QuestionService questionService;

    @Autowired
    TopicService topicService;

    @Autowired
    GuestRepository guestRepository;

    @GetMapping("/topic/{topicId}/{email}")
    public String topic(@PathVariable Long topicId,
                        @PathVariable String email,
                        Model model) {
        TopicDto t = topicService.findById(topicId);
        List<QuestionDto> questions = questionService.getQuestionByTopicId(topicId, email);
        Guest currentGuest = guestRepository.getByEmail(email);

        model.addAttribute("topic", t);
        model.addAttribute("questions", questions);
        model.addAttribute("curentGuest", currentGuest);

        return "topic";
    }
}
