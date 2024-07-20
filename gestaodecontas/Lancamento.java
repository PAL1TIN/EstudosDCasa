package poo.gestaodecontas;

public class Lancamento {

	private String descricao;
	private double valor;

	public Lancamento(String descricao, double valor) {
		this.descricao = descricao;
		this.valor = valor;
	}

	public double getValor() {
		return this.valor;
	}

	public String getDescricao() {
		return this.descricao;
	}
}
