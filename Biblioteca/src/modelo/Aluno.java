package modelo;

public class Aluno extends Usuario {
	private String curso;
	private String rgm;

	public Aluno(String nome, String cpf, String email, String telefone, String dataNascimento, String curso, String rgm) {
		super(nome, cpf, email, telefone, dataNascimento);
		this.curso = nome;
		this.rgm = cpf;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		if (curso == null || curso.trim().isEmpty()) {
			System.out.println("Erro: O RGM não pode ser vazio");
		} else {
			this.curso = curso;
		}

	}

	public String getRgm() {
		return rgm;
	}

	public void setRgm(String rgm) {
		if (rgm == null || rgm.trim().isEmpty()) {
			System.out.println("Erro: O RGM não pode ser vazio");
		} else {
			this.rgm = rgm;
		}
	}
}
