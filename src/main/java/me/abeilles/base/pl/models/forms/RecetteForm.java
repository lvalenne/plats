package me.abeilles.base.pl.models.forms;

import me.abeilles.base.dal.models.Auteur;
import me.abeilles.base.dal.models.Ingredient;
import me.abeilles.base.dal.models.Recette_Ingredient;

import java.util.Set;

public record RecetteForm(
        String instructions,
        Set<String> auteur,
        Set<Set<Ingredient>> recette_Ingredients,
        Set<String> plats

) {
}
