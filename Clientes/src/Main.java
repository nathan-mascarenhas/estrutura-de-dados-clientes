import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Usuario {
    static int proximoId = 0;
    private int id;
    private String nome;
    private String celular;
    private String cpf;
    private String email;

    public Usuario(String nome, String celular, String cpf, String email) {
        this.id = proximoId++;
        this.nome = nome;
        this.celular = celular;
        this.cpf = cpf;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCelular() {
        return celular;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Celular: " + celular + ", CPF: " + cpf + ", Email: " + email;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Usuario> usuarios = new HashMap<>();

        while (true) {
            System.out.println("\nSistema de Registro de Clientes");
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Buscar usuário por CPF");
            System.out.println("2. Listar todos os usuários");
            System.out.println("3. Cadastrar novo usuário");
            System.out.println("4. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o CPF:");
                    String cpf = scanner.nextLine();
                    boolean encontrado = false;
                    for (Usuario usuario : usuarios.values()) {
                        if (usuario.getCpf().equals(cpf)) {
                            System.out.println("Usuário encontrado: " + usuario);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Usuário não encontrado.");
                    }
                    break;
                case 2:
                    if (usuarios.isEmpty()) {
                        System.out.println("Nenhum usuário cadastrado.");
                    } else {
                        System.out.println("Lista de usuários:");
                        for (Usuario usuario : usuarios.values()) {
                            System.out.println(usuario);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Digite o nome:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o celular:");
                    String celular = scanner.nextLine();
                    System.out.println("Digite o CPF:");
                    String novoCpf = scanner.nextLine();
                    System.out.println("Digite o e-mail:");
                    String email = scanner.nextLine();
                    // Verifica se o CPF já está cadastrado
                    boolean cpfCadastrado = false;
                    for (Usuario usuario : usuarios.values()) {
                        if (usuario.getCpf().equals(novoCpf)) {
                            cpfCadastrado = true;
                            break;
                        }
                    }
                    if (cpfCadastrado) {
                        System.out.println("CPF já cadastrado. Não é possível cadastrar o mesmo CPF novamente.");
                    } else {
                        usuarios.put(Usuario.proximoId, new Usuario(nome, celular, novoCpf, email));
                        System.out.println("Usuário cadastrado com sucesso. ID: " + Usuario.proximoId);
                    }
                    break;
                case 4:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
