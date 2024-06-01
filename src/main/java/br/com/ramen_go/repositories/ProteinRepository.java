package br.com.ramen_go.repositories;

import br.com.ramen_go.model.Protein;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProteinRepository extends JpaRepository<Protein, String> {
}
