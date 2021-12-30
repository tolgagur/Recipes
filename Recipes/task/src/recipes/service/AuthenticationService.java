package recipes.service;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import recipes.repository.UserRepository;
import recipes.user.User;

import java.util.Optional;

@Service
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(User user) {
        Optional<User> optionalUser = repository.findUserByEmailIgnoreCase(user.getEmail());
        if (optionalUser.isPresent()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"hatalı kullanıcı adi");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
    }

    public User findUserByEmail(String email) {
        Optional<User> optionalUser = repository.findUserByEmailIgnoreCase(email);
        return optionalUser.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"böyle bir kuulanıcı yok"));
    }
}