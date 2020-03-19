package lms.itcluster.conference.assistant.controller;

import lms.itcluster.conference.assistant.domain.Conference;
import lms.itcluster.conference.assistant.domain.Guest;
import lms.itcluster.conference.assistant.repo.ConferenceRepository;
import lms.itcluster.conference.assistant.repo.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConferenceController {

    @Autowired
    ConferenceRepository conferenceRepository;

    @Autowired
    GuestRepository guestRepository;

    @GetMapping("/conference")
    public String showConference(Model model) {
        Conference conf = conferenceRepository.findAll().get(0);
        model.addAttribute("conf", conf);

        return "conference";
    }

    @GetMapping("/conferenceById")
    public String showOneConference(@RequestParam(name = "confId") Long confId, Model model) {
        Conference conf = conferenceRepository.findById(confId).get();
        model.addAttribute("conf", conf);

        return "conference";
    }

    @GetMapping("/conference/{confId}/name/{name}")
    public String showOneMoreConference(@PathVariable Long confId,
                                        @PathVariable String name,
                                        Model model) {
        Conference conf = conferenceRepository.findById(confId).get();
        model.addAttribute("conf", conf);
        model.addAttribute("name", name);

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
