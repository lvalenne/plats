package me.abeilles.base.dal;



import me.abeilles.base.dal.models.User;
import me.abeilles.base.dal.models.UserRole;
import me.abeilles.base.dal.repositories.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class DataInit implements InitializingBean {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public DataInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        User user = new User();
        user.setNom("user");
        user.setLogin("user");
        user.setPassword(passwordEncoder.encode("Test1234="));
        HashSet<UserRole> roles = new HashSet<>();
        roles.add(UserRole.USER);
        user.setRoles(roles);
        //HashSet<Badge> badges = new HashSet<>();
        //badges.add(Badge.ANGULAR);
        //user.setBadges(badges);
        user.setEnabled(true);
        userRepository.save(user);

        User user2 = new User();
        user2.setNom("admin");
        user2.setLogin("admin");
        user2.setPassword(passwordEncoder.encode("Test1234="));
        HashSet<UserRole> roles2 = new HashSet<>();
        roles2.add(UserRole.ADMIN);
        user2.setRoles(roles2);
        //HashSet<Badge> badges2 = new HashSet<>();
        //badges2.add(Badge.GIT);
        //user2.setBadges(badges2);
        user2.setEnabled(true);
        userRepository.save(user2);

        User user3 = new User();
        user3.setNom("auteur");
        user3.setLogin("auteur");
        user3.setPassword(passwordEncoder.encode("Test1234="));
        HashSet<UserRole> roles3 = new HashSet<>();
        roles3.add(UserRole.AUTHOR);
        user3.setRoles(roles3);
        user3.setEnabled(true);
        userRepository.save(user3);

        User user4 = new User();
        user4.setNom("auteur2");
        user4.setLogin("auteur2");
        user4.setPassword(passwordEncoder.encode("Test1234="));
        HashSet<UserRole> role4 = new HashSet<>();
        role4.add(UserRole.AUTHOR);
        user4.setEnabled(true);
        userRepository.save(user4);
    }


}
