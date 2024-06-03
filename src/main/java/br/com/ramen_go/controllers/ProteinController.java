package br.com.ramen_go.controllers;

import br.com.ramen_go.dtos.ProteinResponseDto;
import br.com.ramen_go.services.ProteinService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proteins")
public class ProteinController {
    private final ProteinService service;

    public ProteinController(ProteinService service) {
        this.service = service;
    }

    @GetMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<ProteinResponseDto>>listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.service.listAllProteins());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProteinResponseDto>findById(@PathVariable("id")Long id){
        return ResponseEntity.status(HttpStatus.OK).body(this.service.findProteinById(id));
    }
}
