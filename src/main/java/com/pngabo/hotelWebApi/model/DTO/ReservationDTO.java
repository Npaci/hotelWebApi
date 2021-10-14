package com.pngabo.hotelWebApi.model.DTO;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ReservationDTO {
    private Long id;
    private LocalDate dateDebut;
    private LocalDate  dateFin;
    private boolean dejeune;
}
