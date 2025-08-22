package dev.java10x.CadastroDeNinjas.Service;

import dev.java10x.CadastroDeNinjas.DTO.NinjaDTO;
import dev.java10x.CadastroDeNinjas.DTO.Mapper.NinjaMapper;
import dev.java10x.CadastroDeNinjas.Model.NinjaModel;
import dev.java10x.CadastroDeNinjas.Repository.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {


   private final NinjaRepository ninjaRepository;
   private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //Listar todos os ninjas
   public List<NinjaDTO> listarNinjas(){
       List<NinjaModel> ninjasModel = ninjaRepository.findAll();
       return ninjasModel.stream()
               .map(ninjaMapper::map)
               .collect(Collectors.toList());
   }

   //Procurar um ninja por ID
   public NinjaDTO listarNinjaPorId(Long id){
       Optional<NinjaModel> ninjaId = ninjaRepository.findById(id);
       return ninjaId.map(ninjaMapper :: map).orElse(null);
   }

   //Adicionar um novo ninja
   public NinjaDTO adicionarNinja(NinjaDTO ninjaDTO){
       NinjaModel ninjaModel = ninjaMapper.map(ninjaDTO);
       ninjaModel = ninjaRepository.save(ninjaModel);
       return ninjaMapper.map(ninjaModel);
   }

   //Deletar um ninja por ID
    public void deletarPorId(Long id){
       ninjaRepository.deleteById(id);
    }

    public NinjaDTO alterarNinja(Long id, NinjaDTO ninjaDTOAtualizado){
        Optional<NinjaModel> ninjaId = ninjaRepository.findById(id);
        if (ninjaId.isPresent()){
            NinjaModel ninjaModelAtualizado = ninjaMapper.map(ninjaDTOAtualizado);
            ninjaModelAtualizado.setId(id);
            NinjaModel ninjaSavo = ninjaRepository.save(ninjaModelAtualizado);
            return ninjaMapper.map(ninjaSavo);
        }
        return null;
    }

}
