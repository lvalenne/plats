package me.abeilles.base.pl.models.forms;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginForm {
    private String login;
    private String password;
}
