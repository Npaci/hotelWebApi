package com.pngabo.hotelWebApi.services;

import com.pngabo.hotelWebApi.exception.ElementAlreadyExistException;
import com.pngabo.hotelWebApi.exception.ElementNotFoundException;
import com.pngabo.hotelWebApi.exception.RoleInvalidException;
import com.pngabo.hotelWebApi.form.UtilisateurForm;
import com.pngabo.hotelWebApi.mapper.UtilisateurMapper;
import com.pngabo.hotelWebApi.model.DTO.UtilisateurDTO;
import com.pngabo.hotelWebApi.model.entities.Utilisateur;
import com.pngabo.hotelWebApi.repositories.UtilisateurRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {
    private final UtilisateurRepository repository;
    private final UtilisateurMapper mapper;
    private final PasswordEncoder encoder;

    public UtilisateurServiceImpl(UtilisateurRepository repository, UtilisateurMapper mapper, PasswordEncoder encoder) {
        this.repository = repository;
        this.mapper = mapper;
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return repository.findByUsername(s)
                .orElseThrow( ()-> new UsernameNotFoundException("L'utilisateur donné n'existe pas") );
    }

    @Override
    public UtilisateurDTO insert(UtilisateurForm form) {
        if( form.getRoles().stream().anyMatch(role -> !role.equals("USER") && !role.equals("ADMIN")) )
            throw new RoleInvalidException();

        if (repository.existsById(form.getId()))
            throw new ElementAlreadyExistException();

        Utilisateur toInsert = mapper.formToEntity(form);
        toInsert.setPassword(encoder.encode( form.getPassword() ));
        toInsert = repository.save(toInsert);

        return mapper.entityToDTO(toInsert);
    }

    @Override
    public UtilisateurDTO update(UtilisateurForm form) {

        if( form.getRoles().stream().anyMatch(role -> !role.equals("USER") && !role.equals("ADMIN")) )
            throw new RoleInvalidException();

        Utilisateur toUpdate = repository.findById(form.getId())
                .orElseThrow(ElementNotFoundException::new);

        toUpdate.setUsername( form.getUsername() );
        toUpdate.setPassword( encoder.encode(form.getPassword()) );
        toUpdate.setRoles( form.getRoles() );

        toUpdate = repository.save( toUpdate );

        return mapper.entityToDTO(toUpdate);
    }

    @Override
    public List<UtilisateurDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::entityToDTO)
                .collect(Collectors.toList());
    }
}
