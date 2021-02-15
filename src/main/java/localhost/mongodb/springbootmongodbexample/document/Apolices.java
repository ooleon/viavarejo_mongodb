package localhost.mongodb.springbootmongodbexample.document;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Apolices {

	@Id
	private Long numero;
	private Date vigenciaInício;
	private Date vigenciaFim;
	private String placaVeiculo;
	private Double valor;

	/**
	 * é por este campo de relacao com a entidade cliente que é usado um banco de dados
	 *  relacional de tipo SQL como Oracle, Postgres, Mysql, MsSqlServer, etc
	 *  e nao usar NOSQL como MongoDb. 
	 *  Aqui a explicacao.
	 *  https://www.reddit.com/r/webdev/comments/45v12j/seriously_when_is_nosql_a_good_idea/
	 * */
	private Long cpfCliente;

	
	
	/**
	 * @param numero
	 * @param vigenciaInício
	 * @param vigenciaFim
	 * @param placaVeiculo
	 * @param valor
	 * @param cpfCliente
	 */
	public Apolices(Long numero, Date vigenciaInício, Date vigenciaFim, String placaVeiculo, Double valor,
			Long cpfCliente) {
		this.numero = numero;
		this.vigenciaInício = vigenciaInício;
		this.vigenciaFim = vigenciaFim;
		this.placaVeiculo = placaVeiculo;
		this.valor = valor;
		this.cpfCliente = cpfCliente;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{numero=").append(numero).append(", vigenciaInício=").append(vigenciaInício)
				.append(", vigenciaFim=").append(vigenciaFim).append(", placaVeiculo=").append(placaVeiculo)
				.append(", valor=").append(valor).append(", cpfCliente=").append(cpfCliente).append("}");
		return builder.toString();
	}

	public Long getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(Long cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Date getVigenciaInício() {
		return vigenciaInício;
	}

	public void setVigenciaInício(Date vigenciaInício) {
		this.vigenciaInício = vigenciaInício;
	}

	public Date getVigenciaFim() {
		return vigenciaFim;
	}

	public void setVigenciaFim(Date vigenciaFim) {
		this.vigenciaFim = vigenciaFim;
	}

	public String getPlacaVeiculo() {
		return placaVeiculo;
	}

	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
