package dev.java10x.CadastroDeNinjas.DTO.Mapper;

import dev.java10x.CadastroDeNinjas.DTO.MissaoDTO;
import dev.java10x.CadastroDeNinjas.Model.MissaoModel;
import org.springframework.stereotype.Component;

@Component
public class MissaoMapper {

    public MissaoModel map(MissaoDTO missaoDTO){
        MissaoModel missaoModel = new MissaoModel();
        missaoModel.setId(missaoDTO.getId());
        missaoModel.setNome(missaoDTO.getNome());
        missaoModel.setDificuldade(missaoDTO.getDificuldade());
        missaoModel.setNinjas(missaoDTO.getNinjas());
        return missaoModel;
    }

    public MissaoDTO map(MissaoModel missaoModel){
        MissaoDTO missaoDTO = new MissaoDTO();
        missaoDTO.setId(missaoModel.getId());
        missaoDTO.setNome(missaoModel.getNome());
        missaoDTO.setDificuldade(missaoModel.getDificuldade());
        missaoDTO.setNinjas(missaoModel.getNinjas());
        return missaoDTO;
    }
}
