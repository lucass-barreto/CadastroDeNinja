package dev.java10x.CadastroDeNinjas.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja adicionado.";
    }

    @GetMapping("/listar")
    public String mostrarTodosOsNinjas(){
        return "Todos os ninjas.";
    }

    @GetMapping("/listarID")
    public String mostrarNinjaId(){
        return "Ninja por ID.";
    }

    @PutMapping("/alterarID")
    public String alterarNinjaId(){
        return "Ninja alterado.";
    }

    @DeleteMapping("/deletarID")
    public String deletarNinjaId(){
        return "Ninja deletado.";
    }

}
