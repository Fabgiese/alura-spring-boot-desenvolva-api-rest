package med.voll.api.domain.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
    }

    public void atualizarInformacoes(DadosEndereco endereco) {
        this.logradouro = endereco.logradouro() != null ? endereco.logradouro() : this.logradouro;
        this.bairro = endereco.bairro() != null ? endereco.bairro() : this.bairro;
        this.cep = endereco.cep() != null ? endereco.cep() : this.cep;
        this.cidade = endereco.cidade() != null ? endereco.cidade() : this.cidade;
        this.uf = endereco.uf() != null ? endereco.uf() : this.uf;
        this.numero = endereco.numero() != null ? endereco.numero() : this.numero;
        this.complemento = endereco.complemento() != null ? endereco.complemento() : this.complemento;
    }
}
