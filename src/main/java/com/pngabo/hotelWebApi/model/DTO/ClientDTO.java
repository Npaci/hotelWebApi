package com.pngabo.hotelWebApi.model.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ClientDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String numTel;
    private List<String> moyenPayem;
}
