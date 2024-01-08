package me.abeilles.base.pl.models.forms;

import lombok.Data;
import me.abeilles.base.dal.models.UserRole;

import java.util.Set;

@Data
public class UserForm {
    private String nom;

    private Set<UserRole> roles;

    private String login;
    private String password;


}
