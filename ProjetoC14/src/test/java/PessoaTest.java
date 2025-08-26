import br.com.exemplo.Pessoa;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PessoaTest {

    @Test
    public void testConverterParaJson() {
        // 1. Cria lista de pessoas
        List<Pessoa> pessoas = List.of(
                new Pessoa("Natalia", 22),
                new Pessoa("João", 25)
        );

        // 2. Converte para JSON
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(pessoas);

        // 3. Testa se contém os nomes
        assertTrue("JSON deve conter Natalia", json.contains("Natalia"));
        assertTrue("JSON deve conter João", json.contains("João"));
    }
}
