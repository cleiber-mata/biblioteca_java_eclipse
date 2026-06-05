package modelo;

import java.time.LocalDate;

/**
 * Representa o empréstimo de um livro por um usuário no sistema da biblioteca.
 * Modela a associação entre as classes Usuario e Livro, gerenciando o ciclo de
 * vida da transação e garantindo a consistência dos estados dos objetos
 * envolvidos. * @author Seu Nome / Grupo
 */
public class Emprestimo {

	/**
	 * Controle estático para geração de identificadores únicos e sequenciais para
	 * cada instância de Emprestimo criada no sistema.
	 */
	private static int proximoNumero = 1;

	private int numeroEmprestimo;
	private Usuario usuario;
	private Livro livro;
	private LocalDate dataEmprestimo;

	/**
	 * Define a situação atual do empréstimo: true para ativo (livro em posse do
	 * usuário) e false para finalizado (livro devolvido).
	 */
	private boolean status;

	/**
	 * Construtor que inicializa e valida um novo empréstimo. Aplica restrições de
	 * integridade para impedir objetos inconsistentes (nulos) e altera
	 * automaticamente o estado do livro para "emprestado". * @param usuario O
	 * beneficiário do empréstimo (não pode ser nulo).
	 * 
	 * @param livro O exemplar a ser retirado (não pode ser nulo).
	 * @throws IllegalArgumentException se o usuário ou o livro forem nulos.
	 */
	public Emprestimo(Usuario usuario, Livro livro) {
		if (usuario == null) {
			throw new IllegalArgumentException("Não é possível criar um empréstimo sem um usuário válido.");
		}
		if (livro == null) {
			throw new IllegalArgumentException("Não é possível criar um empréstimo sem um livro válido.");
		}
		this.numeroEmprestimo = proximoNumero++;
		this.usuario = usuario;
		this.livro = livro;
		this.dataEmprestimo = LocalDate.now();
		this.status = true;
		this.livro.setEmprestado(true);
	}

	public int getNumeroEmprestimo() {
		return numeroEmprestimo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Livro getLivro() {
		return livro;
	}

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * Regra de Negócio: Finaliza o empréstimo ativo. Modifica o estado do
	 * empréstimo para inativo e atualiza a disponibilidade do livro associado,
	 * tornando-o disponível novamente na biblioteca.
	 */
	public void finalizarEmprestimo() {
		if (!status) {
			System.out.println("Empréstimo já foi finalizado.");
		} else {
			this.status = false;
			this.livro.setEmprestado(false);
		}
	}
}