package dev.java10x.CadastroDeNinjas.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString (exclude = "missao")
@Entity
@Table(name = "tb_cadastro")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column (name = "nome_ninja")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column (name = "idade")
    private int idade;

    @Column (name = "rank")
    private String rank;

    @ManyToOne
    @JoinColumn(name = "missoes_id") // Foreing Key
    private MissaoModel missao;


}
