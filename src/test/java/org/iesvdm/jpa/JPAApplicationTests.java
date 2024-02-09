package org.iesvdm.jpa;

import org.iesvdm.jpa.domain.Categoria;
import org.iesvdm.jpa.domain.Pelicula;
import org.iesvdm.jpa.repository.CategoriaRepository;
import org.iesvdm.jpa.repository.PeliculaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;

@SpringBootTest
class JPAApplicationTests {
    @Autowired
    PeliculaRepository peliculaRepository;
    @Autowired
    CategoriaRepository categoriaRepository;

    @Test
    void contextLoads() {
    }
    @Test
    void GuardarManyToMany(){
        Pelicula pelicula=new Pelicula(0,"Pelicula",new HashSet<>());
        peliculaRepository.save(pelicula);
        Categoria categoria1=new Categoria(0, "Categoria1",new HashSet<>());
        categoriaRepository.save(categoria1);
        Categoria categoria2=new Categoria(0, "Categoria2",new HashSet<>());
        categoriaRepository.save(categoria2);
        pelicula.getCategorias().add(categoria1);
        categoria1.getPeliculas().add(pelicula);
        pelicula.getCategorias().add(categoria2);
        categoria2.getPeliculas().add(pelicula);
        peliculaRepository.save(pelicula);
        categoriaRepository.save(categoria1);
        categoriaRepository.save(categoria2);
    }
}
