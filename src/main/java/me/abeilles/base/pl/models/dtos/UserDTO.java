package me.abeilles.base.pl.models.dtos;

import lombok.Builder;
import lombok.Data;
import me.abeilles.base.dal.models.User;

@Data
@Builder
public class UserDTO {
    //private Set<Badge> badges;

    public static UserDTO fromEntityToDTO(User entity){
        return UserDTO.builder()
                .build();
    }
}
