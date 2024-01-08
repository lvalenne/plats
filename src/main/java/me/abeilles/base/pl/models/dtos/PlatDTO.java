package me.abeilles.base.pl.models.dtos;

import me.abeilles.base.dal.models.Plat;

public record PlatDTO(
        String nomPlat,
        String origine
) {
    public static PlatDTO fromEntity(Plat plat){
        return new PlatDTO(plat.getNomPlat(),plat.getOrigine());
    }
}
