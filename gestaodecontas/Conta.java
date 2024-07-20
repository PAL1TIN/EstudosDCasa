package poo.gestaodecontas;

public class Conta {

	private int numero;
	private int senha;
	private Cliente titular;
	private double saldo;
	private HistoricoDeLancamentos historico;

	public Conta(int numero, Cliente titular, int senha, double saldo) {
		this.numero = numero;
		this.titular = titular;
		this.senha = senha;
		this.saldo = saldo;
		this.historico = new HistoricoDeLancamentos(10);

	}

	public int getNumero() {
		return this.numero;
	}
	
	public double getSaldo() {
		return this.saldo;
	}

	public Cliente getTitular() {
		return this.titular;
	}

	public void setTitular(Cliente titular) {
		this.titular = titular;
	}

	public double verificaSaldo(int senha) {
		if (senhaEhValida(senha)) {
			return this.saldo;
		}
		return -1;
	}

	public boolean debitaValor(double valor, int senha, String operacaoBancaria) {
		if (!senhaEhValida(senha) | valor > this.saldo | valor < 0) {
			return false;
		}
		this.saldo -= valor;
		this.historico.insereLancamento(new Lancamento(operacaoBancaria, -valor));
		return true;
	}

	public boolean creditaValor(double valor, String operacaoBancaria) {
		if (valor < 0) {
			return false;
		}
		this.saldo += valor;
		this.historico.insereLancamento(new Lancamento(operacaoBancaria, valor));
		return true;
	}

	private boolean senhaEhValida(int senha) {
		return this.senha == senha;
	}

	public String geraExtrato(int senha) {

		if (this.senhaEhValida(senha)) {
			StringBuilder extrato = new StringBuilder();
			extrato.append(this.historico.geraHistoricoDeLancamentos())
					.append("----------------------")

					.append("\n")

					.append("Saldo atual: R$" + this.saldo)

					.append("\n")

					.append("----------------------");

			return extrato.toString();

		}

		return null;

	}

}
