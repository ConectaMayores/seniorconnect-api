package com.conectamayores.seniorconnectapi.config;

import com.conectamayores.seniorconnectapi.dto.AdultoMayorDTO;
import com.conectamayores.seniorconnectapi.model.AdultoMayor;
import org.springframework.stereotype.Component;


@Component
public class AdultoMayorMapper {

    public static AdultoMayorDTO entityToDto(AdultoMayor adultoMayor) {
        AdultoMayorDTO dto = new AdultoMayorDTO();
        dto.setIdAdultoMayor(adultoMayor.getIdAdultoMayor());
        dto.setNombreCompleto(adultoMayor.getNombreCompleto());
        dto.setEdad(adultoMayor.getEdad());
        dto.setGustos(adultoMayor.getGustos());
        dto.setGenero(adultoMayor.getGenero());

        return dto;
    }

    public static AdultoMayor dtoToEntity(AdultoMayorDTO dto) {
        AdultoMayor adultoMayor = new AdultoMayor();
        adultoMayor.setIdAdultoMayor(dto.getIdAdultoMayor());
        adultoMayor.setNombreCompleto(dto.getNombreCompleto());
        adultoMayor.setEdad(dto.getEdad());
        adultoMayor.setGustos(dto.getGustos());
        adultoMayor.setGenero(dto.getGenero());

        return adultoMayor;
    }

}
