package me.abeilles.base.pl.models.dtos;

import me.abeilles.base.dal.models.Ingredient;
import me.abeilles.base.dal.models.Recette_Ingredient;

public record IngredientDTO(
        String nomIngredient,
        String unite)

        {
    public static IngredientDTO fromEntity(Ingredient ingredient){
        return new IngredientDTO(ingredient.getNomIngredient(),ingredient.getUnite());
    }
}
