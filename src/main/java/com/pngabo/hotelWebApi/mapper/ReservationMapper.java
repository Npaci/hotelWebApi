package com.pngabo.hotelWebApi.mapper;

import com.pngabo.hotelWebApi.form.ReservationForm;
import com.pngabo.hotelWebApi.model.DTO.ReservationDTO;
import com.pngabo.hotelWebApi.model.entities.Reservation;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {
    public ReservationDTO entyToDTO(Reservation c) {

        if (c == null)
            return null;

        return ReservationDTO.builder()
                .id(c.getId())
                .dateDebut(c.getDateDebut())
                .dateFin(c.getDateFin())
                .dejeune(c.isDejeune())
                .build();

    }

    public Reservation dtoToEntity(ReservationDTO dto) {

        if (dto == null)
            return null;

        return Reservation.builder()
                .id(dto.getId())
                .dateDebut(dto.getDateDebut())
                .dateFin(dto.getDateFin())
                .dejeune(dto.isDejeune())
                .build();

    }

    public Reservation formToEntity(ReservationForm form) {

        if (form == null)
            return null;

        return Reservation.builder()
                .id(form.getId())
                .dateDebut(form.getDateDebut())
                .dateFin(form.getDateFin())
                .dejeune(form.isDejeune())
                .build();

    }
}
