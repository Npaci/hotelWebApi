package com.pngabo.hotelWebApi.form;

import com.pngabo.hotelWebApi.model.TypeChambre;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Validated
public class ChambreForm {
    @NotNull
    private Long id;
    @NotNull
    @Min(1)
    private int numero;
    @NotNull
    @Min(1)
    @Max(5)
    private int nbPlace;
    @NotNull
    private TypeChambre type;
    @NotNull
    private double prix;
}
