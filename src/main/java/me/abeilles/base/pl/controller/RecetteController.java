package me.abeilles.base.pl.controller;

import jakarta.validation.Valid;
import me.abeilles.base.bll.recettes.RecetteService;
import me.abeilles.base.dal.models.Recette;
import me.abeilles.base.pl.models.dtos.RecetteDTO;
import me.abeilles.base.pl.models.forms.RecetteForm;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recette")
public class RecetteController {
    private final RecetteService recetteService;

    public RecetteController(RecetteService recetteService) {
        this.recetteService = recetteService;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_AUTHOR')")
    @PostMapping("/create")
    public void create(@RequestBody @Valid RecetteForm form){

        recetteService.create(form);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_AUTHOR')")
    @GetMapping("/{recetteId}")
    public Recette getOne(@PathVariable Long recetteId){
        return recetteService.getOnebyId(recetteId);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_AUTHOR')")
    @GetMapping("/all")
    public ResponseEntity<Set<RecetteDTO>> getAll(){
        return ResponseEntity.ok(recetteService.getAll().stream()
                .map(RecetteDTO::fromEntity)
                .collect(Collectors.toSet()));
    }
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_AUTHOR')")
    @PutMapping("/{recetteId}")
    public void updateRecette(@PathVariable Long recetteId, @RequestBody @Valid RecetteForm form) {
        recetteService.update(recetteId,form);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_AUTHOR')")
    @DeleteMapping("/{recetteId}")
    public void deleteRecette(@PathVariable Long recetteId){

        recetteService.delete(recetteId);
    }
}
