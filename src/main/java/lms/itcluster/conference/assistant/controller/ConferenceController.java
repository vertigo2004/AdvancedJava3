package lms.itcluster.conference.assistant.controller;

import lms.itcluster.conference.assistant.domain.Guest;
import lms.itcluster.conference.assistant.repo.GuestRepository;
import lms.itcluster.conference.assistant.service.ConferenceService;
import lms.itcluster.conference.assistant.service.TopicService;
import lms.itcluster.conference.assistant.service.dto.ConferenceDto;
import lms.itcluster.conference.assistant.service.dto.TopicDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
public class ConferenceController {

    @Autowired
    ConferenceService conferenceService;

    @Autowired
    TopicService topicService;

    @Autowired
    GuestRepository guestRepository;

    @GetMapping("/")
    public String homePage(Model model) {

        model.addAttribute("confs", conferenceService.findAll());
        return "homePage";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin";
    }

    @GetMapping("/moderator")
    public String moderatorPage() {
        return "moderator";
    }

    @GetMapping("/conference/{confId}")
    public String showConference(@PathVariable Long confId,
                                 Model model) {

        UserDetails ud = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        log.info("User: {}", ud.getUsername());
        ConferenceDto conf = conferenceService.findById(confId);
        List<TopicDto> topics = topicService.findByConfId(confId);

        model.addAttribute("conf", conf);
        model.addAttribute("topics", topics);
        model.addAttribute("name", ud.getUsername());

        return "conference";
    }




    @GetMapping("/guest")
    public String addGuest(@RequestParam String email,
                           Model model) {
        Guest g = new Guest();
        g.setEmail(email);
        Long id = guestRepository.save(g).getId();

        model.addAttribute("guest", guestRepository.findById(id).get());
        return "guest";
    }

    @PostMapping("/guest")
    public String postGuest(Guest guest, Model model) {
        Long id = guestRepository.save(guest).getId();

        model.addAttribute("guest", guestRepository.findById(id).get());
        return "guest";
    }

    @GetMapping("/guestForm")
    public String guestForm() {
        return "guestForm";
    }
}
