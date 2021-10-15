package com.pngabo.hotelWebApi.mapper;

import com.pngabo.hotelWebApi.form.UtilisateurForm;
import com.pngabo.hotelWebApi.model.DTO.UtilisateurDTO;
import com.pngabo.hotelWebApi.model.entities.Utilisateur;
import org.springframework.stereotype.Component;

@Component
public class UtilisateurMapper {
    public UtilisateurDTO entityToDTO (Utilisateur u) {
        return UtilisateurDTO.builder()
                .id(u.getId())
                .username(u.getUsername())
                .roles(u.getRoles())
                .accountNonExpired(u.isAccountNonExpired())
                .accountNonLocked(u.isAccountNonLocked())
                .credentialsNonExpired(u.isCredentialsNonExpired())
                .enabled(u.isEnabled())
                .build();
    }

    public Utilisateur formToEntity(UtilisateurForm form) {
        return Utilisateur.builder()
                .id(form.getId())
                .username(form.getUsername())
                .password(form.getPassword())
                .build();
    }
}
