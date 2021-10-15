package com.pngabo.hotelWebApi.controller;

import com.pngabo.hotelWebApi.form.ChambreForm;
import com.pngabo.hotelWebApi.form.ClientForm;
import com.pngabo.hotelWebApi.model.DTO.ChambreDTO;
import com.pngabo.hotelWebApi.model.DTO.ClientDTO;
import com.pngabo.hotelWebApi.services.ChambreServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/chambre")
public class ChambreController {
    private ChambreServiceImpl service;

    public ChambreController(ChambreServiceImpl service) {
        this.service = service;
    }

//    http://localhost:8080/chambre
//    http://localhost:8080/chambre/
//    http://localhost:8080/chambre/all
    @GetMapping(path = {"", "/", "/all"})
    public List<ChambreDTO> getAll() {
        return service.getAll();
    }

//    http://localhost:8080/chambre/1
    @GetMapping("/{id}")
    public ChambreDTO getOne(@PathVariable Long id) {
        return service.getOne(id);
    }

//    http://localhost:8080/chambre?id=1
    @GetMapping(params = "id")
    public ChambreDTO getOneParam(@RequestParam Long id) {
        return service.getOne(id);
    }

//    http://localhost:8080/chambre
//    http://localhost:8080/chambre/
//    http://localhost:8080/chambre/add
    @PostMapping(path = {"", "/", "/add"})
    public ChambreDTO insert(@Valid @RequestBody ChambreForm form) {
        return service.insert(form);
    }

//    http://localhost:8080/chambre
//    http://localhost:8080/chambre/
//    http://localhost:8080/chambre/update
    @PatchMapping (path = {"", "/", "/update"})
    public ChambreDTO update(@Valid @RequestBody ChambreForm form) {
        return service.update(form);
    }

//    http://localhost:8080/chambre/1
    @DeleteMapping("/{id}")
    public ChambreDTO delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
