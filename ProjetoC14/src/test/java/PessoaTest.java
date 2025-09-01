import org.junit.Test;
import static org.junit.Assert.*;
import br.com.exemplo.Pessoa;
public class PessoaTest {

    @Test
    public void testCriacaoPessoa() {
        Pessoa p = new Pessoa("Maria", 20);
        assertEquals("Maria", p.nome);
        assertEquals(20, p.idade);
    }

    @Test
    public void testNomeVazio() {
        Pessoa p = new Pessoa("", 25);
        assertEquals("", p.nome);
        assertEquals(25, p.idade);
    }

    @Test
    public void testIdadeZero() {
        Pessoa p = new Pessoa("Carlos", 0);
        assertEquals("Carlos", p.nome);
        assertEquals(0, p.idade);
    }

    @Test
    public void testIdadeNegativa() {
        Pessoa p = new Pessoa("Ana", -5);
        assertEquals("Ana", p.nome);
        assertEquals(-5, p.idade);
    }

    @Test
    public void testDiferentesPessoas() {
        Pessoa p1 = new Pessoa("João", 30);
        Pessoa p2 = new Pessoa("João", 30);


        assertEquals(p1.nome, p2.nome);
        assertEquals(p1.idade, p2.idade);
        //Verifica se não é da mesma instancia de nome
        assertNotSame(p1, p2);
    }

    @Test
    public void testNomeComEspacos() {
        Pessoa p = new Pessoa("   Lucas   ", 28);
        assertEquals("   Lucas   ", p.nome);
        assertEquals(28, p.idade);
    }

    @Test
    public void testIdadeMaxima() {
        Pessoa p = new Pessoa("Velha Senhora", 150);
        assertEquals("Velha Senhora", p.nome);
        assertEquals(150, p.idade);
    }

    @Test
    public void testNomeNull() {
        Pessoa p = new Pessoa(null, 40);
        assertNull(p.nome);
        assertEquals(40, p.idade);
    }

    @Test
    public void testAlterarNome() {
        Pessoa p = new Pessoa("Ana", 22);
        p.nome = "Ana Clara";
        assertEquals("Ana Clara", p.nome);
        assertEquals(22, p.idade);
    }

    @Test
    public void testAlterarIdade() {
        Pessoa p = new Pessoa("Pedro", 18);
        p.idade = 25;
        assertEquals("Pedro", p.nome);
        assertEquals(25, p.idade);
    }
}
