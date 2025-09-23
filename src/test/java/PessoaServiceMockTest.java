
import br.com.exemplo.IPessoaService;
import br.com.exemplo.Pessoa;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PessoaServiceMockTest {

    @Mock
    private IPessoaService pessoaService;

    @Test
    void testeConverterParaJsonMock() {
        List<Pessoa> lista = List.of(new Pessoa("Natalia", 19));

        when(pessoaService.converterParaJson(lista))
                .thenReturn("[{\"nome\":\"Natalia\",\"idade\":19}]");

        String json = pessoaService.converterParaJson(lista);

        assertEquals("[{\"nome\":\"Natalia\",\"idade\":19}]", json);
        verify(pessoaService).converterParaJson(lista);
    }

    @Test
    void testeAlterarPrimeiroMock() {
        String jsonLista = "[{\"nome\":\"Natalia\",\"idade\":19}]";
        JsonObject objMock = new JsonObject();
        objMock.addProperty("nome", "Natalia");
        objMock.addProperty("idade", 30);
        objMock.addProperty("cidade", "Belo Horizonte");

        when(pessoaService.alterarPrimeiro(jsonLista)).thenReturn(objMock);

        JsonObject resultado = pessoaService.alterarPrimeiro(jsonLista);

        assertEquals(30, resultado.get("idade").getAsInt());
        assertEquals("Belo Horizonte", resultado.get("cidade").getAsString());

        verify(pessoaService).alterarPrimeiro(jsonLista);
    }
}
