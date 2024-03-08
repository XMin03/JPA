package org.iesvdm.jpa.service;

import org.iesvdm.jpa.repository.PeliculaRepository;
import org.iesvdm.jpa.domain.Pelicula;
import org.iesvdm.jpa.exception.PeliculaNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class PeliculaService {

    private final PeliculaRepository peliculaRepository;

    public PeliculaService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    public Page<Pelicula> all(Pageable pageable) {
        Page<Pelicula> page= peliculaRepository.findAll(pageable);
        return page;
    }

    public Pelicula save(Pelicula pelicula) {
        return this.peliculaRepository.save(pelicula);
    }

    public Pelicula one(Long id) {
        return this.peliculaRepository.findById(id)
                .orElseThrow(() -> new PeliculaNotFoundException(id));
    }

    public Pelicula replace(Long id, Pelicula pelicula) {

        return this.peliculaRepository.findById(id).map( p -> (id.equals(pelicula.getId())  ?
                        this.peliculaRepository.save(pelicula) : null))
                .orElseThrow(() -> new PeliculaNotFoundException(id));

    }

    public void delete(Long id) {
        this.peliculaRepository.findById(id).map(p -> {this.peliculaRepository.delete(p);
                    return p;})
                .orElseThrow(() -> new PeliculaNotFoundException(id));
    }

}
