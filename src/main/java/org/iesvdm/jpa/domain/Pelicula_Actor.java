package org.iesvdm.jpa.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pelicula_Actor {
    @Embeddable
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode(onlyExplicitlyIncluded = true)
    static class Pk implements Serializable {
        @EqualsAndHashCode.Include
        @ManyToOne
        @JoinColumn(name = "id_actor")
        Actor actor;
        @EqualsAndHashCode.Include
        @ManyToOne
        @JoinColumn(name = "id_pelicula")
        Pelicula pelicula;
    }


    @EmbeddedId
    @EqualsAndHashCode.Include
    Pk id;
    Date ultima_modificacion;
    public Pelicula_Actor(Actor a,Pelicula p){
        id=new Pk(a,p);
    }
}
