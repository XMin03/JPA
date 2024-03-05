package org.iesvdm.jpa.service;

import org.iesvdm.jpa.domain.Categoria;
import org.iesvdm.jpa.repository.PeliculaCustomRepository;
import org.iesvdm.jpa.repository.PeliculaRepository;
import org.iesvdm.jpa.domain.Pelicula;
import org.iesvdm.jpa.exception.PeliculaNotFoundException;
import org.iesvdm.jpa.util.ListToPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PeliculaService {

    private final PeliculaRepository peliculaRepository;
    private final PeliculaCustomRepository customRepository;

    public PeliculaService(PeliculaRepository peliculaRepository, PeliculaCustomRepository customRepository) {
        this.peliculaRepository = peliculaRepository;
        this.customRepository = customRepository;
    }

    public Map<String,Object> all(String[] order,int[] pagina) {
        Pageable p= PageRequest.of(pagina[0], pagina[1]);
        List<Pelicula> list=this.customRepository.queryCustomPelicula(order);
        Page<Pelicula> page= ListToPage.convertToPage(list,p);
        Map<String,Object> res=new HashMap<>();
        res.put("peliculas",page.getContent());
        res.put("currentPage",page.getNumber());
        res.put("totalItems",page.getTotalElements());
        res.put("totalPages",page.getTotalPages());
        return res;
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
