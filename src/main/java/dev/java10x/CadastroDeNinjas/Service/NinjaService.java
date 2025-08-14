package dev.java10x.CadastroDeNinjas.Service;

import dev.java10x.CadastroDeNinjas.Model.NinjaModel;
import dev.java10x.CadastroDeNinjas.Repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

   private NinjaRepository ninjaRepository;

   public List<NinjaModel> listarNinjas(){
       return ninjaRepository.findAll();
   }

   public NinjaModel listarNinjaPorId(Long id){
       Optional<NinjaModel> ninjaId = ninjaRepository.findById(id);
       return ninjaId.orElse(null);
   }

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }
}
