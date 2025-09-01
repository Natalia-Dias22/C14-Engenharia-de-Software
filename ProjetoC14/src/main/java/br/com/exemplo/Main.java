package br.com.exemplo;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import com.google.gson.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Pessoa> pessoas = new ArrayList<>();
        PessoaService service = new PessoaService();

        System.out.print("Quantas pessoas deseja cadastrar? ");
        int qtd = sc.nextInt();
        sc.nextLine(); // limpar buffer

        for (int i = 0; i < qtd; i++) {
            System.out.println("\nPessoa " + (i + 1) + ":");

            // Lê o nome
            System.out.print("Nome: ");
            String nome = sc.nextLine();

            // Lê a idade com validação
            int idade;
            do {
                System.out.print("Idade: ");
                idade = sc.nextInt();
                sc.nextLine(); // limpar buffer
                if (idade < 0) {
                    System.out.println("Idade inválida! Digite um valor maior ou igual a 0.");
                }
            } while (idade < 0);

            // Adiciona a pessoa à lista
            pessoa.add(new Pessoa(nome, idade));
        }

        // Converte a lista em JSON
        String jsonLista = service.converterParaJson(pessoas);
        System.out.println("\nLista em JSON:\n" + jsonLista);

        // Altera o primeiro objeto da lista em JSON
        JsonObject obj = service.alterarPrimeiro(jsonLista);
        System.out.println("\nJSON do primeiro objeto depois da alteração:\n" + obj);

        sc.close();
    }
}
