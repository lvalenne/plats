package me.abeilles.base.dal.repositories;

import me.abeilles.base.dal.models.Plat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatRepository extends JpaRepository<Plat,String> {
}
