package me.abeilles.base.pl.models.dtos;

import me.abeilles.base.dal.models.*;

import java.util.Set;
import java.util.stream.Collectors;

public record RecetteDTO(
        Long recetteId,

        String instructions,
        Set<String> auteur,
        Set<Set<Ingredient>> recette_Ingredients,
        Set<String> plats) {
    public static RecetteDTO fromEntity(Recette recette){
        return new RecetteDTO(recette.getRecetteId(), recette.getInstructions(),
                recette.getAuteurs().stream()
                        .map(Auteur::getNom)
                        .collect(Collectors.toSet()),
                recette.getRecette_Ingredients().stream()
                        .map(Recette_Ingredient::getIngredients)
                        .collect(Collectors.toSet()),
                recette.getPlats().stream()
                        .map(Plat::getNomPlat)
                        .collect(Collectors.toSet()));

    }
}
