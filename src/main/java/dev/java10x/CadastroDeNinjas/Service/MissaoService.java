package dev.java10x.CadastroDeNinjas.Service;

import dev.java10x.CadastroDeNinjas.DTO.Mapper.MissaoMapper;
import dev.java10x.CadastroDeNinjas.DTO.MissaoDTO;
import dev.java10x.CadastroDeNinjas.Model.MissaoModel;
import dev.java10x.CadastroDeNinjas.Repository.MissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissaoService {


    private final MissaoRepository missaoRepository;
    private final MissaoMapper missaoMapper;

    public MissaoService(MissaoMapper missaoMapper, MissaoRepository missaoRepository) {
        this.missaoMapper = missaoMapper;
        this.missaoRepository = missaoRepository;
    }

    //Listar Missões
    public List<MissaoDTO> listarMissoes(){
        List<MissaoModel> missoesModel = missaoRepository.findAll();
        return missoesModel.stream()
                .map(missaoMapper :: map)
                .collect(Collectors.toList());
    }

    //Listar missão por id
    public MissaoDTO listarMissaoPorId(Long id){
        Optional<MissaoModel> missaoId = missaoRepository.findById(id);
        return missaoId.map(missaoMapper :: map).orElse(null);
    }

    //Criar missão
    public MissaoDTO criarMissao(MissaoDTO missaoDTO){
        MissaoModel missaoModel = missaoMapper.map(missaoDTO);
        missaoModel = missaoRepository.save(missaoModel);
        return missaoMapper.map(missaoModel);
    }

    //Deletar missao
    public void deletarMissao(Long id){
        missaoRepository.deleteById(id);
    }

    //Alterar missao
    public MissaoDTO alterarMissao(Long id, MissaoDTO missaoDTOAtualizada){
        Optional<MissaoModel> missaoModel = missaoRepository.findById(id);

        if (missaoModel.isPresent()){
            MissaoModel missaoModelAtualizado = missaoMapper.map(missaoDTOAtualizada);
            missaoModelAtualizado.setId(id);
            MissaoModel missaoSalva = missaoRepository.save(missaoModelAtualizado);
            return missaoMapper.map(missaoSalva);
        }

        return null;
    }
}
