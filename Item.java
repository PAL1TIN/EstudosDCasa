package tarefa;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class Item {
	protected Usuario retiradoPor;
	protected Date dtEmprestimo;
	protected Date dtDevolucao;
	protected String titulo;
	protected String state;

	public Item(String nome) {
		this.titulo = nome;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public Usuario getDono() {
		return this.retiradoPor;
	}

	public boolean empresta(Usuario u, int prazo) {
		GregorianCalendar cal = new GregorianCalendar();
		if (this.isDisponivel()) {
			this.retiradoPor = u;
			this.dtEmprestimo = cal.getTime();
			cal.add(Calendar.DATE, prazo);

			this.dtDevolucao = cal.getTime();
			return true;
		}
		return false;
	}

	public boolean retorna(Usuario u) {
		if (u == this.retiradoPor) {
			this.retiradoPor = null;
			return true;
		}
		return false;
	}

	public boolean isDisponivel() {
		return this.retiradoPor == null;

	}

	public boolean isEmprestado() {
		return !(this.retiradoPor == null);
	}

	public boolean isEmAtraso() {
		Date hoje = new Date();
		if ((this.dtDevolucao.before(hoje) && (this.retiradoPor != null))) {
			return true;

		}
		return false;
	}

	public String toString() {
		if (this.isDisponivel()) {
			return this.titulo + " (disponivel)";
		}
		state = this.titulo + " (retirado por " + this.retiradoPor + " em " + dma(this.dtEmprestimo) + " ate "
				+ dma(this.dtDevolucao) + ")";
		return state;

	}

	protected String dma(Date dt) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(dt);
		return cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR);
	}

}