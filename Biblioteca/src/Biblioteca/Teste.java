package Biblioteca;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Livro crepusculo = new Livro();
		crepusculo.setTitulo("Crepusculo");
		crepusculo.setAutor("Luiz Mata.");
		crepusculo.setAno(2001);
		crepusculo.setEmprestado(false);
		System.out.println("Livro " + crepusculo.getTitulo() + " esta emprestado para o Aluno: " + crepusculo.getAutor());			
	}
}
