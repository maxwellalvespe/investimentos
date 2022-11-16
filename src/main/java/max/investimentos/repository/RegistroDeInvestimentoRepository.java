package max.investimentos.repository;

import max.investimentos.domain.RegistroDeInvestimentos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroDeInvestimentoRepository extends JpaRepository<RegistroDeInvestimentos,String> {
}
