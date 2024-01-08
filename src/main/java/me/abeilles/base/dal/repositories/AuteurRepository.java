package me.abeilles.base.dal.repositories;

import me.abeilles.base.dal.models.Auteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuteurRepository extends JpaRepository<Auteur,String> {
}
