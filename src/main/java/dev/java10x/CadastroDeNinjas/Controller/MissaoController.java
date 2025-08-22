package dev.java10x.CadastroDeNinjas.Controller;

import dev.java10x.CadastroDeNinjas.DTO.MissaoDTO;
import dev.java10x.CadastroDeNinjas.Service.MissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissaoController {


    private final MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarMissao(@RequestBody MissaoDTO missaoDTO){
        MissaoDTO missaoDTOCriado = missaoService.criarMissao(missaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão (" + missaoDTOCriado.getNome() + " - ID: " + missaoDTOCriado.getId() + ") criada com sucesso!");
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarMissao(@PathVariable Long id, @RequestBody MissaoDTO missaoDTOAtualizada){
        if (missaoService.listarMissaoPorId(id) != null){
            MissaoDTO missaoAtualizada = missaoService.alterarMissao(id, missaoDTOAtualizada);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Missão (" + missaoAtualizada.getNome() + " - ID: " + missaoAtualizada.getId() + ") foi atualizada com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Missão não encontrada");
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissao(@PathVariable Long id){
        if (missaoService.listarMissaoPorId(id) != null) {
            missaoService.deletarMissao(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Missão deletada com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Missão não encontrada");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MissaoDTO>> listarMissoes(){
        List<MissaoDTO> missoesDTO =  missaoService.listarMissoes();
        return ResponseEntity.status(HttpStatus.OK)
                .body(missoesDTO);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarMissaoPorId(@PathVariable Long id){
         MissaoDTO missaoDTO = missaoService.listarMissaoPorId(id);
         if(missaoDTO != null){
             return ResponseEntity.status(HttpStatus.OK).body(missaoDTO);
         }
         return ResponseEntity.status(HttpStatus.NOT_FOUND).
                 body("Missão não encontrada");
    }
}
