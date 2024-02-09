package org.iesvdm.jpa.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "tarjeta",
        schema = "tutorial"
)
public class Tarjeta {
    @Id
    long numero;
    Date caducidad;
    @OneToOne
    @JoinColumn(name = "id_socio")
    Socio socio;
}
