package max.investimentos.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import max.investimentos.domain.Investidor;
import max.investimentos.dtos.investidor.InvestidorRequest;
import max.investimentos.dtos.investidor.InvestidorResponse;
import max.investimentos.services.InvestidorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/investidores")
@RequiredArgsConstructor
@Slf4j
public class InvestidorController {

    private final InvestidorService service;


    @GetMapping
    public ResponseEntity<List<InvestidorResponse>> findAllInvestidores() {
        log.info("Obtendo investidor..");
        return new ResponseEntity<>(service.listar(), HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<InvestidorResponse> registry(@RequestBody InvestidorRequest investidor) {
        log.info("Cadastrando invedor.. {}", investidor.getNome());
        return new ResponseEntity<>(service.cadastrar(investidor), HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> remover(@RequestParam("id") UUID id) {
        log.info("Removendo investidor : {}", id);
        service.remover(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
