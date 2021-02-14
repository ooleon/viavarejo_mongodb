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
	 * @param numero
	 * @param vigenciaInício
	 * @param vigenciaFim
	 * @param placaVeiculo
	 * @param valor
	 */
	public Apolices(Long numero, Date vigenciaInício, Date vigenciaFim, String placaVeiculo, Double valor) {
		super();
		this.numero = numero;
		this.vigenciaInício = vigenciaInício;
		this.vigenciaFim = vigenciaFim;
		this.placaVeiculo = placaVeiculo;
		this.valor = valor;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{numero=").append(numero)
				.append(", vigenciaInício=").append(vigenciaInício)
				.append(", vigenciaFim=").append(vigenciaFim)
				.append(", placaVeiculo=").append(placaVeiculo)
				.append(", valor=").append(valor).append("}");
		return builder.toString();
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
