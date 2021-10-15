package com.pngabo.hotelWebApi.mapper;

import com.pngabo.hotelWebApi.form.ChambreForm;
import com.pngabo.hotelWebApi.model.DTO.ChambreDTO;
import com.pngabo.hotelWebApi.model.entities.Chambre;
import org.springframework.stereotype.Component;

@Component
public class ChambreMapper {
    public ChambreDTO entyToDTO(Chambre c) {

        if (c == null)
            return null;

        return ChambreDTO.builder()
                .id(c.getId())
                .numero(c.getNumero())
                .nbPlace(c.getNbPlace())
                .type(c.getType())
                .prix(c.getPrix())
                .build();

    }

    public Chambre dtoToEntity(ChambreDTO dto) {

        if (dto == null)
            return null;

        return Chambre.builder()
                .id(dto.getId())
                .numero(dto.getNumero())
                .nbPlace(dto.getNbPlace())
                .type(dto.getType())
                .prix(dto.getPrix())
                .build();

    }

    public Chambre formToEntity(ChambreForm form) {

        if (form == null)
            return null;

        return Chambre.builder()
                .id(form.getId())
                .numero(form.getNumero())
                .nbPlace(form.getNbPlace())
                .type(form.getType())
                .prix(form.getPrix())
                .build();

    }
}
