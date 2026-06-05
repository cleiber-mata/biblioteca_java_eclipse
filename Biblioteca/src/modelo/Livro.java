package modelo;

public class Livro {
	private String titulo;
	private String autor;
	private int ano;
	private boolean emprestado;


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
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		if (ano <= 1850) {
			System.out.println("Digite um ano valido.");
		} else {
		this.ano = ano;
		}
	}
	public boolean isEmprestado() {
		return emprestado;
	}
	public void setEmprestado(boolean emprestado) {
		this.emprestado = emprestado;
	}
}
