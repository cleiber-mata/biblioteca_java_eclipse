package principal;

import java.util.Scanner;
import controle.ControleBiblioteca;
import modelo.Aluno;
import modelo.Livro;
import modelo.Professor;

/**
 * Classe principal da aplicação que gerencia a interface textual com o usuário.
 * Orquestra o fluxo de execução do sistema por meio de uma estrutura de menu
 * iterativa, utilizando a classe Scanner para capturas via console e aplicando
 * um mecanismo robusto de tratamento de exceções (try/catch) para garantir a
 * tolerância a falhas.
 */
public class Main {

	public static void main(String[] args) {

		// Instanciação do controlador que centraliza as regras de negócio do domínio.
		ControleBiblioteca controle = new ControleBiblioteca();

		// Canal de fluxo de entrada para captura dos dados digitados no teclado.
		Scanner teclado = new Scanner(System.in);

		int opcao = -1;

		// Inicialização de massa de dados em memória para otimização dos testes
		// práticos.
		inicializarDadosTeste(controle);

		while (opcao != 0) {
			System.out.println("\n==================================================");
			System.out.println("          SISTEMA DE BIBLIOTECA ACADÊMICA         ");
			System.out.println("==================================================");
			System.out.println("1 - Cadastrar Aluno");
			System.out.println("2 - Cadastrar Professor");
			System.out.println("3 - Cadastrar Livro");
			System.out.println("4 - Consultar Disponibilidade de Livro");
			System.out.println("5 - Realizar Empréstimo");
			System.out.println("6 - Devolver Livro");
			System.out.println("7 - Listar Todos os Livros");
			System.out.println("8 - Listar Todos os Usuários");
			System.out.println("9 - Relatório de Empréstimos");
			System.out.println("0 - Sair do Sistema");
			System.out.println("==================================================");
			System.out.print("Escolha uma opção: ");

			// Bloco de controle global: protege toda a operação do menu contra interrupções
			// abruptas (crashes).
			try {
				opcao = Integer.parseInt(teclado.nextLine());
				System.out.println();

				switch (opcao) {
				case 1:
					System.out.println("--- Cadastro de Aluno ---");
					System.out.print("Nome: ");
					String nomeA = teclado.nextLine();
					System.out.print("CPF: ");
					String cpfA = teclado.nextLine();
					System.out.print("Email: ");
					String emailA = teclado.nextLine();
					System.out.print("Telefone: ");
					String telA = teclado.nextLine();
					System.out.print("Data Nasc. (dd/mm/aaaa): ");
					String dataA = teclado.nextLine();
					System.out.print("Curso: ");
					String curso = teclado.nextLine();
					System.out.print("RGM: ");
					String rgm = teclado.nextLine();

					// Instanciação e envio ao controlador; validações de campos vazios disparam
					// IllegalArgumentException
					controle.cadastrarUsuario(new Aluno(nomeA, cpfA, emailA, telA, dataA, curso, rgm));
					break;

				case 2:
					System.out.println("--- Cadastro de Professor ---");
					System.out.print("Nome: ");
					String nomeP = teclado.nextLine();
					System.out.print("CPF: ");
					String cpfP = teclado.nextLine();
					System.out.print("Email: ");
					String emailP = teclado.nextLine();
					System.out.print("Telefone: ");
					String telP = teclado.nextLine();
					System.out.print("Data Nasc. (dd/mm/aaaa): ");
					String dataP = teclado.nextLine();
					System.out.print("Disciplina: ");
					String disciplina = teclado.nextLine();
					System.out.print("Registro Funcional: ");
					String registro = teclado.nextLine();

					controle.cadastrarUsuario(new Professor(nomeP, cpfP, emailP, telP, dataP, disciplina, registro));
					break;

				case 3:
					System.out.println("--- Cadastro de Livro ---");
					System.out.print("Título: ");
					String titulo = teclado.nextLine();
					System.out.print("Autor: ");
					String autor = teclado.nextLine();
					System.out.print("ISBN: ");
					String isbn = teclado.nextLine();
					System.out.print("Ano de Publicação: ");
					int ano = Integer.parseInt(teclado.nextLine());
					System.out.print("Editora: ");
					String editora = teclado.nextLine();

					controle.cadastrarLivro(new Livro(titulo, autor, isbn, ano, editora));
					break;

				case 4:
					System.out.println("--- Consultar Disponibilidade ---");
					System.out.print("Digite o ISBN do livro: ");
					String isbnCons = teclado.nextLine();
					controle.consultarDisponibilidade(isbnCons);
					break;

				case 5:
					System.out.println("--- Realizar Empréstimo ---");
					System.out.print("Digite o CPF do usuário: ");
					String cpfEmp = teclado.nextLine();
					System.out.print("Digite o ISBN do livro: ");
					String isbnEmp = teclado.nextLine();
					controle.realizarEmprestimo(cpfEmp, isbnEmp);
					break;

				case 6:
					System.out.println("--- Devolver Livro ---");
					System.out.print("Digite o número do empréstimo: ");
					int numEmp = Integer.parseInt(teclado.nextLine());
					controle.devolverLivro(numEmp);
					break;

				case 7:
					System.out.println("--- Acervo de Livros ---");
					controle.listarLivros();
					break;

				case 8:
					System.out.println("--- Usuários Cadastrados ---");
					controle.listarUsuarios();
					break;

				case 9:
					System.out.println("--- Relatório de Transações Ativas ---");
					controle.listarEmprestimos();
					break;

				case 0:
					System.out.println("Encerrando o sistema da biblioteca. Missão cumprida!");
					break;

				default:
					System.out.println("Opção inválida! Tente novamente.");
				}

			} catch (NumberFormatException e) {
				// Captura falhas de conversão de tipos (ex: digitar letras no menu ou no ano do
				// livro)
				System.out.println("\n[ERRO DE SISTEMA] Entrada inválida! Digite apenas números nos campos numéricos.");
			} catch (IllegalArgumentException e) {
				// Captura violações de regras de integridade lançadas pelo modelo (campos
				// obrigatórios nulos/vazios)
				System.out.println("\n[AVISO DE SEGURANÇA] " + e.getMessage());
				System.out.println("Operação cancelada. Retornando ao menu principal de forma segura...");
			} catch (Exception e) {
				// Captura genérica de contingência para qualquer outra falha imprevista,
				// mantendo a JVM ativa
				System.out.println("\n[ERRO INESPERADO] Ocorreu uma inconsistência: " + e.getMessage());
			}
		}

		teclado.close();
	}

	/**
	 * Método auxiliar responsável por alimentar o sistema com dados iniciais.
	 * Facilita a apresentação e os testes, evitando a necessidade de cadastrar
	 * usuários e livros manualmente toda vez que o programa for executado.
	 */
	private static void inicializarDadosTeste(ControleBiblioteca controle) {
		Aluno a = new Aluno("Andre Luiz da Siva", "111.222.333-44", "andre.luiz@gmail.com", "6199999", "01/01/1980",
				"Sistemas de Informação", "RGM001");

		Professor p = new Professor("Aline Silva", "555.666.777-88", "aline@udf.edu.br", "6198888", "12/05/1985", "POO",
				"REG99");

		Livro l1 = new Livro("Java: Como Programar", "Deitel", "111", 2021, "Pearson");
		Livro l2 = new Livro("Clean Code", "Robert Martin", "222", 2009, "Alta Books");

		controle.cadastrarUsuario(a);
		controle.cadastrarUsuario(p);
		controle.cadastrarLivro(l1);
		controle.cadastrarLivro(l2);
	}
}