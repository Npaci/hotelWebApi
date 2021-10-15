package com.pngabo.hotelWebApi.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Validated
public class UtilisateurForm {
    @NotNull
    private Long id;
    @NotBlank
    @Length
    private String username;
    @NotBlank
    private String password;
    @NotEmpty
    private List<String> roles;
}
