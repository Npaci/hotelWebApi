package com.pngabo.hotelWebApi.mapper;

import com.pngabo.hotelWebApi.form.ClientForm;
import com.pngabo.hotelWebApi.model.DTO.ClientDTO;
import com.pngabo.hotelWebApi.model.entities.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {
    public ClientDTO entyToDTO(Client c) {

        if (c == null)
            return null;

        return ClientDTO.builder()
                .id(c.getId())
                .nom(c.getNom())
                .prenom(c.getPrenom())
                .numTel(c.getNumTel())
                .moyenPayem(c.getMoyenPayem())
                .build();

    }

    public Client dtoToEntity(ClientDTO dto) {

        if (dto == null)
            return null;

        return Client.builder()
                .id(dto.getId())
                .nom(dto.getNom())
                .prenom(dto.getPrenom())
                .numTel(dto.getNumTel())
                .moyenPayem(dto.getMoyenPayem())
                .build();

    }

    public Client formToEntity(ClientForm form) {

        if (form == null)
            return null;

        return Client.builder()
                .id(form.getId())
                .nom(form.getNom())
                .prenom(form.getPrenom())
                .numTel(form.getNumTel())
                .moyenPayem(form.getMoyenPayem())
                .build();

    }
}
