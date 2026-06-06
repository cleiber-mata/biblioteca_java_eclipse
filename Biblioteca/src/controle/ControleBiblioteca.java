package controle;

import java.util.ArrayList;

import modelo.Aluno;
import modelo.Emprestimo;
import modelo.Livro;
import modelo.Professor;
import modelo.Usuario;

/**
 * Classe controladora responsável por gerenciar as operações de negócio da biblioteca.
 * Atua como intermediária entre a interface e o modelo, gerenciando os acervos de 
 * livros, usuários e o histórico de empréstimos em memória.
 */
public class ControleBiblioteca {

	private ArrayList<Livro> livros = new ArrayList<>();
	private ArrayList<Usuario> usuarios = new ArrayList<>();
	private ArrayList<Emprestimo> emprestimos = new ArrayList<>();

	/**
	 * [MELHORIA 2 IMPLEMENTADA] 
	 * Registra um novo livro no acervo, impedindo duplicidade pelo ISBN.
	 */
	public void cadastrarLivro(Livro livro) {
		if (livro == null) {
			System.out.println("Erro: Livro inválido.");
			return;
		}
		
		// Verifica se o ISBN já existe no acervo antes de adicionar
		if (buscarLivroPorIsbn(livro.getIsbn()) != null) {
			System.out.println("Erro: Já existe um livro cadastrado com o ISBN " + livro.getIsbn() + ".");
			return;
		}

		livros.add(livro);
		System.out.println("Livro '" + livro.getTitulo() + "' cadastrado com sucesso.");
	}

	/**
	 * [MELHORIA 2 IMPLEMENTADA]
	 * Registra um novo usuário no sistema, impedindo duplicidade pelo CPF.
	 */
	public void cadastrarUsuario(Usuario usuario) {
		if (usuario == null) {
			System.out.println("Erro: Usuário inválido.");
			return;
		}

		// Verifica se o CPF já está cadastrado antes de adicionar
		if (buscarUsuarioPorCpf(usuario.getCpf()) != null) {
			System.out.println("Erro: Já existe um usuário cadastrado com o CPF " + usuario.getCpf() + ".");
			return;
		}

		usuarios.add(usuario);
		System.out.println("Usuário '" + usuario.getNome() + "' cadastrado com sucesso.");
	}

	public void listarLivros() {
		if (livros.isEmpty()) {
			System.out.println("Nenhum livro cadastrado.");
			return;
		}

		for (Livro livro : livros) {
			System.out.println(livro);
		}
	}
	
	public Livro buscarLivroPorId(int idLivro) {
	    for (Livro livro : livros) {
	        if (livro.getIdLivro() == idLivro) {
	            return livro;
	        }
	    }
	    return null;
	}

	public Livro buscarLivroPorIsbn(String isbn) {
		for (Livro livro : livros) {
			if (livro.getIsbn().equals(isbn)) {
				return livro;
			}
		}
		return null;
	}

	public Usuario buscarUsuarioPorCpf(String cpf) {
		for (Usuario usuario : usuarios) {
			if (usuario.getCpf().equals(cpf)) {
				return usuario;
			}
		}
		return null;
	}

	public void consultarDisponibilidade(String isbn) {
		Livro livro = buscarLivroPorIsbn(isbn);

		if (livro == null) {
			System.out.println("Livro não encontrado.");
		} else if (livro.isEmprestado()) {
			System.out.println("Livro está emprestado.");
		} else {
			System.out.println("Livro disponível.");
		}
	}

	/**
	 * Regra de Negócio: Coordena o processo de locação de um exemplar.
	 * [MELHORIA 3] Utiliza polimorfismo para identificar dinamicamente as 
	 * regras de prazo de devolução com base no tipo de usuário (Aluno/Professor).
	 */
	public void realizarEmprestimo(String cpf, String isbn) {
		Usuario usuario = buscarUsuarioPorCpf(cpf);
		Livro livro = buscarLivroPorIsbn(isbn);

		if (usuario == null) {
			System.out.println("Usuário não encontrado.");
			return;
		}

		if (livro == null) {
			System.out.println("Livro não encontrado.");
			return; // (Ajustado o bug do return que você já tinha corrigido)
		}

		if (livro.isEmprestado()) {
			System.out.println("Livro já está emprestado.");
			return;
		}

		// [MELHORIA 3 IMPLEMENTADA] Lógica Polimórfica para exibição do prazo
		int prazoDias = 7; // Prazo padrão genérico
		String tipoUsuario = "Usuário Comum";

		if (usuario instanceof Aluno) {
			prazoDias = 7;  // Regra para Alunos
			tipoUsuario = "Aluno";
		} else if (usuario instanceof Professor) {
			prazoDias = 14; // Regra diferenciada para Professores
			tipoUsuario = "Professor";
		}

		Emprestimo emprestimo = new Emprestimo(usuario, livro);
		emprestimos.add(emprestimo);

		System.out.println("Empréstimo realizado com sucesso para " + tipoUsuario + ": " + usuario.getNome());
		System.out.println("Número do empréstimo: " + emprestimo.getNumeroEmprestimo());
		System.out.println("Prazo de devolução: " + prazoDias + " dias (Data limite: " + emprestimo.getDataEmprestimo().plusDays(prazoDias) + ")");
	}

	public void devolverLivro(int numeroEmprestimo) {
		for (Emprestimo emprestimo : emprestimos) {
			if (emprestimo.getNumeroEmprestimo() == numeroEmprestimo) {
				emprestimo.finalizarEmprestimo();
				System.out.println("Devolução realizada com sucesso.");
				return;
			}
		}

		System.out.println("Empréstimo não encontrado.");
	}

	public void listarUsuarios() {
		if (usuarios.isEmpty()) {
			System.out.println("Nenhum usuário cadastrado.");
			return;
		}

		for (Usuario usuario : usuarios) {
			System.out.println(usuario);
		}
	}

	public void listarEmprestimos() {
		if (emprestimos.isEmpty()) {
			System.out.println("Nenhum empréstimo cadastrado.");
			return;
		}

		for (Emprestimo emprestimo : emprestimos) {
			System.out.println("Empréstimo nº " + emprestimo.getNumeroEmprestimo()
					+ " | Usuário: " + emprestimo.getUsuario().getNome()
					+ " | Livro: " + emprestimo.getLivro().getTitulo()
					+ " | Data: " + emprestimo.getDataEmprestimo()
					+ " | Ativo: " + emprestimo.isStatus());
		}
	}
}