package localhost.mongodb.springbootmongodbexample.document;

import java.util.Date;

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
    private Date myDTransient;

    @Transient
    private Date myDTransient2;
    
    
    @Transient
    private String myTransient;

    public Date getMyDTransient() {
		return new Date();
	}

	public void setMyDTransient(Date myDTransient) {
		this.myDTransient = myDTransient;
	}

	public Date getMyDTransient2() {
		Date d = new Date(); d.setDate(1);
		return d;
	}

	public void setMyDTransient2(Date myDTransient2) {
		this.myDTransient2 = myDTransient2;
	}

	public String getMyTransient() {
		return "mi";
	}

	public void setMyTransient(String myTransient) {
		this.myTransient = myTransient;
	}

	public Clientes() {
		
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
				.append(", uf=").append(uf).append(", myDTransient=").append(getMyDTransient()).append("}");
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
