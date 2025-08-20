package dev.java10x.CadastroDeNinjas.Controller;

import dev.java10x.CadastroDeNinjas.DTO.MissaoDTO;
import dev.java10x.CadastroDeNinjas.Service.MissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissaoController {

    @Autowired
    private MissaoService missaoService;

    @PostMapping("/criar")
    public MissaoDTO criarMissao(@RequestBody MissaoDTO missaoDTO){
        return missaoService.criarMissao(missaoDTO);
    }

    @PutMapping("/alterar/{id}")
    public MissaoDTO alterarMissao(@PathVariable Long id, @RequestBody MissaoDTO missaoDTOAtualizada){
        return missaoService.alterarMissao(id, missaoDTOAtualizada);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable Long id){
        missaoService.deletarMissao(id);
    }

    @GetMapping("/listar")
    public List<MissaoDTO> listarMissoes(){
        return missaoService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissaoDTO listarMissaoPorId(@PathVariable Long id){
        return missaoService.listarMissaoPorId(id);
    }
}
