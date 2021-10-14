package com.pngabo.hotelWebApi.controller;

import com.pngabo.hotelWebApi.exception.ElementAlreadyExistException;
import com.pngabo.hotelWebApi.exception.ElementNotFoundException;
import com.pngabo.hotelWebApi.form.ClientForm;
import com.pngabo.hotelWebApi.model.DTO.ClientDTO;
import com.pngabo.hotelWebApi.model.DTO.ErrorDTO;
import com.pngabo.hotelWebApi.services.ClientService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    ClientService serviceC;

    public ClientController(ClientService serviceC) {
        this.serviceC = serviceC;
    }

//    http://localhost:8080/client/all
    @GetMapping(path = {"", "/", "/all"})
    public List<ClientDTO> getall() {
        return serviceC.getAll();
    }

//    http://localhost:8080/client/1
    @GetMapping("/{id}")
    public ClientDTO getOne(@PathVariable Long id) {
        return serviceC.getOne(id);
    }

//    http://localhost:8080/client?id=1
    @GetMapping(params = {"id"})
    public ClientDTO getOneParam(@RequestParam Long id) {
        return serviceC.getOne(id);
    }

//    http://localhost:8080/client
//    http://localhost:8080/client/
//    http://localhost:8080/client/add
    @PostMapping(path = {"", "/", "/add"})
    public ClientDTO insert(@Valid @RequestBody ClientForm form) {
        return serviceC.insert(form);
    }

//    http://localhost:8080/client
//    http://localhost:8080/client/
//    http://localhost:8080/client/add
    @PatchMapping(path = {"", "/", "/update"})
    public ClientDTO update(@Valid @RequestBody ClientForm form) {
        return serviceC.update(form);
    }

    //    http://localhost:8080/client/1
    @DeleteMapping ("/{id}")
    public ClientDTO delete(@PathVariable Long id) {
        return serviceC.delete(id);
    }


}
