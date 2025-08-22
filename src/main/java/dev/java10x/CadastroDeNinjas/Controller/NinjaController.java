package dev.java10x.CadastroDeNinjas.Controller;

import dev.java10x.CadastroDeNinjas.DTO.NinjaDTO;
import dev.java10x.CadastroDeNinjas.Service.NinjaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninjaDTO){
        NinjaDTO ninjaDTOCriado = ninjaService.adicionarNinja(ninjaDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja " + ninjaDTOCriado.getNome() + " (ID: " + ninjaDTOCriado.getId() + ") criado com sucesso");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjasDTO = ninjaService.listarNinjas();
        return ResponseEntity.status(HttpStatus.OK)
                .body(ninjasDTO);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id){
        NinjaDTO ninjaDTO = ninjaService.listarNinjaPorId(id);
        if (ninjaDTO != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(ninjaDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja (ID: " + id + ") não encontrado");
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinjaId(@PathVariable Long id, @RequestBody NinjaDTO ninjaDTOAtualizado){
        if (ninjaService.listarNinjaPorId(id) != null){
            NinjaDTO ninjaDTO = ninjaService.alterarNinja(id, ninjaDTOAtualizado);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(ninjaDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja (ID: " + id + ") não encontrado");
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarPorId(@PathVariable Long id){
        if (ninjaService.listarNinjaPorId(id) != null){
            ninjaService.deletarPorId(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Ninja (ID: " + id + ") deletado com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja (ID: " + id + ") não encontrado");
    }

}
