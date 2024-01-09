package me.abeilles.base.bll.recettes;
import me.abeilles.base.bll.models.NotFoundException;
import me.abeilles.base.dal.models.Recette;
import me.abeilles.base.dal.repositories.RecetteRepository;
import me.abeilles.base.dal.repositories.UserRepository;
import me.abeilles.base.pl.models.forms.AuteurForm;
import me.abeilles.base.pl.models.forms.RecetteForm;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RecetteServiceImpl implements RecetteService{
    private final RecetteRepository recetteRepository;
    private final UserRepository userRepository;

    public RecetteServiceImpl(RecetteRepository recetteRepository, UserRepository userRepository) {
        this.recetteRepository = recetteRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void create(RecetteForm form) {
        // Vérifie si la forme n'est pas nulle
        if (form == null) throw new IllegalArgumentException("le formulaire ne peut etre vide");

        // Crée une nouvelle recette avec le nom du formulaire.
        Recette recette = new Recette();



        // Enregistre le nouvel avion dans le repository.
        recetteRepository.save(recette);

    }

    @Override
    public void delete(Long recetteId) {
        recetteRepository.findById(recetteId).ifPresent(recetteRepository::delete);
    }

    @Override
    public Recette getOnebyId(Long recetteId) {
        return recetteRepository.findById(recetteId).orElseThrow(() -> new NotFoundException("recette pas trouvée"));
    }

    @Override
    public void update(Long recetteId, RecetteForm form) {

    }

    @Override
    public List<Recette> getAll() {
        return recetteRepository.findAll();
    }
}
