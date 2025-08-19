package dev.java10x.CadastroDeNinjas.Controller;

import dev.java10x.CadastroDeNinjas.Model.MissaoModel;
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
    public MissaoModel criarMissao(MissaoModel missaoModel){
        return missaoService.criarMissao(missaoModel);
    }

    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missão alterada";
    }

    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missão deletada";
    }

    @GetMapping("/listar")
    public List<MissaoModel> listarMissoes(){
        return missaoService.listarMissoes();
    }
}
