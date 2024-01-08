package me.abeilles.base.pl.models.dtos;


import lombok.Builder;
import lombok.Data;
import me.abeilles.base.dal.models.UserRole;

import java.util.Set;

@Data
@Builder
public class AuthDTO {
    private String login;
    private String token;
    private Set<UserRole> roles;
}
