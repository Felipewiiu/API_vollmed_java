## Links de documentações

+ https://docs.oracle.com/en/java/javase/16/language/records.html#GUID-6699E26F-4A9B-4393-A08B-1E47D4B2D263
+

## Configurando o Dev Tools

Para fazer a configuração do Dev Tools, basta

1 - pressionar a tecla sheft + sheft
2 - settings
3 - build, execution, Deployment
4 - Compiler --> marque a opção: Allows auto-make to start even if development
5 - advanced settings
6 - aply

## entendendo sobre configurações de controllers

Para se criar uma classe controladora no java é preciso usar a anotação ``@RestController`` e em seus métodos o tipo de
verbo HTTP que será invocado como no exemplo logo abaixo:

````
@RestController
@RequestMapping("medicos")
public class MedicoController {
    @PostMapping
    public void cadastrar(@RequestBody String cep){
        System.out.println(cep);

    }
}

````

## O que seria o padrão DTO?

O padrão DTO (Data Transfer Object) é utilizado para representar os dados que chegam em uma API e os dados que são
devolvidos por ela. Ele permite encapsular os dados em um objeto simples, facilitando a transferência de informações
entre diferentes camadas da aplicação.

## O que é o @Embeddable?

é uma anotação **usada para marcar uma classe como uma classe que pode ser incorporada em outra classe de entidade.** Em
outras palavras, ela é usada para definir uma classe cujos objetos podem ser incluídos como parte da representação de
uma entidade JPA.

Por exemplo, se você tem uma classe Endereco que deseja incluir como parte de uma entidade Usuario, você pode marcar a
classe Endereco com @Embeddable. Isso permite que você inclua todos os atributos da classe Endereco diretamente na
tabela de banco de dados associada à entidade Usuario, em vez de criar uma tabela separada para armazenar os detalhes de
endereço.

Ao marcar uma classe com @Embeddable, você pode usá-la como tipo de atributo em uma classe de entidade, usando a
anotação @Embedded. Essa anotação indica ao provedor JPA que os atributos da classe @Embeddable devem ser incluídos na
tabela da entidade que a contém.

## Conhecendo sobre o

O Lombok é uma biblioteca Java que visa reduzir a verbosidade do código, automatizando a geração de código repetitivo,
como getters, setters, construtores, métodos toString(), entre outros. Ele funciona através de anotações que são
processadas durante a compilação pelo Lombok Annotation Processor, gerando automaticamente o código correspondente.

Com o Lombok, desenvolvedores podem escrever código mais conciso e legível, focando nas funcionalidades do software em
vez de se preocuparem com a implementação tediosa de métodos repetitivos. Isso ajuda a reduzir erros e acelera o
desenvolvimento de software.

## Ferramentas de migrações

**Importtante!!**

Sempre que mexermos em arquivos de migrações é importante parar a execução do springbot

+ Padrão de versionamento: ``V1__create-table-medicos.sql``

## Validação com Bean Validation

Para se validar os campos recebidos por requisições basta usar a anotações como ``@Notnull``, ``@Noteblank``





