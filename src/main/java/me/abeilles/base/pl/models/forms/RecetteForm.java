package me.abeilles.base.pl.models.forms;

import me.abeilles.base.dal.models.Auteur;
import me.abeilles.base.dal.models.Recette_Ingredient;

import java.util.Set;

public record RecetteForm(
        String nomPlat,
        String origine,

        String instructions,
        String nomAuteur,
        String prenomAuteur,
        Set<Recette_Ingredient> recette_Ingredients

) {
}
