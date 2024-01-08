package me.abeilles.base.dal.models;

import com.sun.jdi.event.StepEvent;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Auteur {
    @Id
    private String auteurId;
    private String nom;
    private String prenom;
    private String login;
    private String motDePasse;

    @ManyToOne
    @JoinColumn(name = "recette_recette_id")
    private Recette recette;

}
