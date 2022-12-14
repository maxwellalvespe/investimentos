package max.investimentos.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RegistroDeInvestimentos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String idInvestidor;

    @OneToMany(mappedBy = "registroDeInvestimentos")
    private List<Investimento> investimentos;


}
