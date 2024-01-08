package me.abeilles.base.dal.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Ingredient {
    @Id
    private String nomIngredient;
    private String unite;

    @ManyToOne
    @JoinColumn(name = "recette_ingredient_quantite")
    private Recette_Ingredient recette_Ingredient;

}
