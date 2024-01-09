package me.abeilles.base.bll.ingredients;

import jakarta.validation.Valid;
import me.abeilles.base.dal.models.Ingredient;
import me.abeilles.base.pl.models.forms.IngredientForm;

import java.util.List;

public interface IngredientService {
    void create(@Valid IngredientForm form);
    void delete(String nomIngredient);
    Ingredient getOnebyId(String nomIngredient);
    void update(String nomIngredient, IngredientForm form);
    List<Ingredient> getAll();
}
