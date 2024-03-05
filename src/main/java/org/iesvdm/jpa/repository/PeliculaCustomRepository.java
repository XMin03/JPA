package org.iesvdm.jpa.repository;

import org.iesvdm.jpa.domain.Categoria;
import org.iesvdm.jpa.domain.Pelicula;

import java.util.List;
import java.util.Optional;

public interface PeliculaCustomRepository {
    public List<Pelicula> queryCustomPelicula(String[] ordenar);
    }
