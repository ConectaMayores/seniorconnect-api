package com.conectamayores.seniorconnectapi.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Voluntario {

    @Getter
    @Setter
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAFamiliar;

    @Getter  @Setter
    @Column(length = 50, nullable = false)
    private String nombreCompleto;

    @Getter  @Setter
    @Column(name = "edad", nullable = false, length = 3)
    private String edad;

    @Getter  @Setter
    @Column(length = 50, nullable = false)
    private String tipoUsuario;

}
