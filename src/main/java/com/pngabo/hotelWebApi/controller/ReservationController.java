package com.pngabo.hotelWebApi.controller;

import com.pngabo.hotelWebApi.form.ChambreForm;
import com.pngabo.hotelWebApi.form.ReservationForm;
import com.pngabo.hotelWebApi.model.DTO.ChambreDTO;
import com.pngabo.hotelWebApi.model.DTO.ReservationDTO;
import com.pngabo.hotelWebApi.services.ReservationService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    private ReservationService service;

    public ReservationController(ReservationService service) {
        this.service = service;
    }

//    http://localhost:8080/reservation
//    http://localhost:8080/reservation/
//    http://localhost:8080/reservation/all
    @GetMapping(path = {"", "/", "/all"})
    public List<ReservationDTO> getAll() {
        return service.getAll();
    }

//    http://localhost:8080/reservation/1
    @GetMapping("/{id}")
    public ReservationDTO getOne(@PathVariable Long id) {
        return service.getOne(id);
    }

//    http://localhost:8080/reservation?id=1
    @GetMapping(params = "id")
    public ReservationDTO getOneParam(@RequestParam Long id) {
        return service.getOne(id);
    }

//    http://localhost:8080/reservation
//    http://localhost:8080/reservation/
//    http://localhost:8080/reservation/add
    @PostMapping(path = {"", "/", "/add"})
    public ReservationDTO insert(@Valid @RequestBody ReservationForm form) {
        return service.insert(form);
    }

    //    http://localhost:8080/reservation
//    http://localhost:8080/reservation/
//    http://localhost:8080/reservation/update
    @PatchMapping (path = {"", "/", "/update"})
    public ReservationDTO update(@Valid @RequestBody ReservationForm form) {
        return service.update(form);
    }

    //    http://localhost:8080/reservation/1
    @DeleteMapping("/{id}")
    public ReservationDTO delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
