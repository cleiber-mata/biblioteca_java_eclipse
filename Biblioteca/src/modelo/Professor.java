package modelo;

	
public class Professor extends Usuario {
	private String disciplina;
	private String registro;
	
	
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		if (registro == null || registro.trim().isEmpty()) {
			System.out.println("Erro: O Registro não pode ser vazio");
		} else {
		this.registro = registro;
		}
	}	
}