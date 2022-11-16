package max.investimentos.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import max.investimentos.dtos.investimento.InvestimentoRequestDTO;
import max.investimentos.services.LivroCaixaServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

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
        return ResponseEntity.created(URI.create("/venda/" + response.getId())).body(response);
    }
}
