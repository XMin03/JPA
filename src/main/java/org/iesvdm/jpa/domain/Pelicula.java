package org.iesvdm.jpa.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.iesvdm.jpa.serializer.PeliculaSerializer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@JsonSerialize(using = PeliculaSerializer.class)
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;
    private String titulo;
    @ManyToMany
    @JoinTable(
            name = "pelicula_categoria",
            joinColumns = @JoinColumn(name = "id_pelicula", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_categoria", referencedColumnName = "id"))
    Set<Categoria> categorias = new HashSet<>();
    @ManyToOne
    Idioma idioma;
    @OneToMany(mappedBy = "id.pelicula")
    List<Pelicula_Actor> actors;
}
