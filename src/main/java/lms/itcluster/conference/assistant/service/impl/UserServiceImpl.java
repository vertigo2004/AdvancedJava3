package lms.itcluster.conference.assistant.service.impl;

import lms.itcluster.conference.assistant.domain.Guest;
import lms.itcluster.conference.assistant.repo.GuestRepository;
import lms.itcluster.conference.assistant.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Guest guest = guestRepository.getByEmail(email);

        if (guest == null) {
            guest = new Guest();
            guest.setEmail(email);
            guest = guestRepository.save(guest);
        }
        log.info(guest.toString());
        User.UserBuilder builder = User.withUsername(email);
        builder.password(passwordEncoder.encode(""));
        builder.roles("GUEST");

        return builder.build();
    }
}
