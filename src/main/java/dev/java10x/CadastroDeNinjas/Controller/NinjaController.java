package dev.java10x.CadastroDeNinjas.Controller;

import dev.java10x.CadastroDeNinjas.Model.NinjaModel;
import dev.java10x.CadastroDeNinjas.Service.NinjaService;
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
    public String criarNinja(){
        return "Ninja adicionado.";
    }

    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    @GetMapping("/listar/{id}")
    public NinjaModel listarPorId(@PathVariable Long id){
        return ninjaService.listarNinjaPorId(id);
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
