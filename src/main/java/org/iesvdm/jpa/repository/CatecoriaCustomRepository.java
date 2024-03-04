package org.iesvdm.jpa.repository;

import org.iesvdm.jpa.domain.Categoria;

import java.util.List;
import java.util.Optional;

public interface CatecoriaCustomRepository {
    public List<Categoria> queryCustomCategoria(Optional<String> buscar, Optional<String> ordenar);
    }
