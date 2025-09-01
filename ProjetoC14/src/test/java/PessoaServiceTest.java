import br.com.exemplo.Pessoa;
import com.google.gson.JsonObject;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PessoaServiceTest {

    @Test public void testConverterParaJson() {
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("Natalia", 22));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(pessoas); assertTrue(json.contains("Natalia"));
    }

    @Test
    public void testMultiplaPessoasParaJson() {
        List<Pessoa> pessoas = List.of(
                new Pessoa("Carlos", 28),
                new Pessoa("Beatriz", 32)
        );
        Gson gson = new Gson();
        String json = gson.toJson(pessoas);
        assertTrue(json.contains("Carlos"));
        assertTrue(json.contains("Beatriz"));
    }


    @Test
    public void testAlterarJsonComGson() {
        Pessoa p = new Pessoa("Lucas", 20);
        Gson gson = new Gson();
        String json = gson.toJson(p);

        // Parse de volta para JsonObject
        JsonObject obj = gson.fromJson(json, com.google.gson.JsonObject.class);
        obj.addProperty("idade", 30);
        obj.addProperty("cidade", "São Paulo");

        assertEquals(30, obj.get("idade").getAsInt());
        assertEquals("São Paulo", obj.get("cidade").getAsString());
    }

    @Test
    public void testConverterJsonParaObjeto() {
        String json = "{\"nome\":\"Ana\",\"idade\":40}";
        Gson gson = new Gson();
        Pessoa p = gson.fromJson(json, Pessoa.class);
        assertEquals("Ana", p.nome);
        assertEquals(40, p.idade);
    }

    @Test
    public void testListaVaziaParaJson() {
        List<Pessoa> pessoas = new ArrayList<>();
        Gson gson = new Gson();
        String json = gson.toJson(pessoas);
        assertEquals("[]", json);  // Confirma que a lista vazia vira JSON "[]"
    }

    @Test
    public void testJsonParaObjetoComIdadeNegativa() {
        String json = "{\"nome\":\"Felipe\",\"idade\":-5}";
        Gson gson = new Gson();
        Pessoa p = gson.fromJson(json, Pessoa.class);
        assertEquals("Felipe", p.nome);
        assertEquals(-5, p.idade);
    }

    @Test
    public void testAdicionarNovaPropriedadeNoJson() {
        Pessoa p = new Pessoa("Carla", 27);
        Gson gson = new Gson();
        String json = gson.toJson(p);

        JsonObject obj = gson.fromJson(json, JsonObject.class);
        obj.addProperty("cidade", "Curitiba");

        assertEquals("Curitiba", obj.get("cidade").getAsString());
    }

    @Test
    public void testAlterarNomeEConverterDeVoltaParaObjeto() {
        Pessoa p = new Pessoa("João", 33);
        Gson gson = new Gson();
        String json = gson.toJson(p);

        JsonObject obj = gson.fromJson(json, JsonObject.class);
        obj.addProperty("nome", "João Pedro");

        Pessoa p2 = gson.fromJson(obj, Pessoa.class);
        assertEquals("João Pedro", p2.nome);
        assertEquals(33, p2.idade);
    }


}
