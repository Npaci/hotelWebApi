package com.pngabo.hotelWebApi.services;

import com.pngabo.hotelWebApi.exception.ElementAlreadyExistException;
import com.pngabo.hotelWebApi.exception.ElementNotFoundException;
import com.pngabo.hotelWebApi.form.ChambreForm;
import com.pngabo.hotelWebApi.mapper.ChambreMapper;
import com.pngabo.hotelWebApi.model.DTO.ChambreDTO;
import com.pngabo.hotelWebApi.model.entities.Chambre;
import com.pngabo.hotelWebApi.model.entities.Reservation;
import com.pngabo.hotelWebApi.repositories.ChambreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChambreServiceImpl implements ChambreService{
    private ChambreRepository repository;
    private ChambreMapper mapper;

    public ChambreServiceImpl(ChambreRepository repository, ChambreMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<ChambreDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::entyToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ChambreDTO getOne(Long aLong) {
        if (!repository.existsById(aLong))
            throw new ElementNotFoundException();

        Chambre c = repository.findById(aLong)
                .orElseThrow(ElementNotFoundException::new);

        return mapper.entyToDTO(c);
    }

    @Override
    public ChambreDTO insert(ChambreForm form) {
        if (repository.existsById(form.getId()))
            throw new ElementAlreadyExistException();

        Chambre c = mapper.formToEntity(form);
        repository.save(c);

        return mapper.entyToDTO(c);
    }

    @Override
    public ChambreDTO delete(Long aLong) {
        if (!repository.existsById(aLong))
            throw new ElementNotFoundException();

        Chambre c = repository.findById(aLong)
                .orElseThrow(ElementNotFoundException::new);

        repository.delete(c);

        return mapper.entyToDTO(c);
    }

    @Override
    public ChambreDTO update(ChambreForm form) {
        if (!repository.existsById(form.getId()))
            throw new ElementNotFoundException();

        Chambre toUpdate = mapper.formToEntity(form);
        repository.save(toUpdate);

        return mapper.entyToDTO(toUpdate);
    }
}
