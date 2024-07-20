package poo.gestaodecontas;

public class HistoricoDeLancamentos {

	private Lancamento[] lancamento;
	private int ultimoLancamento;

	public HistoricoDeLancamentos(int numeroDeLancamentos) {
		this.lancamento = new Lancamento[numeroDeLancamentos + 1];
	}

	public void insereLancamento(Lancamento lancamento) {
		if (this.ultimoLancamento == this.lancamento.length) {
			for (int i = 1; i < this.lancamento.length; i++) {
				this.lancamento[i] = this.lancamento[i + 1];

			}
		}

		else {
			this.ultimoLancamento++;
		}
		this.lancamento[this.ultimoLancamento] = lancamento;
	}

	public String geraHistoricoDeLancamentos() {
		StringBuilder historico = new StringBuilder();
		for (int i = 1; i <= this.ultimoLancamento; i++) {
			historico.append(this.lancamento[i].getDescricao()).append(": R$").append(this.lancamento[i].getValor())
					.append("\n");
		}
		return historico.toString();

	}
}