package me.abeilles.base.dal.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Plat {
    @Id
    private String nomPlat;
    private String origine;

    @ManyToOne
    @JoinColumn(name = "recette_recette_id")
    private Recette recette;

}
