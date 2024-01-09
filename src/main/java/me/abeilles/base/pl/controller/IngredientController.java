package me.abeilles.base.pl.controller;

import jakarta.validation.Valid;
import me.abeilles.base.bll.ingredients.IngredientService;
import me.abeilles.base.dal.models.Ingredient;
import me.abeilles.base.pl.models.dtos.IngredientDTO;
import me.abeilles.base.pl.models.forms.IngredientForm;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_AUTHOR')")
    @PostMapping("/create")
    public void create(@RequestBody @Valid IngredientForm form){

        ingredientService.create(form);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_AUTHOR')")
    @GetMapping("/{ingredientId}")
    public Ingredient getOne(@PathVariable String ingredientId){
        return ingredientService.getOnebyId(ingredientId);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_AUTHOR')")
    @GetMapping("/all")
    public ResponseEntity<Set<IngredientDTO>> getAll(){
        return ResponseEntity.ok(ingredientService.getAll().stream()
                .map(IngredientDTO::fromEntity)
                .collect(Collectors.toSet()));
    }
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_AUTHOR')")
    @PutMapping("/{ingredientId}")
    public void updateIngredient(@PathVariable String ingredientId, @RequestBody @Valid IngredientForm form) {
        ingredientService.update(ingredientId,form);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_AUTHOR')")
    @DeleteMapping("/{ingredientId}")
    public void deleteIngredient(@PathVariable String ingredientId){

        ingredientService.delete(ingredientId);
    }
}
