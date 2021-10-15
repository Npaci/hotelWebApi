package com.pngabo.hotelWebApi.model.DTO;

import com.pngabo.hotelWebApi.model.TypeChambre;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChambreDTO {
    private Long id;
    private int numero;
    private int nbPlace;
    private TypeChambre type;
    private double prix;
}
