package max.investimentos.repository;

import max.investimentos.domain.LivroCaixa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroCaixaRepository extends JpaRepository<LivroCaixa, Long> {
    List<LivroCaixa>  findByIdInvestidor(String idInvestidor);
}
