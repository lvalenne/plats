package me.abeilles.base.dal.repositories;

import me.abeilles.base.dal.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient,String> {
}
