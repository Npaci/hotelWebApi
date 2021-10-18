package com.pngabo.hotelWebApi.controller;

import com.pngabo.hotelWebApi.form.UtilisateurForm;
import com.pngabo.hotelWebApi.model.DTO.UtilisateurDTO;
import com.pngabo.hotelWebApi.services.UtilisateurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UtilisateurController {
    public final UtilisateurService service;

    public UtilisateurController(UtilisateurService service) {
        this.service = service;
    }

    @PostMapping(path = {"", "/", "/add"})
    public ResponseEntity<UtilisateurDTO> insert(@Valid @RequestBody UtilisateurForm form){
        return ResponseEntity.ok( service.insert(form) );
    }

    @PutMapping(path = {"", "/", "/update"})
    public ResponseEntity<UtilisateurDTO> update(@Valid @RequestBody UtilisateurForm form){
        return ResponseEntity.ok( service.update(form) );
    }

    @GetMapping(path = {"", "/", "/all"})
    public ResponseEntity<List<UtilisateurDTO>> getAll(){
        return ResponseEntity.ok( service.getAll() );
    }
}
