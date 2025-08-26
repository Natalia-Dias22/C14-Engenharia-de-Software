package br.com.exemplo;

import java.util.List;
import com.google.gson.*;

public class PessoaService {

    // Converte lista de pessoas para JSON
    public String converterParaJson(List<Pessoa> pessoas) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(pessoas);
    }

    // Altera o primeiro objeto do JSON
    public JsonObject alterarPrimeiro(String jsonLista) {
        JsonArray jsonArray = JsonParser.parseString(jsonLista).getAsJsonArray();
        JsonObject obj = jsonArray.get(0).getAsJsonObject();
        obj.addProperty("idade", 30);
        obj.addProperty("cidade", "Belo Horizonte");
        return obj;
    }
}
