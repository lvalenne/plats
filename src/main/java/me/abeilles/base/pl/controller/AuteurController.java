package me.abeilles.base.pl.controller;

import jakarta.validation.Valid;
import me.abeilles.base.bll.auteur.AuteurService;
import me.abeilles.base.bll.users.UserService;
import me.abeilles.base.dal.models.Auteur;
import me.abeilles.base.pl.models.dtos.AuteurDTO;
import me.abeilles.base.pl.models.forms.AuteurForm;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auteur")
public class AuteurController {
    private final AuteurService auteurService;



    public AuteurController(AuteurService auteurService, UserService userService) {
        this.auteurService = auteurService;

    }
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_AUTHOR')")
    @PostMapping("/create")
    public void register(@RequestBody @Valid AuteurForm form){
        auteurService.create(form);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_AUTHOR')")
    @GetMapping("/{auteurId}")
    public Auteur getOne(@PathVariable String auteurId){
        return auteurService.getOnebyId(auteurId);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_AUTHOR')")
    @GetMapping("/all")
    public ResponseEntity<Set<AuteurDTO>> getAll(){
        return ResponseEntity.ok(auteurService.getAll().stream()
                .map(AuteurDTO::fromEntity)
                .collect(Collectors.toSet()));
    }
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_AUTHOR')")
    @PutMapping("/{auteurId}")
    public void updateAuteur(@PathVariable String auteurId, @RequestBody @Valid AuteurForm form) {
        auteurService.update(auteurId,form);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_AUTHOR')")
    @DeleteMapping("/{auteurId}")
    public void deleteAuteur(@PathVariable String auteurId){
        auteurService.delete(auteurId);
    }
}
