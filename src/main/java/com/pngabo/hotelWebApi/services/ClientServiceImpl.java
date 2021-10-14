package com.pngabo.hotelWebApi.services;

import com.pngabo.hotelWebApi.exception.ElementAlreadyExistException;
import com.pngabo.hotelWebApi.exception.ElementNotFoundException;
import com.pngabo.hotelWebApi.form.ClientForm;
import com.pngabo.hotelWebApi.mapper.ClientMapper;
import com.pngabo.hotelWebApi.model.DTO.ClientDTO;
import com.pngabo.hotelWebApi.model.entities.Client;
import com.pngabo.hotelWebApi.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService{
    ClientRepository repository;
    ClientMapper mapper;

    public ClientServiceImpl(ClientRepository repository, ClientMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<ClientDTO> getAll() {
        return repository.findAll()
                .stream().map(mapper::entyToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDTO getOne(Long aLong) {

        if (!repository.existsById(aLong))
            throw new ElementNotFoundException();

        return repository.findById(aLong)
                .map(mapper::entyToDTO)
                .orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public ClientDTO insert(ClientForm form) {
        if (repository.existsById(form.getId()))
            throw new ElementAlreadyExistException();

        Client c = mapper.formToEntity(form);
        repository.save(c);

        return mapper.entyToDTO(c);
    }

    @Override
    public ClientDTO delete(Long aLong) {
        if (!repository.existsById(aLong))
            throw new ElementNotFoundException();

        Client toDelete = repository.findById(aLong)
                .orElseThrow(ElementNotFoundException::new);

        repository.delete(toDelete);

        return mapper.entyToDTO(toDelete);
    }

    @Override
    public ClientDTO update(ClientForm form) {
        if (!repository.existsById(form.getId()))
            throw new ElementNotFoundException();

        Client c = mapper.formToEntity(form);
        repository.save(c);

        return mapper.entyToDTO(c);
    }
}
