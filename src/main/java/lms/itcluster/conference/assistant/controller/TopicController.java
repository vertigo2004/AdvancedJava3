package lms.itcluster.conference.assistant.controller;

import lms.itcluster.conference.assistant.domain.Guest;
import lms.itcluster.conference.assistant.domain.Topic;
import lms.itcluster.conference.assistant.repo.GuestRepository;
import lms.itcluster.conference.assistant.service.QuestionService;
import lms.itcluster.conference.assistant.service.TopicService;
import lms.itcluster.conference.assistant.service.dto.QuestionDto;
import lms.itcluster.conference.assistant.service.dto.TopicDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Slf4j
@Controller
public class TopicController {

    @Autowired
    QuestionService questionService;

    @Autowired
    TopicService topicService;

    @Autowired
    GuestRepository guestRepository;

    @GetMapping("/topic/{topicId}")
    public String topic(@PathVariable Long topicId,
                        @AuthenticationPrincipal UserDetails ud,
                        Model model) {
        TopicDto t = topicService.findById(topicId);
        long guestId = guestRepository.getByEmail(ud.getUsername()).getId();
        List<QuestionDto> questions = questionService.getQuestionByTopicId(topicId, ud.getUsername());

        model.addAttribute("topic", t);
        model.addAttribute("questions", questions);
        model.addAttribute("guestId", guestId);

        return "topic";
    }
}
