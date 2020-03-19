package lms.itcluster.conference.assistant.config;

import lms.itcluster.conference.assistant.domain.Organization;
import lms.itcluster.conference.assistant.domain.Photo;
import lms.itcluster.conference.assistant.repo.OrganizationRepository;
import lms.itcluster.conference.assistant.repo.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class PhotoInitials {

    @Autowired
    PhotoRepository photoRepository;

    @Autowired
    OrganizationRepository organizationRepository;

    @Bean(name = "PhotoTest")
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            Organization o1 = new Organization();
            o1.setName("Organization 1");
            o1 = organizationRepository.save(o1);

            Photo p1 = new Photo();
            p1.setName("Logo 1");
            p1.setOrganization(o1);

            Photo p2 = new Photo();
            p2.setName("Photo 1");
            p2.setOrganization(o1);

            Photo p3 = new Photo();
            p3.setName("Photo 2");
            p3.setOrganization(o1);

            o1.setLogo(p1);
            o1.setPhotos(Arrays.asList(p2, p3));
            long id = organizationRepository.save(o1).getId();
            System.out.println("Saved as " + id);

            o1 = organizationRepository.findById(id).orElseThrow(IllegalStateException::new);
            System.out.println(String.format("Org id %d - %s. Logo id: %d Name: %s - to org: %d",
                    o1.getId(), o1.getName(), o1.getLogo().getId(), o1.getLogo().getName(), o1.getLogo().getOrganization().getId()));

            for (Photo p : o1.getPhotos()) {
                System.out.println(p.getId() + " " + p.getName());
                System.out.println(p.getOrganization().getId());
            }
        };
    }
}
