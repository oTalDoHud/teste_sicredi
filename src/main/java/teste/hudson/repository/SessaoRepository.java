package teste.hudson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teste.hudson.model.entity.Sessao;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Long> {

}
