package lms.itcluster.conference.assistant;

import lms.itcluster.conference.assistant.domain.Conference;
import lms.itcluster.conference.assistant.domain.Guest;
import lms.itcluster.conference.assistant.domain.Question;
import lms.itcluster.conference.assistant.domain.Topic;
import lms.itcluster.conference.assistant.repo.ConferenceRepository;
import lms.itcluster.conference.assistant.repo.GuestRepository;
import lms.itcluster.conference.assistant.repo.QuestionRepository;
import lms.itcluster.conference.assistant.repo.TopicRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@SpringBootApplication
public class CoferenceAssistantApplication {


    public static void main(String[] args) {
        SpringApplication.run(CoferenceAssistantApplication.class, args);
    }
}
