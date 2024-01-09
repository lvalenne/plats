package me.abeilles.base.bll.ingredients;

import jakarta.validation.Valid;
import me.abeilles.base.bll.models.NotFoundException;
import me.abeilles.base.dal.models.Ingredient;
import me.abeilles.base.dal.repositories.IngredientRepository;
import me.abeilles.base.pl.models.forms.IngredientForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService{
    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void create(@Valid IngredientForm form) {
        // Vérifie si la forme n'est pas nulle
        if (form == null) throw new IllegalArgumentException("le formulaire ne peut etre vide");

        // Crée un nouveau pilote avec le nom du formulaire.
        Ingredient ingredient = new Ingredient();
        ingredient.setNomIngredient(form.nomIngredient());
        ingredient.setUnite(form.unite());


        // Enregistre le nouvel avion dans le repository.
        ingredientRepository.save(ingredient);
    }

    @Override
    public void delete(String nomIngredient) {
        ingredientRepository.findById(nomIngredient).ifPresent(ingredientRepository::delete);
    }

    @Override
    public Ingredient getOnebyId(String nomIngredient) {
        return ingredientRepository.findById(nomIngredient).orElseThrow(() -> new NotFoundException("ingrédient pas trouvé"));
    }

    @Override
    public void update(String nomIngredient, IngredientForm form) {
        if (form == null){
            throw new IllegalArgumentException("Le formulaire ne peut être null");
        }
        Ingredient ingredient = getOnebyId(nomIngredient);
        ingredient.setNomIngredient(form.nomIngredient());
        ingredient.setUnite(form.unite());
        ingredientRepository.save(ingredient);
    }

    @Override
    public List<Ingredient> getAll() {
        return ingredientRepository.findAll();
    }
}
