package tarefa;

public class Periodico extends Livro {
	public Periodico(String tit) {
		super(tit);
	}

	public boolean empresta(Usuario u, int prazo) {
		if (u.isProfessor()) {
			return super.empresta(u, 7);

		} else {
			return false;
		}
	}
}