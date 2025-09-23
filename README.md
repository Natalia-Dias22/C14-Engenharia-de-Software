[![Java CI with Maven](https://github.com/Natalia-Dias22/C14-Engenharia-de-Software/actions/workflows/ci.yml/badge.svg)](https://github.com/Natalia-Dias22/C14-Engenharia-de-Software/actions/workflows/ci.yml)


# C14-Engenharia-de-Software
Códigos feitos na aula de Engenharia de Software.
 Esse projeto em específico, se trata de um codigo simples em JAVA, usando a dependência GSON, onde transformamos os objetos JSON.
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Projeto JSON com Testes JUnit

Este projeto em Java tem como objetivo manipular objetos JSON e garantir a integridade da aplicação através de testes unitários com JUnit. Ele demonstra como criar, ler e validar objetos JSON de forma prática e testável.

Tecnologias utilizadas
Java 23
JUnit 5
Gson (para manipulação de JSON)
Maven (para gerenciamento de dependências, opcional)

Estrutura do Projeto
src/
├── main/
│   └── java/
│       └── br/com/exemplo/
│           ├── Pessoa.java
│           └── PessoaService.java
└── test/
    └── java/
        └── br/com/exemplo/
            ├── PessoaTest.java
            └── PessoaServiceTest.java

Funcionalidades

Criar objetos Java e convertê-los para JSON
Ler JSON e mapear para objetos Java
Testes unitários para validar conversão e integridade dos dados
Tratamento de casos especiais, como atributos nulos

Exemplo de Uso
import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("Natalia", 19);
        Gson gson = new Gson();

        // Convertendo objeto para JSON
        String json = gson.toJson(pessoa);
        System.out.println(json);

        // Convertendo JSON para objeto
        Pessoa pessoa2 = gson.fromJson(json, Pessoa.class);
        System.out.println(pessoa2.getNome());
    }
}

Testes Unitários

Os testes utilizam JUnit 5 para garantir que a conversão entre objetos Java e JSON funcione corretamente, mesmo em situações com atributos nulos.

Exemplo de teste:

@Test
public void testPessoaComNomeNuloParaJson() {
    Pessoa p = new Pessoa(null, 22);
    Gson gson = new Gson();
    String json = gson.toJson(p);

    // Verifica se os valores estão presentes no JSON
    assertTrue(json.contains("22"));
    assertTrue(json.contains("null"));
}

Executando os testes

-mvn test


Se você está compilando manualmente com Java:

javac -cp .:junit-5.10.0.jar:hamcrest-core-1.3.jar src/test/java/br/com/exemplo/*.java
java -cp .:junit-5.10.0.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore br.com.exemplo.Pess



