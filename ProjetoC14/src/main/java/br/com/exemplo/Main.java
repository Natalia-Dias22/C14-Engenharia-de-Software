package br.com.exemplo;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import com.google.gson.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Pessoa> pessoas = new ArrayList<>();

        System.out.print("Quantas pessoas deseja cadastrar? ");
        int qtd = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < qtd; i++) {
            System.out.println("\nPessoa " + (i + 1) + ":");

            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("Idade: ");
            int idade = sc.nextInt();
            sc.nextLine();

            pessoas.add(new Pessoa(nome, idade));
        }

        PessoaService service = new PessoaService();

        String jsonLista = service.converterParaJson(pessoas);
        System.out.println("\nLista em JSON:\n" + jsonLista);

        JsonObject obj = service.alterarPrimeiro(jsonLista);
        System.out.println("\nJSON do primeiro objeto depois da alteração:\n" + obj);

    }
}
