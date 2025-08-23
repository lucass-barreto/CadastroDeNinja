package dev.java10x.CadastroDeNinjas.Controller.UI;

import dev.java10x.CadastroDeNinjas.DTO.MissaoDTO;
import dev.java10x.CadastroDeNinjas.DTO.NinjaDTO;
import dev.java10x.CadastroDeNinjas.Service.MissaoService;
import dev.java10x.CadastroDeNinjas.Service.NinjaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUI {

    private final NinjaService ninjaService;
    private final MissaoService missaoService;

    public NinjaControllerUI(NinjaService ninjaService, MissaoService missaoService) {
        this.ninjaService = ninjaService;
        this.missaoService = missaoService;
    }

    @GetMapping("/listar")
    public String listarNinjas(Model model){
        List<NinjaDTO> ninjasDTO = ninjaService.listarNinjas();
        model.addAttribute("ninjas", ninjasDTO);
        return "listarNinjas";
    }

    @GetMapping("/deletar/{id}")
    public String deletarPorId(@PathVariable Long id) {
        ninjaService.deletarPorId(id);
        return "redirect:/ninjas/ui/listar";
    }

    @GetMapping("/listar/{id}")
    public String listarPorId(@PathVariable Long id, Model model){
        NinjaDTO ninjaDTO = ninjaService.listarNinjaPorId(id);
        if (ninjaDTO != null){
            model.addAttribute("ninja", ninjaDTO);
            return "detalhesninja";
        } else {
            model.addAttribute("mensagem", "Ninja não encontrado");
            return "listarNinjas";
        }
    }

    @GetMapping("/alterar/{id}")
    public String mostrarFormularioAlterar(@PathVariable Long id, Model model) {
        NinjaDTO ninjaExistente = ninjaService.listarNinjaPorId(id);
        if (ninjaExistente != null) {
            model.addAttribute("ninja", ninjaExistente);
            return "alterarninja";
        }
        return "redirect:/ninjas/ui/listar";
    }


    @GetMapping("/criar")
    public String criarNinja(Model model) {
        model.addAttribute("ninja", new NinjaDTO());
        return "adicionarNinja";
    }

    @PostMapping("/salvar")
    public String salvarNinja(@ModelAttribute NinjaDTO ninjaDTO, RedirectAttributes redirectAttributes) {
        ninjaService.adicionarNinja(ninjaDTO);
        redirectAttributes.addFlashAttribute("mensagem", "Ninja cadastrado com sucesso!");
        return "redirect:/ninjas/ui/listar";
    }
}
