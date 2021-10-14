package com.pngabo.hotelWebApi.model.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChambreDTO {
    private Long id;
    private int numero;
    private int nbPlace;
    private String type;
    private double prix;
}
