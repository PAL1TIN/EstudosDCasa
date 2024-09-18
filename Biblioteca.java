package tarefa;

import java.util.ArrayList;

public class Biblioteca {
	private ArrayList<Livro> livros;
	private ArrayList<Usuario> usuarios;
	private ArrayList<MapaTematico> mapasTematicos;

	public Biblioteca() {
		livros = new ArrayList<Livro>();
		usuarios = new ArrayList<Usuario>();
		mapasTematicos = new ArrayList<MapaTematico>();
	}

	public void adicionarLivro(Livro livro) {
		livros.add(livro);
	}

	public void removerLivro(Livro livro) {
		livros.remove(livro);
	}

	public void adicionarUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}

	public void removerUsuario(Usuario usuario) {
		usuarios.remove(usuario);
	}

	public void adicionarMapaTematico(MapaTematico mapa) {
		mapasTematicos.add(mapa);
	}

	public void removerMapaTematico(MapaTematico mapa) {
		mapasTematicos.remove(mapa);
	}

	public boolean emprestaLivro(String titulo, Usuario usuario) {
		for (Livro livro : livros) {
			if (livro.getTitulo().equals(titulo)) {
				return livro.empresta(usuario, 0);
			}
		}
		return false;
	}

	public boolean devolveLivro(String titulo, Usuario usuario) {
		for (Livro livro : livros) {
			if (livro.getTitulo().equals(titulo)) {
				return livro.retorna(usuario);
			}
		}
		return false;
	}

	public boolean emprestaMapaTematico(String titulo, Usuario usuario) {
		for (MapaTematico mapa : mapasTematicos) {
			if (mapa.getTitulo().equals(titulo)) {
				return mapa.empresta(usuario, 0);
			}
		}
		return false;
	}

	public boolean devolveMapaTematico(String titulo, Usuario usuario) {
		for (MapaTematico mapa : mapasTematicos) {
			if (mapa.getTitulo().equals(titulo)) {
				return mapa.retorna(usuario);
			}
		}
		return false;
	}

	public Usuario getUsuario(String nome) {
		for (Usuario usuario : usuarios) {
			if (usuario.getNome().equals(nome)) {
				return usuario;
			}
		}
		return null;
	}

	public Livro getLivro(String titulo) {
		for (Livro livro : livros) {
			if (livro.getTitulo().equals(titulo)) {
				return livro;
			}
		}
		return null;
	}

	public MapaTematico getMapaTematico(String titulo) {
		for (MapaTematico mapa : mapasTematicos) {
			if (mapa.getTitulo().equals(titulo)) {
				return mapa;
			}
		}
		return null;
	}

	public void mostrarStatus(String titulo) {
		Livro livro = getLivro(titulo);
		if (livro != null) {
			System.out.println(livro);
			return;
		}

		MapaTematico mapa = getMapaTematico(titulo);
		if (mapa != null) {
			System.out.println(mapa);
			return;
		}

		System.out.println("Item nao encontrado");
	}
}
