package com.conectamayores.seniorconnectapi.model;


import jakarta.persistence.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class AdultoMayor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAdultoMayor;

    @Column(length = 50, nullable = false)
    private String nombreCompleto;

    @Column(name = "edad", nullable = false, length = 3)
    private int edad;

    @Column(name = "gustos", nullable = false, length = 100)
    private String gustos;

    @Column(length = 50, nullable = false)
    private String tipoUsuario;

    @Column(nullable = false)
    private boolean apoyoEmocional;

    @Column(nullable = false)
    private boolean asistencia;

}
