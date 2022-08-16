package max.investimentos.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import max.investimentos.domain.dtos.InvestimentoRequestDTO;
import max.investimentos.domain.dtos.TipoDeAcao;
import max.investimentos.domain.services.LivroCaixaServices;
import max.investimentos.entity.InvestimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/investimentos")
@AllArgsConstructor
@Slf4j
public class InvestimentoController {

    private LivroCaixaServices livroCaixaServices;

    @GetMapping("{idInvestidor}/listar")
    public ResponseEntity<?> listar(@PathVariable String idInvestidor) {
        return ResponseEntity.ok(livroCaixaServices.findAll(idInvestidor));
    }

    @PostMapping(path = "{idInvestidor}/aquisicao")
    public ResponseEntity<?> realizarAquisicao(@PathVariable String idInvestidor,
                                               @RequestBody InvestimentoRequestDTO requestDTO) {
        var response = livroCaixaServices.comprar(requestDTO, idInvestidor);
        return ResponseEntity.created(URI.create("/compra/" + requestDTO.getTipoDeAcao())).body(requestDTO);

    }

    @PostMapping(path = "{idInvestidor}/venda")
    public ResponseEntity<?> realizarvenda(@PathVariable String idInvestidor,
                                           @RequestBody InvestimentoRequestDTO requestDTO) {
        var response = livroCaixaServices.vender(requestDTO, idInvestidor);
        return ResponseEntity.created(URI.create("/venda/" + response.getRegistro())).body(response);
    }
}
