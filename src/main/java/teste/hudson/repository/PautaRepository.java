package teste.hudson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teste.hudson.model.entity.Pauta;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Long> {

}
