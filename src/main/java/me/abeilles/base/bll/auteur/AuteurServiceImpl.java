package me.abeilles.base.bll.auteur;

import me.abeilles.base.bll.models.NotFoundException;
import me.abeilles.base.dal.models.Auteur;
import me.abeilles.base.dal.repositories.AuteurRepository;
import me.abeilles.base.pl.models.forms.AuteurForm;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class AuteurServiceImpl implements AuteurService{
    private final AuteurRepository auteurRepository;

    public AuteurServiceImpl(AuteurRepository auteurRepository) {
        this.auteurRepository = auteurRepository;
    }

    @Override
    public void create(AuteurForm form) {
        // Vérifie si la forme n'est pas nulle
        if (form == null) throw new IllegalArgumentException("le formulaire ne peut etre vide");

        // Crée un nouveau pilote avec le nom du formulaire.
       Auteur auteur = new Auteur();
       auteur.setAuteurId(form.auteurId());
       auteur.setNom(form.nom());
       auteur.setPrenom(form.prenom());


        // Enregistre le nouvel avion dans le repository.
        auteurRepository.save(auteur);
    }

    @Override
    public void delete(String auteurId) {
        auteurRepository.findById(auteurId).ifPresent(auteurRepository::delete);
    }

    @Override
    public Auteur getOnebyId(String auteurId) {
        return auteurRepository.findById(auteurId).orElseThrow(() -> new NotFoundException("Auteur pas trouvé"));
    }

    @Override
    public void update(String auteurId, AuteurForm form) {
        if (form == null){
            throw new IllegalArgumentException("Le formulaire ne peut être null");
        }

        Auteur auteur = getOnebyId(auteurId);
        auteur.setAuteurId(form.auteurId());
        auteur.setNom(form.nom());
        auteur.setPrenom(form.prenom());

        auteurRepository.save(auteur);
    }

    @Override
    public List<Auteur> getAll() {
        return auteurRepository.findAll();
    }
}
