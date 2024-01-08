package me.abeilles.base.pl.models.dtos;

import me.abeilles.base.dal.models.Auteur;

public record AuteurDTO(String auteurId,
                        String nom,
                        String prenom) {
    public static AuteurDTO fromEntity(Auteur auteur){
        return new AuteurDTO(auteur.getAuteurId(),auteur.getNom(), auteur.getPrenom());
    }
}
