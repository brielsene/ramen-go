package br.com.ramen_go.services;

import br.com.ramen_go.dtos.BrothResponseDto;
import br.com.ramen_go.repositories.BrothRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrothService {
    private final BrothRepository brothRepository;

    public BrothService(BrothRepository brothRepository) {
        this.brothRepository = brothRepository;
    }

    public List<BrothResponseDto> listAllBroths(){
        return this.brothRepository.findAll().stream().map(b -> new BrothResponseDto(
                b.getId(), b.getImageInactive(), b.getImageActive(), b.getName(),
                b.getDescription(), b.getPrice())).toList();

    }
}
