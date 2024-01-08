package me.abeilles.base.dal.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Data
public class Recette {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long recetteId;
    private String instructions;

    @ManyToMany
    @JoinTable(name = "Recette_recette_Ingredients",
            joinColumns = @JoinColumn(name = "recette_recetteId"),
            inverseJoinColumns = @JoinColumn(name = "recette_Ingredients_quantite"))
    private Set<Recette_Ingredient> recette_Ingredients = new LinkedHashSet<>();

    @OneToMany(mappedBy = "recette", orphanRemoval = true)
    private Set<Auteur> auteurs = new LinkedHashSet<>();

    @OneToMany(mappedBy = "recette", orphanRemoval = true)
    private Set<Plat> plats = new LinkedHashSet<>();

}
