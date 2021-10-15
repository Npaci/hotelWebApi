package com.pngabo.hotelWebApi.controller;

import com.pngabo.hotelWebApi.form.ClientForm;
import com.pngabo.hotelWebApi.model.DTO.ClientDTO;
import com.pngabo.hotelWebApi.services.ClientService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    ClientService service;

    public ClientController(ClientService serviceC) {
        this.service = serviceC;
    }

//    http://localhost:8080/client/all
    @GetMapping(path = {"", "/", "/all"})
    public List<ClientDTO> getall() {
        return service.getAll();
    }

//    http://localhost:8080/client/1
    @GetMapping("/{id}")
    public ClientDTO getOne(@PathVariable Long id) {
        return service.getOne(id);
    }

//    http://localhost:8080/client?id=1
    @GetMapping(params = "id")
    public ClientDTO getOneParam(@RequestParam Long id) {
        return service.getOne(id);
    }

//    http://localhost:8080/client
//    http://localhost:8080/client/
//    http://localhost:8080/client/add
    @PostMapping(path = {"", "/", "/add"})
    public ClientDTO insert(@Valid @RequestBody ClientForm form) {
        return service.insert(form);
    }

//    http://localhost:8080/client
//    http://localhost:8080/client/
//    http://localhost:8080/client/add
    @PatchMapping(path = {"", "/", "/update"})
    public ClientDTO update(@Valid @RequestBody ClientForm form) {
        return service.update(form);
    }

//    http://localhost:8080/client/1
    @DeleteMapping ("/{id}")
    public ClientDTO delete(@PathVariable Long id) {
        return service.delete(id);
    }


}
