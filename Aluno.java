package tarefa;

import java.util.*;

public class Aluno extends Usuario {
	private Date dataLimite;

	public Aluno(String nome, Date dt) {
		super(nome);
		this.dataLimite = dt;
	}

	public void renovaCartao(Date dt) {
		this.dataLimite = dt;
	}

	public boolean isRegular() {
		Date hoje = new Date();
		return dataLimite.after(hoje);
	}

	public boolean isARenovar() {
		return !isRegular();
	}

	public String toString() {
		return "Aluno:" + this.getNome();
	}

	public int getCotaMaxima() {
		if (isRegular()) {
			return 3;
		}

		return super.getCotaMaxima();
	}

	public int getPrazoMaximo() {
		if (isRegular()) {
			return 7;
		}

		return super.getPrazoMaximo();
	}

}