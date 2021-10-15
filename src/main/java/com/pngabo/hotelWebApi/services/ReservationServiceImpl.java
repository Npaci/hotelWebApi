package com.pngabo.hotelWebApi.services;

import com.pngabo.hotelWebApi.exception.ElementAlreadyExistException;
import com.pngabo.hotelWebApi.exception.ElementNotFoundException;
import com.pngabo.hotelWebApi.form.ReservationForm;
import com.pngabo.hotelWebApi.mapper.ReservationMapper;
import com.pngabo.hotelWebApi.model.DTO.ReservationDTO;
import com.pngabo.hotelWebApi.model.entities.Client;
import com.pngabo.hotelWebApi.model.entities.Reservation;
import com.pngabo.hotelWebApi.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService{
    private ReservationRepository repository;
    private ReservationMapper mapper;

    public ReservationServiceImpl(ReservationRepository repository, ReservationMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<ReservationDTO> getAll() {
        return repository.findAll()
                .stream().map(mapper::entyToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReservationDTO getOne(Long aLong) {
        if (!repository.existsById(aLong))
            throw new ElementNotFoundException();

        return repository.findById(aLong)
                .map(mapper::entyToDTO)
                .orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public ReservationDTO insert(ReservationForm form) {
        if (repository.existsById(form.getId()))
            throw new ElementAlreadyExistException();

        Reservation toInsert = mapper.formToEntity(form);
        repository.save(toInsert);

        return mapper.entyToDTO(toInsert);
    }

    @Override
    public ReservationDTO delete(Long aLong) {
        if (!repository.existsById(aLong))
            throw new ElementNotFoundException();

        Reservation toDelete = repository.findById(aLong)
                .orElseThrow(ElementNotFoundException::new);

        repository.delete(toDelete);

        return mapper.entyToDTO(toDelete);
    }

    @Override
    public ReservationDTO update(ReservationForm form) {
        if (!repository.existsById(form.getId()))
            throw new ElementNotFoundException();

        Reservation toUpdate = mapper.formToEntity(form);
        repository.save(toUpdate);

        return mapper.entyToDTO(toUpdate);
    }
}
