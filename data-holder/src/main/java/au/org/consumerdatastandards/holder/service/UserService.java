package au.org.consumerdatastandards.holder.service;

import au.org.consumerdatastandards.holder.model.User;
import au.org.consumerdatastandards.holder.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(String userId) {
        LOGGER.debug("Retrieving user by id {}", userId);
        Optional<User> byId = userRepository.findById(userId);
        return byId.orElse(null);
    }
}
