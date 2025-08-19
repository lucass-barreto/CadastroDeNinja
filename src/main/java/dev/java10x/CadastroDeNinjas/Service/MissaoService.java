package dev.java10x.CadastroDeNinjas.Service;

import dev.java10x.CadastroDeNinjas.Model.MissaoModel;
import dev.java10x.CadastroDeNinjas.Repository.MissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissaoService {

    @Autowired
    private MissaoRepository missaoRepository;

    /*TODO:
    *  Criar missoes
    *  Deletar missao por id
    *  alterar missao por id
    *  Listar por id*/

    //Listar Missao
    public List<MissaoModel> listarMissoes(){
        return missaoRepository.findAll();
    }

    //Criar missão
    public MissaoModel criarMissao(MissaoModel missaoModel){
        return missaoRepository.save(missaoModel);
    }
}
