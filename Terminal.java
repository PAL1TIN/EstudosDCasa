package tarefa;

import java.util.Date;
import java.util.Scanner;

public class Terminal {
	private Controle controle;

	public Terminal() {
		controle = new Controle();
	}

	public void menu() {
		Scanner sc = new Scanner(System.in);
		int op = 1;

		while (op != 0) {
			System.out.print("Escolha um modo:\n1. Administrador\n2. Atendimento\n0. Sair\n ");
			op = sc.nextInt();

			switch (op) {
			case 1:
				this.modoAdministrador(sc);
				break;

			case 2:
				this.modoAtendimento();
				break;

			case 0:
				sc.close();
				return;

			default:
				System.out.println("Opção inválida");
			}
		}
	}

	private void mostraItens() {
		System.out.println("Livros: ");
		for (Livro l : this.controle.getLivros()) {
			System.out.println(l.toString());
		}
		System.out.println("Mapas Tematicos:");
		for (MapaTematico p : this.controle.getMapas()) {
			System.out.println(p.toString());
		}
	}

	private void modoAtendimento() {
		int n = 0;
		do {
			System.out.println("Entre como:");
			System.out.println("1. Usuario");
			System.out.println("2. Aluno");
			System.out.println("3. Professor");

			int op = new Scanner(System.in).nextInt();
			switch (op) {
			case 1:
				n = 1;
				this.modoAtendimentoUsuario(new Scanner(System.in));
				break;
			case 2:
				n = 1;
				this.modoAtendimentoAluno(new Scanner(System.in));
				break;
			case 3:
				n = 1;
				this.modoAtendimentoProfessor(new Scanner(System.in));

				break;
			default:
				System.out.println("Digite uma opção valida");
				break;

			}
		} while (n == 0);
	}

	private void modoAdministrador(Scanner scanner) {
		while (true) {
			System.out.println("Administrador:");
			System.out.println("1. Adicionar um Livro");
			System.out.println("2. Adicionar um Mapa");
			System.out.println("3. Listar todos Itens");
			System.out.println("0. Voltar");
			int opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
			case 0:
				return;
			case 1:
				System.out.print("Digite o título do livro: ");
				String tituloLivro = scanner.nextLine();
				this.controle.adicionarLivro(new Livro(tituloLivro));
				break;
			case 2:
				System.out.print("Digite o título do mapa: ");
				String tituloMapa = scanner.nextLine();
				System.out.print("Digite o nivel de privilegio do mapa (1: Usuario; 2: Aluno; 3: Professor): ");
				int privMapa = new Scanner(System.in).nextInt();
				this.controle.adicionarMapaTematico(new MapaTematico(tituloMapa, privMapa));
				break;
			case 3:
				this.mostraItens();
				break;
			default:
				System.out.println("Opção inválida.");
			}
		}

	}

	private void modoAtendimentoUsuario(Scanner scanner) {
		while (true) {

			System.out.println("Atendimento:");
			System.out.println("1. Listar todos Itens");
			System.out.println("2. Retirar um Livro");
			System.out.println("3. Retirar um Mapa");
			System.out.println("4. Devolver um livro");
			System.out.println("5. Devolver um mapa");
			System.out.println("0. Voltar");

			int opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
			case 0:
				return;
			case 1:
				this.mostraItens();
				break;
			case 2:
				System.out.print("Digite o título do livro: ");
				String titulo = scanner.nextLine();
				System.out.print("Qual seu nome: ");
				String nomeUsuario = scanner.nextLine();
				this.controle.adicionarUsuarioExt(new Usuario(nomeUsuario));
				this.controle.emprestarLivro(titulo, this.controle.getUsuario(nomeUsuario));
				break;
			case 3:
				System.out.print("Digite o título do mapa: ");
				String tMapa = scanner.nextLine();
				System.out.print("Qual seu nome: ");
				String nomeUser = scanner.nextLine();
				this.controle.adicionarUsuarioExt(new Usuario(nomeUser));
				this.controle.emprestarMapa(tMapa, this.controle.getUsuario(nomeUser));
				break;
			case 4:
				System.out.print("Digite o título do livro: ");
				String title = scanner.nextLine();
				System.out.print("Qual seu nome: ");
				String nomeUsr = scanner.nextLine();
				if (nomeUsr.equals(this.controle.getLivro(title).getDono().getNome())) {
					this.controle.devolverLivro(title, this.controle.getUsuario(nomeUsr));
				}
				break;
			case 5:
				System.out.print("Digite o título do livro: ");
				String nome = scanner.nextLine();
				System.out.print("Qual seu nome: ");
				String nomeU = scanner.nextLine();
				if (nomeU.equals(this.controle.getMapaTematico(nome).getDono().getNome())) {
					this.controle.devolverMapaTematico(nome, this.controle.getUsuario(nomeU));
				}
				break;
			default:
				System.out.println("Opção inválida.");
			}
		}
	}

	private void modoAtendimentoAluno(Scanner scanner) {
		while (true) {

			System.out.println("Atendimento:");
			System.out.println("1. Listar todos Itens");
			System.out.println("2. Retirar um Livro");
			System.out.println("3. Retirar um Mapa");
			System.out.println("4. Devolver um livro");
			System.out.println("0. Voltar");
			int opcao = scanner.nextInt();
			Date d = new Date(opcao, opcao, opcao);
			scanner.nextLine();

			switch (opcao) {
			case 0:
				return;
			case 1:
				this.mostraItens();
				break;
			case 2:
				System.out.print("Digite o título do livro: ");
				String titulo = scanner.nextLine();
				System.out.print("Qual seu nome: ");
				String nomeUsuario = scanner.nextLine();

				this.controle.adicionarAluno(new Aluno(nomeUsuario, d));
				this.controle.emprestarLivro(titulo, this.controle.getUsuario(nomeUsuario));
				break;
			case 3:
				System.out.print("Digite o título do mapa: ");
				String tMapa = scanner.nextLine();
				System.out.print("Qual seu nome: ");
				String nomeUser = scanner.nextLine();
				this.controle.adicionarAluno(new Aluno(nomeUser, d));
				this.controle.emprestarMapa(tMapa, this.controle.getUsuario(nomeUser));
				break;
			case 4:
				System.out.print("Digite o título do livro: ");
				String title = scanner.nextLine();
				System.out.print("Qual seu nome: ");
				String nomeUsr = scanner.nextLine();
				if (nomeUsr.equals(this.controle.getLivro(title).getDono().getNome())) {
					this.controle.devolverLivro(title, this.controle.getUsuario(nomeUsr));
				}
				break;
			case 5:
				System.out.print("Digite o título do livro: ");
				String nome = scanner.nextLine();
				System.out.print("Qual seu nome: ");
				String nomeU = scanner.nextLine();
				if (nomeU.equals(this.controle.getMapaTematico(nome).getDono().getNome())) {
					this.controle.devolverMapaTematico(nome, this.controle.getUsuario(nomeU));
				}
				break;
			default:
				System.out.println("Opção inválida.");
			}
		}
	}

	private void modoAtendimentoProfessor(Scanner scanner) {
		while (true) {

			System.out.println("Atendimento:");
			System.out.println("1. Listar todos Itens");
			System.out.println("2. Retirar um Livro");
			System.out.println("3. Retirar um Mapa");
			System.out.println("4. Retirar um Periodico");
			System.out.println("5. Bloquear um Livro");
			System.out.println("6. Desbloquear um Livro");
			System.out.println("7. Devolver um livro");
			System.out.println("8. Devolver um mapa");
			System.out.println("0. Voltar");
			int opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
			case 0:
				return;
			case 1:
				this.mostraItens();
				break;
			case 2:
				System.out.print("Digite o título do item: ");
				String titulo = scanner.nextLine();
				System.out.print("Qual seu nome: ");
				String nomeUsuario = scanner.nextLine();
				this.controle.adicionarProfessor(new Professor(nomeUsuario));
				this.controle.emprestarLivro(titulo, this.controle.getUsuario(nomeUsuario));
				break;
			case 3:
				System.out.print("Digite o título do mapa: ");
				String tMapa = scanner.nextLine();
				System.out.print("Qual seu nome: ");
				String nomeUser = scanner.nextLine();
				this.controle.adicionarProfessor(new Professor(nomeUser));
				this.controle.emprestarMapa(tMapa, this.controle.getUsuario(nomeUser));
				break;
			case 4:
				System.out.print("Digite o título do periodico: ");
				String tPer = scanner.nextLine();
				System.out.print("Qual seu nome: ");
				String nomeUsr = scanner.nextLine();
				this.controle.adicionarProfessor(new Professor(nomeUsr));
				this.controle.emprestarPer(tPer, this.controle.getProfessor(nomeUsr));
				break;
			case 5:
				System.out.print("Qual o título do livro a ser bloqueado: ");
				String tLiv = scanner.nextLine();
				System.out.print("Qual seu nome: ");
				String nomeU = scanner.nextLine();
				System.out.println("Qual o prazo para o desbloqueio do livro: ");
				int prazo = new Scanner(System.in).nextInt();
				this.controle.adicionarProfessor(new Professor(nomeU));
				this.controle.bloqueiaLivro(this.controle.getProfessor(nomeU), tLiv, prazo);
				break;
			case 6:
				System.out.print("Qual o título do livro a ser desbloqueado: ");
				String tLv = scanner.nextLine();
				System.out.print("Qual seu nome: ");
				String nameU = scanner.nextLine();
				if (this.controle.getProfessor(nameU) != null) {
					if (nameU.equals(this.controle.getLivro(tLv).getBloqueador().getNome())) {
						this.controle.desbloqueiaLivro(this.controle.getProfessor(nameU), tLv);
					} else {
						System.out.println("Nome inválido");
					}
				} else {
					System.out.println("Professor nao encontrado");
				}

				break;
			case 7:
				System.out.print("Digite o título do livro: ");
				String title = scanner.nextLine();
				System.out.print("Qual seu nome: ");
				String nomeUsur = scanner.nextLine();
				if (nomeUsur.equals(this.controle.getLivro(title).getDono().getNome())) {
					this.controle.devolverLivro(title, this.controle.getUsuario(nomeUsur));
				}
				break;
			case 8:
				System.out.print("Digite o título do livro: ");
				String nome = scanner.nextLine();
				System.out.print("Qual seu nome: ");
				String nomeUs = scanner.nextLine();
				if (nomeUs.equals(this.controle.getMapaTematico(nome).getDono().getNome())) {
					this.controle.devolverMapaTematico(nome, this.controle.getUsuario(nomeUs));
				}
				break;
			case 9:
				System.out.print("Digite o título do periodico: ");
				String name = scanner.nextLine();
				System.out.print("Qual seu nome: ");
				String nomeUr = scanner.nextLine();
				if (nomeUr.equals(this.controle.getLivro(name).getDono().getNome())) {
					this.controle.devolverLivro(name, this.controle.getUsuario(nomeUr));
				}
				break;

			default:
				System.out.println("Opção inválida.");
			}
		}

	}
}