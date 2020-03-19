package lms.itcluster.conference.assistant.config;

import lms.itcluster.conference.assistant.domain.Conference;
import lms.itcluster.conference.assistant.domain.Guest;
import lms.itcluster.conference.assistant.domain.Question;
import lms.itcluster.conference.assistant.domain.Topic;
import lms.itcluster.conference.assistant.repo.ConferenceRepository;
import lms.itcluster.conference.assistant.repo.GuestRepository;
import lms.itcluster.conference.assistant.repo.QuestionRepository;
import lms.itcluster.conference.assistant.repo.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

@Configuration
public class DatabaseInitials {

    @Autowired
    private ConferenceRepository conferenceRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            Conference c1 = new Conference();
            c1.setName("My First Super Conference");
            c1.setDate(new Date());
            c1.setDescription("mhgvmgmg kjhvkhjgvm hgvmgvmg vhmgv");
            c1 = conferenceRepository.save(c1);

            Topic t1 = new Topic();
            t1.setTitle("My First Topic");
            t1.setSpeaker("Me Myself and I");
            t1.setConf(c1);
            t1 = topicRepository.save(t1);

            Guest g1 = new Guest();
            g1.setEmail("guest 1");
            g1 = guestRepository.save(g1);

            Question q1 = new Question();
            q1.setBody("Чи любите ви собак?");
            q1.setAuthor(g1);
            q1.setTopic(t1);
            q1.setLikes(new HashSet<>(Arrays.asList(g1)));
            q1 = questionRepository.save(q1);

            Guest g2 = new Guest();
            g2.setEmail("guest 2");
            g2 = guestRepository.save(g2);

            Question q2 = new Question();
            q2.setBody("Скількі котів потрібно для повного щастя?");
            q2.setAuthor(g1);
            q2.setTopic(t1);
            q2.setLikes(new HashSet<>(Arrays.asList(g2)));
            q2 = questionRepository.save(q2);


            Topic t2 = new Topic();
            t2.setTitle("My Second Topic");
            t2.setSpeaker("Me Myself and I");
            t2.setConf(c1);
            t2 = topicRepository.save(t2);

            q1 = new Question();
            q1.setBody("Що круче Spring чи Hibernate?");
            q1.setAuthor(g2);
            q1.setTopic(t2);
            q1.setLikes(new HashSet<>(Arrays.asList(g2)));
            q1 = questionRepository.save(q1);

            q2 = new Question();
            q2.setBody("Як вивчити Джаву за 2 місяці?");
            q2.setAuthor(g2);
            q2.setTopic(t2);
            q2.setLikes(new HashSet<>(Arrays.asList(g1)));
            q2 = questionRepository.save(q2);
        };
    }
}
