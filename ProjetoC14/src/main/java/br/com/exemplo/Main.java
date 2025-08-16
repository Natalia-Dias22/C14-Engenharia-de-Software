package br.com.exemplo;

import java.util.List;
import java.util.ArrayList;

import com.google.gson.*;


public class Main {
    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("Natalia", 22));
        pessoas.add(new Pessoa("João", 25));

        //Criar objeto Gson com configuração de Pretty Print, (fica bonitinho)
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String jsonLista = gson.toJson(pessoas);
        System.out.println("Lista em JSON: " + jsonLista);


        //Alterando, usando uma classe de GSON, que representa um objeto JSON

        // Converter string JSON para JsonArray
        JsonArray jsonArray = JsonParser.parseString(jsonLista).getAsJsonArray();

        // Pegar o primeiro elemento da lista
        JsonElement primeiroElemento = jsonArray.get(0);

        // Transformar em JsonObject
        JsonObject obj = primeiroElemento.getAsJsonObject();

        // Alterar campos
        obj.addProperty("idade", 30); // altera a idade
        obj.addProperty("cidade", "Belo Horizonte"); // adiciona um novo campo

        System.out.println("\nJSON do primeiro objeto depois da alteração:\n" + obj);

    }
}
