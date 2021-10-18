package com.pngabo.hotelWebApi.model.DTO;

import com.pngabo.hotelWebApi.model.TypeChambre;
import com.pngabo.hotelWebApi.model.entities.Reservation;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ChambreDTO {
    private Long id;
    private int numero;
    private int nbPlace;
    private TypeChambre type;
    private double prix;
    private List<Reservation> reservations;
}
