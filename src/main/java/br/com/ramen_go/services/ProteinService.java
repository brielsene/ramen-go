package br.com.ramen_go.services;

import br.com.ramen_go.dtos.BrothResponseDto;
import br.com.ramen_go.dtos.ProteinResponseDto;
import br.com.ramen_go.model.Protein;
import br.com.ramen_go.repositories.ProteinRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProteinService {
    private final ProteinRepository repository;

    public ProteinService(ProteinRepository repository) {
        this.repository = repository;
    }

    public List<ProteinResponseDto> listAllProteins(){
        return this.repository.findAll().stream().map(p -> new ProteinResponseDto(p.getId(), p.getImageInactive(), p.getImageActive(), p.getName(),
                p.getDescription(), p.getPrice())).toList();

    }

    public ProteinResponseDto findProteinById(Long id){
        Protein protein = this.repository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Not found protein with ID")
        );
        ProteinResponseDto proteinResponseDto = null;
        BeanUtils.copyProperties(protein, proteinResponseDto);
        return proteinResponseDto;
    }
}
