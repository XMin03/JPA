package org.iesvdm.jpa.repository;

import org.iesvdm.jpa.domain.Pelicula_Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaActorRepository extends JpaRepository<Pelicula_Actor,Long> {
}
