package max.investimentos.repository;

import max.investimentos.domain.Investidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InvestidorRepository extends JpaRepository<Investidor, UUID> {
}
