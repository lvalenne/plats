package me.abeilles.base.bll.recettes;

import me.abeilles.base.dal.models.Auteur;
import me.abeilles.base.dal.models.Recette;
import me.abeilles.base.pl.models.forms.AuteurForm;
import me.abeilles.base.pl.models.forms.RecetteForm;

import java.util.List;

public interface RecetteService {
    void create(RecetteForm form);
    void delete(Long recetteId);
    Recette getOnebyId(Long recetteId);
    void update(Long recetteId, RecetteForm form);
    List<Recette> getAll();
}
