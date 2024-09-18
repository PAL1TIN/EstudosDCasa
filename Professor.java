package tarefa;

public class Professor extends Usuario {

	public Professor(String nome) {
		super(nome);
		this.nivelDePrivilegio = 3;
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
		return true;
	}

	public boolean bloqueiaLivro(Livro livro, int prazo) {
		return livro.bloqueia(this, prazo);
	}

	public boolean desbloqueiaLivro(Livro livro) {
		return livro.desbloqueia(this);
	}

	public int getCotaMaxima() {
		return 5;
	}

	public int getPrazoMaximo() {
		return 14;
	}

	public String toString() {
		return "Prof. " + super.getNome();
	}

	public boolean isProfessor() {
		return true;
	}
}