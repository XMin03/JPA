package org.iesvdm.jpa.repository;

import org.iesvdm.jpa.domain.Categoria;
import org.iesvdm.jpa.domain.Pelicula;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula,Long> {
    public Page<Pelicula> findAll(Pageable pageable);
}
