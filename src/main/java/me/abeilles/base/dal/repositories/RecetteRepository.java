package me.abeilles.base.dal.repositories;

import me.abeilles.base.dal.models.Recette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecetteRepository extends JpaRepository<Recette, Long> {
}
