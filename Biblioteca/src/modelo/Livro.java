package modelo;
import java.time.LocalDate;

public class Livro {
	private String titulo;
	private String autor;
	private String isbn;
	private int ano;
	private String editora;
	private boolean emprestado;
	
	public Livro(String titulo, String autor, String isbn, int ano, String editora, boolean emprestado) {

		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.ano = ano;
		this.editora = editora;
		this.emprestado = false;
	}


	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		if (titulo.isEmpty()) {
			System.out.println("Erro: O título não pode ser vazio");
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
	public void setAno(int ano) {
		int anoAtual = LocalDate.now().getYear();
		if (ano < 1800 ||  ano > anoAtual) {
			System.out.println("Digite um ano valido.");
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
