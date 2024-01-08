package me.abeilles.base.bll.users;



import me.abeilles.base.dal.models.User;
import me.abeilles.base.pl.models.dtos.AuthDTO;
import me.abeilles.base.pl.models.forms.LoginForm;
import me.abeilles.base.pl.models.forms.UserForm;

import java.util.Optional;
import java.util.Set;

public interface UserService {
    void register(UserForm form);
    AuthDTO login(LoginForm form);
    Optional<User> getOne(String login);
    Set<String> getAllName();
}
