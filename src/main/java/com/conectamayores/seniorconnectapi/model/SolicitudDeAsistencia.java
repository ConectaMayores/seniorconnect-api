package com.conectamayores.seniorconnectapi.model;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class SolicitudDeAsistencia {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "solicitud_de_asistencia_id")
    private int solicitudDeAsistenciaId;

    @Getter @Setter
    @Column(name = "estado", length = 20, nullable = false)
    private String estado;

    @Column(name = "hora", nullable = false)
    private LocalDateTime hora;

    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adulto_mayor_id")
    private AdultoMayor adultoMayor;

    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voluntario_id")
    private Voluntario voluntario;

    @Getter @Setter
    @OneToMany(mappedBy = "solicitud", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Chat> chat = new ArrayList<>();


    //ToDo cambiar a OneToOne a OneToMany



}
