package com.pngabo.hotelWebApi.form;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Validated
public class ReservationForm {
    @NotNull
    private Long id;
    @NotNull
    private LocalDate dateDebut;
    @NotNull
    private LocalDate  dateFin;
    @NotNull
    private boolean dejeune;
}
