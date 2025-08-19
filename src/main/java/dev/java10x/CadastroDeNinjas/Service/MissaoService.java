package dev.java10x.CadastroDeNinjas.Service;

import dev.java10x.CadastroDeNinjas.Model.MissaoModel;
import dev.java10x.CadastroDeNinjas.Repository.MissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissaoService {

    @Autowired
    private MissaoRepository missaoRepository;

    /*TODO:
    *  alterar missao por id*/

    //Listar Missões
    public List<MissaoModel> listarMissoes(){
        return missaoRepository.findAll();
    }

    //Listar missão por id
    public MissaoModel listarMissaoPorId(Long id){
        Optional<MissaoModel> missaoId = missaoRepository.findById(id);
        return missaoId.orElse(null);
    }

    //Criar missão
    public MissaoModel criarMissao(MissaoModel missaoModel){
        return missaoRepository.save(missaoModel);
    }

    //Deletar missao
    public void deletarMissao(Long id){
        missaoRepository.deleteById(id);
    }

    //Alterar missao
    public MissaoModel alterarMissao(Long id, MissaoModel missaoAtualizada){
        if(missaoRepository.existsById(id)){
            missaoAtualizada.setId(id);
            return missaoRepository.save(missaoAtualizada);
        } else {
            return null;
        }
    }
}
