package localhost.mongodb.springbootmongodbexample.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Clientes {

	@Id
    private Long cpf;
    private String nome;
    private String cidade;
    private String uf;
    
    @Transient
    private String myTransient;

    public String getMyTransient() {
		return "mi";
	}

	public void setMyTransient(String myTransient) {
		this.myTransient = myTransient;
	}

	/**
	 * @param cpf
	 * @param nome
	 * @param cidade
	 * @param uf
	 */
	public Clientes(Long cpf, String nome, String cidade, String uf) {
		this.cpf = cpf;
		this.nome = nome;
		this.cidade = cidade;
		this.uf = uf;
	}
    
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{cpf=").append(cpf).append(", nome=").append(nome).append(", cidade=").append(cidade)
				.append(", uf=").append(uf).append("}");
		return builder.toString();
	}


	public Long getCpf() {
		return cpf;
	}


	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getUf() {
		return uf;
	}


	public void setUf(String uf) {
		this.uf = uf;
	}
}
