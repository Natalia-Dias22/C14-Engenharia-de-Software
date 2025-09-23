package br.com.exemplo;

import com.google.gson.JsonObject;
import java.util.List;

public interface IPessoaService {
    String converterParaJson(List<Pessoa> pessoas);
    JsonObject alterarPrimeiro(String jsonLista);
}
