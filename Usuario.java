package tarefa;

import java.util.ArrayList;

public class Usuario {
	private String nome;
	protected int nivelDePrivilegio;
	protected ArrayList<Item> itensRetirados;

	public Usuario(String nome) {
		this.nome = nome;
		this.nivelDePrivilegio = 1;
		this.itensRetirados = new ArrayList<Item>();
	}

	public String getNome() {
		return nome;
	}

	public boolean retiraItem(Item it) {

		if (it.isDisponivel()) {
			it.empresta(this, getPrazoMaximo());
			this.itensRetirados.add(it);
			return true;
		}
		return false;
	}

	public boolean devolveItem(Item it) {
		this.itensRetirados.remove(it);
		it.retorna(this);
		return true;
	}

	public int getCotaMaxima() {
		return 2;
	}

	public int getPrazoMaximo() {
		return 4;
	}

	public boolean isADevolver() {
		return ((this.itensRetirados.size() >= this.getCotaMaxima() || this.temPrazoVencido()) ? true : false);
	}

	public boolean isAptoARetirar() {
		return (!this.isADevolver());
	}

	public boolean temPrazoVencido() {
		for (Item item : this.itensRetirados) {
			if (item.isEmAtraso()) {
				return true;
			}

		}
		return false;
	}

	public boolean isProfessor() {
		return false;
	}

	public String toString() {
		return "Usuario " + nome;
	}

	public String listaCarga() {
		StringBuilder carga = new StringBuilder();
		carga.append(this.toString()).append(" Limite: ").append(this.getCotaMaxima()).append(" Carga atual: ")
				.append(this.itensRetirados.size());
		for (Item item : this.itensRetirados) {
			carga.append(item.toString()).append("\n");
		}
		return carga.toString();
	}

	public int getNivelPriv() {
		return this.nivelDePrivilegio;
	}

	public ArrayList<Item> getItens() {
		return this.itensRetirados;
	}
}