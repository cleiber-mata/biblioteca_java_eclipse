package modelo;

/**
 * Representa um usuário do tipo Aluno no sistema da biblioteca. Herda os
 * atributos e comportamentos da classe pai Usuario, adicionando as
 * especificidades acadêmicas como Curso e RGM.
 */
public class Aluno extends Usuario {

	private String curso;
	private String rgm;

	/**
	 * Construtor completo para instanciar um Aluno. Repassa os dados pessoais para
	 * a classe pai (Usuario) e inicializa os atributos educacionais específicos.
	 */
	public Aluno(String nome, String cpf, String email, String telefone, String dataNascimento, String curso,
			String rgm) {
		// Encaminha os dados obrigatórios para o construtor da superclasse
		super(nome, cpf, email, telefone, dataNascimento);

		// CORREÇÃO: Agora salvando as variáveis corretas recebidas nos parâmetros
		this.curso = curso;
		this.rgm = rgm;
	}
	
	@Override
	public String getTipoUsuario() {
		return "Aluno";
	}

	public String getCurso() {
		return curso;
	}

	/**
	 * Valida e altera o curso do aluno. Garante que o campo não seja nulo ou vazio.
	 */
	public void setCurso(String curso) {
		if (curso == null || curso.trim().isEmpty()) {
			// CORREÇÃO: Mensagem corrigida para refletir o atributo correto (Curso)
			System.out.println("Erro: O curso não pode ser vazio.");
		} else {
			this.curso = curso;
		}
	}

	public String getRgm() {
		return rgm;
	}

	/**
	 * Valida e altera o RGM do aluno. Garante que o identificador acadêmico não
	 * seja nulo ou vazio.
	 */
	public void setRgm(String rgm) {
		if (rgm == null || rgm.trim().isEmpty()) {
			System.out.println("Erro: O RGM não pode ser vazio.");
		} else {
			this.rgm = rgm;
		}
	}
}