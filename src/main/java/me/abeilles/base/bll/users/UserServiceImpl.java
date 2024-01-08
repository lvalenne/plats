package me.abeilles.base.bll.users;
import me.abeilles.base.dal.models.User;
import me.abeilles.base.dal.repositories.UserRepository;
import me.abeilles.base.pl.config.security.JWTProvider;
import me.abeilles.base.pl.models.dtos.AuthDTO;
import me.abeilles.base.pl.models.forms.LoginForm;
import me.abeilles.base.pl.models.forms.UserForm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {
    
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JWTProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, AuthenticationManager authenticationManager, JWTProvider jwtProvider, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(UserForm form) {
        if(form == null)
            throw new IllegalArgumentException("form peut pas être null");
        
        User entity = new User();
        entity.setNom(form.getNom());
        entity.setLogin(form.getLogin());
        entity.setPassword(passwordEncoder.encode(form.getPassword()));
        entity.setRoles(form.getRoles());
        //entity.setBadges(form.getBadges());

        userRepository.save(entity);
    }

    
    @Override
    public AuthDTO login(LoginForm form) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(form.getLogin(),form.getPassword()));
        
        User user = userRepository.findByLogin(form.getLogin()).get();
        
        String token = jwtProvider.generateToken(user.getUsername(), List.copyOf(user.getRoles()));
        
        return AuthDTO.builder()
                .token(token)
                .login(user.getLogin())
                .roles(user.getRoles())
                .build();
    }

    @Override
    public Optional<User> getOne(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public Set<String> getAllName() {
        return userRepository.findAll().stream().map(e -> e.getNom()).collect(Collectors.toSet());
    }


}
