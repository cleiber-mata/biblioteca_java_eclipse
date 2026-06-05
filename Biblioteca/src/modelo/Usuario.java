package modelo;

public class Usuario {
	private static int proximoId = 1;
	private int idUsuario;
	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	private String dataNascimento;

	public Usuario(String nome, String cpf, String email, String telefone, String dataNascimento) {
		// Validação rigorosa contra campos em branco ou cheios de espaços
				if (nome == null || nome.trim().isEmpty()) {
					throw new IllegalArgumentException("Erro: O nome do usuário não pode ser vazio.");
				}
				if (cpf == null || cpf.trim().isEmpty()) {
					throw new IllegalArgumentException("Erro: O CPF do usuário não pode ser vazio.");
				}
		this.idUsuario = proximoId++;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
	}
	
	@Override
	public String toString() {
	    return String.format(
	        "ID: %-10s | Nome: %-30s | CPF: %-14s | Email: %-30s | Telefone: %-15s",
	        idUsuario, nome, cpf, email, telefone
	    );
	}
	
	public int getIdUsuario() {
		return idUsuario;
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
	
	public String getTipoUsuario() {
		return "Usuário";
	}
}