package me.abeilles.base.dal.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Data
public class Recette_Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String quantite;

    @OneToMany(mappedBy = "recette_Ingredient", orphanRemoval = true)
    private Set<Ingredient> ingredients = new LinkedHashSet<>();

}
