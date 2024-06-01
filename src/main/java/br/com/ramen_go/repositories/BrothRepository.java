package br.com.ramen_go.repositories;

import br.com.ramen_go.model.Broth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrothRepository extends JpaRepository<Broth, Long> {
}
