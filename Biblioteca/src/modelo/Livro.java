package modelo;
import java.time.LocalDate;

/**
 * Representa um livro no acervo da biblioteca.
 * Encapsula os dados físicos e de catalogação do exemplar, além de controlar
 * o seu estado de disponibilidade para empréstimos.
 */
public class Livro {
	private static int proximoId = 1;
	private int idLivro;
	private String titulo;
	private String autor;
	private String isbn;
	private int ano;
	private String editora;
	
	/**
	 * Estado de disponibilidade do livro: true se estiver alocado em um 
	 * empréstimo ativo, false se estiver disponível nas prateleiras.
	 */
	private boolean emprestado;
	
	/**
	 * Construtor completo para catalogação de um novo livro no acervo.
	 * [AJUSTE DE POO] O parâmetro redundante de status foi removido; 
	 * por regra de negócio, todo livro inicia sua existência como disponível (false).
	 */
	public Livro(String titulo, String autor, String isbn, int ano, String editora) {
		this.idLivro = proximoId++;
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.ano = ano;
		this.editora = editora;
		this.emprestado = false; // Inicialização lógica padrão
	}
	
	@Override
	public String toString() {
		return String.format(
			    "ID: %-3d | ISBN: %-15s | Título: %-30s | Autor: %-25s | Ano: %-4d | Status: %s",
			    idLivro, isbn, titulo, autor, ano,
			    emprestado ? "Emprestado" : "Disponível"
			);
	}
	
	public int getIdLivro() {
	    return idLivro;
	}

	public String getTitulo() {
		return titulo;
	}

	/**
	 * Valida e altera o título do livro.
	 * Impede que a obra fique com identificação em branco.
	 */
	public void setTitulo(String titulo) {
		if (titulo == null || titulo.trim().isEmpty()) {
			System.out.println("Erro: O título não pode ser vazio.");
		} else {
			this.titulo = titulo;
		}
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getAno() {
		return ano;
	}

	/**
	 * Valida o ano de publicação da obra com base no calendário histórico 
	 * da imprensa e no ano corrente do sistema.
	 */
	public void setAno(int ano) {
		int anoAtual = LocalDate.now().getYear();
		if (ano < 1800 ||  ano > anoAtual) {
			System.out.println("Digite um ano válido (entre 1800 e " + anoAtual + ").");
		} else {
			this.ano = ano;
		}
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public boolean isEmprestado() {
		return emprestado;
	}

	public void setEmprestado(boolean emprestado) {
		this.emprestado = emprestado;
	}
}