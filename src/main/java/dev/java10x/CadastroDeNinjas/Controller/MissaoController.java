package dev.java10x.CadastroDeNinjas.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissaoController {

    @PostMapping("/criar")
    public String criarMissao(){
        return "Missão criada.";
    }

    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missão alterada";
    }

    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missão deletada";
    }

    @PostMapping("/listar")
    public String listarMissao(){
        return "Lista das missões:";
    }
}
