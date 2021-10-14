package com.pngabo.hotelWebApi.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Validated
public class ClientForm {
    @NotNull
    private Long id;
    @NotBlank
    @Length(min = 3, max = 50)
    private String nom;
    @NotBlank
    @Length(min = 3, max = 50)
    private String prenom;
    @NotBlank
    private String numTel;
    private List<String> moyenPayem;
}
