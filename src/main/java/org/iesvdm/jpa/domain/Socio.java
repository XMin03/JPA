package org.iesvdm.jpa.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "socio",
        schema = "tutorial"
)
public class Socio {
    @Id
    String DNI;
    String nombre;
    String apellido;
    @OneToOne
    Tarjeta tarjeta;
}
