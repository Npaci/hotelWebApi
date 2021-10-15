package com.pngabo.hotelWebApi.services;

import com.pngabo.hotelWebApi.exception.ElementAlreadyExistException;
import com.pngabo.hotelWebApi.form.UtilisateurForm;
import com.pngabo.hotelWebApi.mapper.UtilisateurMapper;
import com.pngabo.hotelWebApi.model.DTO.UtilisateurDTO;
import com.pngabo.hotelWebApi.model.entities.Utilisateur;
import com.pngabo.hotelWebApi.repositories.UtilisateurRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {
    private final UtilisateurRepository repository;
    private final UtilisateurMapper mapper;

    public UtilisateurServiceImpl(UtilisateurRepository repository, UtilisateurMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return repository.findByUsername(s)
                .orElseThrow( ()-> new UsernameNotFoundException("L'utilisateur donné n'existe pas") );
    }

    @Override
    public UtilisateurDTO insert(UtilisateurForm form) {
        if (repository.existsById(form.getId()))
            throw new ElementAlreadyExistException();

        Utilisateur toInsert = mapper.formToEntity(form);
        repository.save(toInsert);

        return mapper.entityToDTO(toInsert);
    }

    @Override
    public UtilisateurDTO update(UtilisateurForm form) {
        return null;
    }

    @Override
    public List<UtilisateurDTO> getAll() {
        return null;
    }
}
