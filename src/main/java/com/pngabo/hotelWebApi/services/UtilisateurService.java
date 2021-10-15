package com.pngabo.hotelWebApi.services;

import com.pngabo.hotelWebApi.form.UtilisateurForm;
import com.pngabo.hotelWebApi.model.DTO.UtilisateurDTO;
import com.pngabo.hotelWebApi.model.entities.Utilisateur;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UtilisateurService extends UserDetailsService {
    UtilisateurDTO insert(UtilisateurForm form);
    UtilisateurDTO update(UtilisateurForm form);
    List<UtilisateurDTO> getAll();
}
