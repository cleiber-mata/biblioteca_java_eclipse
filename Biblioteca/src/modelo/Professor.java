package modelo;

/**
 * Representa um usuário do tipo Professor no sistema da biblioteca. Herda os
 * atributos e comportamentos da classe pai Usuario, agregando dados específicos
 * do corpo docente, como Disciplina e Registro funcional.
 */
public class Professor extends Usuario {

	private String disciplina;
	private String registro;

	/**
	 * Construtor completo para instanciar um Professor. Repassa as informações
	 * pessoais para a superclasse (Usuario) e inicializa as variáveis de controle
	 * da área de ensino.
	 */
	public Professor(String nome, String cpf, String email, String telefone, String dataNascimento, String disciplina,
			String registro) {
		// Encaminha os dados obrigatórios para o construtor da superclasse
		super(nome, cpf, email, telefone, dataNascimento);
		this.disciplina = disciplina;
		this.registro = registro;
	}
	
	@Override
	public String getTipoUsuario() {
		return "Professor";
	}

	public String getDisciplina() {
		return disciplina;
	}

	/**
	 * Valida e altera a disciplina ministrada pelo professor. Impede a inserção de
	 * valores nulos ou vazios no sistema.
	 */
	public void setDisciplina(String disciplina) {
		// MELHORIA: Adicionada validação de segurança idêntica à de registro
		if (disciplina == null || disciplina.trim().isEmpty()) {
			System.out.println("Erro: A disciplina não pode ser vazia.");
		} else {
			this.disciplina = disciplina;
		}
	}

	public String getRegistro() {
		return registro;
	}

	/**
	 * Valida e altera o número de registro funcional do professor. Garante que a
	 * identificação profissional não seja nula ou vazia.
	 */
	public void setRegistro(String registro) {
		if (registro == null || registro.trim().isEmpty()) {
			System.out.println("Erro: O Registro não pode ser vazio.");
		} else {
			this.registro = registro;
		}
	}
}