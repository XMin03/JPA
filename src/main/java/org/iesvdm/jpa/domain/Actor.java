package org.iesvdm.jpa.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    long id_actor;
    @Column(length = 45)
    String nombre;
    @Column(length = 45)
    String apellidos;
    @OneToMany(mappedBy = "id.actor")
    List<Pelicula_Actor> peliculas;
}
