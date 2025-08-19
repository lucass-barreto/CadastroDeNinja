package dev.java10x.CadastroDeNinjas.Service;

import dev.java10x.CadastroDeNinjas.Model.NinjaModel;
import dev.java10x.CadastroDeNinjas.Repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

   private NinjaRepository ninjaRepository;

   //Listar todos os ninjas
   public List<NinjaModel> listarNinjas(){
       return ninjaRepository.findAll();
   }

   //Procurar um ninja por ID
   public NinjaModel listarNinjaPorId(Long id){
       Optional<NinjaModel> ninjaId = ninjaRepository.findById(id);
       return ninjaId.orElse(null);
   }

   //Adicionar um novo ninja
   public NinjaModel adicionarNinja(NinjaModel ninja){
       return ninjaRepository.save(ninja);
   }

   //Deletar um ninja por ID
    public void deletarPorId(Long id){
       ninjaRepository.deleteById(id);
    }

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }
}
