package com.pngabo.hotelWebApi.model.DTO;

import com.pngabo.hotelWebApi.model.entities.Chambre;
import com.pngabo.hotelWebApi.model.entities.Client;
import lombok.Builder;
import lombok.Data;

import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
@Builder
public class ReservationDTO {
    private Long id;
    private LocalDate dateDebut;
    private LocalDate  dateFin;
    private boolean dejeune;
    private Chambre chambre;
    private Client client;
}
