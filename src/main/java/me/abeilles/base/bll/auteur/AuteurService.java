package me.abeilles.base.bll.auteur;

import me.abeilles.base.dal.models.Auteur;
import me.abeilles.base.pl.models.forms.AuteurForm;

import java.util.List;

public interface AuteurService {
    void create(AuteurForm form);
    void delete(String auteurId);
    Auteur getOnebyId(String auteurId);
    void update(String AuteurId, AuteurForm form);
    List<Auteur> getAll();
}
