package q2_LucasComaru;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginSystem {
    private static final String FILE_PATH = "users.txt";
    private Map<String, String> users;

    public LoginSystem() {
        this.users = new HashMap<>();
        loadUsers();
    }

    private void loadUsers() {
        try (Scanner scanner = new Scanner(new File(FILE_PATH))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String username = parts[0];
                    String password = parts[1];
                    users.put(username, password);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de usuários não encontrado. Será criado ao salvar.");
        }
    }

    private void saveUsers() {
        try (PrintWriter writer = new PrintWriter(FILE_PATH)) {
            for (Map.Entry<String, String> entry : users.entrySet()) {
                writer.println(entry.getKey() + ":" + entry.getValue());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Erro ao salvar usuários.");
        }
    }

    public void registerUser(String username, String password) {
        users.put(username, password);
        saveUsers();
    }

    public boolean loginUser(String username, String password) {
        String storedPassword = users.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }

    public static void main(String[] args) {
        LoginSystem loginSystem = new LoginSystem();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite 1 para cadastrar um novo usuário, 2 para fazer login: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.print("Digite o nome de usuário: ");
            String username = scanner.nextLine();
            System.out.print("Digite a senha: ");
            String password = scanner.nextLine();
            loginSystem.registerUser(username, password);
            System.out.println("Usuário cadastrado com sucesso!");
        } else if (choice == 2) {
            System.out.print("Digite o nome de usuário: ");
            String username = scanner.nextLine();
            System.out.print("Digite a senha: ");
            String password = scanner.nextLine();
            if (loginSystem.loginUser(username, password)) {
                System.out.println("SUCESSO: Login bem-sucedido!");
            } else {
                System.out.println("FRACASSO: Nome de usuário ou senha incorretos.");
            }
        } else {
            System.out.println("Escolha inválida.");
        }

        scanner.close();
    }
}
