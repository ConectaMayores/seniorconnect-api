package com.conectamayores.seniorconnectapi.model;


import jakarta.persistence.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class AdultoMayor {

    @Getter  @Setter
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAdultoMayor;

    @Getter  @Setter
    @Column(length = 50, nullable = false)
    private String nombreCompleto;

    @Getter  @Setter
    @Column(name = "edad", nullable = false, length = 3)
    private String edad;

    @Getter  @Setter
    @Column(length = 50, nullable = false)
    private String tipoUsuario;

    @Getter  @Setter
    @Column(nullable = false)
    private boolean apoyoEmocional;

    @Getter  @Setter
    @Column(nullable = false)
    private boolean asistencia;


}
