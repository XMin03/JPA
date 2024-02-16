package org.iesvdm.jpa.service;

import org.iesvdm.jpa.domain.Categoria;
import org.iesvdm.jpa.exception.CategoriaNotFoundException;
import org.iesvdm.jpa.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> all() {
        return this.categoriaRepository.findAll();
    }

    public Categoria save(Categoria categoria) {
        return this.categoriaRepository.save(categoria);
    }

    public Categoria one(Long id) {
        return this.categoriaRepository.findById(id)
                .orElseThrow(() -> new CategoriaNotFoundException(id));
    }

    public Categoria replace(Long id, Categoria categoria) {

        return this.categoriaRepository.findById(id).map( p -> (id.equals(categoria.getId())  ?
                        this.categoriaRepository.save(categoria) : null))
                .orElseThrow(() -> new CategoriaNotFoundException(id));

    }

    public void delete(Long id) {
        this.categoriaRepository.findById(id).map(c -> {
            c.getPeliculas().forEach(pelicula -> pelicula.getCategorias().remove(c));
            this.categoriaRepository.delete(c);
                    return c;})
                .orElseThrow(() -> new CategoriaNotFoundException(id));
    }

}
