package com.conectamayores.seniorconnectapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Plataforma {

    @Getter
    @Setter
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPlataforma;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn (name = "listaAdultoMayor", nullable = false)
    private List<AdultoMayor> adultosMayores;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn (name = "listaFamiliares", nullable = false)
    private List<Familiar> Familiares;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn (name = "listaVoluntarios", nullable = false)
    private List<Voluntario> voluntarios;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn (name = "listaProgramas", nullable = false)
    private List<Programa> programas;


}
