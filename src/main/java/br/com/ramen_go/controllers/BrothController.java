package br.com.ramen_go.controllers;

import br.com.ramen_go.dtos.BrothResponseDto;
import br.com.ramen_go.services.BrothService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/broths")
public class BrothController {
    private final BrothService brothService;

    public BrothController(BrothService brothService) {
        this.brothService = brothService;
    }

    @GetMapping
    public ResponseEntity<List<BrothResponseDto>>listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.brothService.listAllBroths());
    }
}
