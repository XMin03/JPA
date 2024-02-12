package org.iesvdm.jpa;

import lombok.AllArgsConstructor;
import org.iesvdm.jpa.domain.*;
import org.iesvdm.jpa.repository.*;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;

@SpringBootTest
class JPAApplicationTests {
    @Autowired
    PeliculaRepository peliculaRepository;
    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    ActorRepository actorRepository;
    @Autowired
    IdiomaRepository idiomaRepository;
    @Autowired
    PeliculaActorRepository peliculaActorRepository;
    @Test
    void contextLoads() {
    }
    @Test
    void GuardarManyToMany(){
        Pelicula pelicula=new Pelicula(0,"PeliculaCategoria",new HashSet<>(),null,null);
        peliculaRepository.save(pelicula);

        Categoria categoria1=new Categoria(0, "Categoria1",new HashSet<>());
        Categoria categoria2=new Categoria(0, "Categoria2",new HashSet<>());
        categoriaRepository.save(categoria1);
        categoriaRepository.save(categoria2);
        pelicula.getCategorias().add(categoria1);
        categoria1.getPeliculas().add(pelicula);
        pelicula.getCategorias().add(categoria2);
        categoria2.getPeliculas().add(pelicula);
        peliculaRepository.save(pelicula);
        categoriaRepository.save(categoria1);
        categoriaRepository.save(categoria2);
    }
    @Test
    void Guardar2OnetoMany(){
        Pelicula pelicula=new Pelicula(0,"PeliculaActor",null,null,new ArrayList<>());
        peliculaRepository.save(pelicula);

        Actor actor1=new Actor(0, "Nombre1","Apellido1",new ArrayList<>());
        Actor actor2=new Actor(0, "Nombre2","Apellido2",new ArrayList<>());
        actorRepository.save(actor1);
        actorRepository.save(actor2);
        Pelicula_Actor peliculaActor1=new Pelicula_Actor(actor1,pelicula);
        Pelicula_Actor peliculaActor2=new Pelicula_Actor(actor2,pelicula);
        peliculaActorRepository.save(peliculaActor1);
        peliculaActorRepository.save(peliculaActor2);

        pelicula.getActors().add(peliculaActor1);
        actor1.getPeliculas().add(peliculaActor1);
        pelicula.getActors().add(peliculaActor2);
        actor2.getPeliculas().add(peliculaActor2);
        peliculaRepository.save(pelicula);
        actorRepository.save(actor1);
        actorRepository.save(actor2);
    }

}
