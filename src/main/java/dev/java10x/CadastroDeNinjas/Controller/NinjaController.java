package dev.java10x.CadastroDeNinjas.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja adicionado.";
    }

    @GetMapping("/todos")
    public String mostrarTodosOsNinjas(){
        return "Todos os ninjas.";
    }

    @GetMapping("/todosID")
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
