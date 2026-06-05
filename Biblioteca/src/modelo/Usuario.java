package modelo;

public class Usuario {
	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	private String dataNascimento;

	public Usuario(String nome, String cpf, String email, String telefone, String dataNascimento) {

		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome.isEmpty()) {
			System.out.println("Erro: O Nome não pode ser vazio");
		} else {
			this.nome = nome;
		}
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		if (cpf.isEmpty()) {
			System.out.println("Erro: O CPF não pode ser vazio");
		} else {
			this.cpf = cpf;
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email.isEmpty()) {
			System.out.println("Erro: O Email não pode ser vazio");
		} else {
			this.email = email;
		}
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		if (telefone.isEmpty()) {
			System.out.println("Erro: O Telefone não pode ser vazio");
		} else {
			this.telefone = telefone;
		}
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}