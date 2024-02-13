## Links para documentações

+ Record
  Classes: https://docs.oracle.com/en/java/javase/16/language/records.html#GUID-6699E26F-4A9B-4393-A08B-1E47D4B2D263
+ Bean
  validation: https://jakarta.ee/specifications/bean-validation/3.0/jakarta-bean-validation-spec-3.0.html#builtinconstraints

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

- Sempre que mexermos em arquivos de migrações é importante parar a execução do springbot
- Uma migration depois de executada numca deve ser alterada

+ Padrão de versionamento: ``V1__create-table-medicos.sql``

## Validação com Bean Validation

Para se validar os campos recebidos por requisições basta usar a anotações como ``@Notnull``, ``@Noteblank``

**Importtante!!**

Para que o spring entenda que é preciso validar os campos é importante adicionar a anotação ``@valid`` antes do
parâmetro
<br>

![valid.png](api%2Fvalid.png)

## Sobre o @Transactional

O @Transactional é uma anotação utilizada em frameworks de persistência de dados, como o Spring
Framework, para definir transações em métodos ou classes. Transações são utilizadas para garantir a consistência dos
dados em operações que envolvem múltiplas alterações no banco de dados, assegurando que todas essas operações sejam
concluídas com sucesso ou revertidas em caso de erro.

Quando você marca um método com @Transactional, o framework cuida da criação e gerenciamento da transação para você,
iniciando uma nova transação antes da execução do método marcado e a finalizando ao término do método. Se ocorrer uma
exceção durante a execução do método, a transação é revertida (rollback) para garantir a integridade dos dados.

## Problemas com arquivos de migrações

As vezes pode ocorrer de mexermos em migrações com o devTools em execução, isso pode acasionar um erro, pois ele pode
reiniciar a aplicação com o arquivo de migração imcompleto, fazendo os arquivos se perderem em instruções de criação das
tabelas. Caso isso ocorra o erro seria esse:

````
Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'flywayInitializer' defined in class path resource [org/springframework/boot/autoconfigure/flyway/FlywayAutoConfiguration$FlywayConfiguration.class]: Validate failed: Migrations have failed validation
````

*Para resolver esse problema será necessário acessar o banco de dados da aplicação e executar o seguinte comando sql:*

* *delete from flyway_schema_history where success = 0;*
* *drop database vollmed_api;*
* *create database vollmed_api;*

## Paginação e ordenação de dados

## DTO

O padrão DTO (Data Transfer Object) é um padrão de arquitetura que era bastante utilizado antigamente em aplicações Java
distribuídas (arquitetura cliente/servidor) para representar os dados que eram enviados e recebidos entre as aplicações
cliente e servidor.

O padrão DTO pode (e deve) ser utilizado quando não queremos expor todos os atributos de alguma entidade do nosso
projeto, situação igual a dos salários dos funcionários mostrado no exemplo de código anterior. Além disso, com a
flexibilidade e a opção de filtrar quais dados serão transmitidos, podemos poupar tempo de processamento.

## Erro de se usar uma entidade JPA diretamente em  um método do controlador

Outro problema muito recorrente ao se trabalhar diretamente com entidades JPA acontece quando uma entidade possui algum
autorrelacionamento ou relacionamento bidirecional. causando o error ``StackOverflowError``

## Implementando o recurso de paginação

Para implementar o recurso de paginação em uma API Rest utilizando o Spring Framework, você pode seguir os seguintes
passos:

- Importe corretamente a classe Pageable no seu controlador.
- No método que irá listar os registros, adicione o parâmetro Pageable.
- Altere o tipo de retorno do método para Page<T>, onde T é o tipo dos registros que você está listando.
- Utilize o parâmetro Pageable no método de busca dos registros, passando-o como argumento.
- Na URL da requisição, utilize os parâmetros size e page para controlar o número de registros exibidos e a página a ser
  exibida, respectivamente.
- Dessa forma, você estará configurando a requisição para trazer apenas a quantidade desejada de registros por página

## Ordenação pela URL no front

Para se ordenar a busca por registro pela url basta usar o recurso ?sort=[nomeDoAtriuto] como no exemplo abaixo:

+ http://localhost:8080/medicos?sort=nome

## Parâmetros de paginação

por padrão, os parâmetros utilizados para realizar a paginação e a ordenação devem se chamar page, size e sort.
Entretanto, o Spring Boot permite que os nomes de tais parâmetros sejam modificados via configuração no arquivo
application.properties.

Por exemplo, poderíamos traduzir para português os nomes desses parâmetros com as seguintes propriedades:

````
spring.data.web.pageable.page-parameter=pagina
spring.data.web.pageable.size-parameter=tamanho
spring.data.web.sort.sort-parameter=ordem

````

## PUT ou PATCH?

Escolher entre o método HTTP PUT ou PATCH é uma dúvida comum que surge quando estamos desenvolvendo APIs e precisamos
criar um endpoint para atualização de recursos. Vamos entender as diferenças entre as duas opções e quando utilizar cada
uma.

**PUT**

O método PUT substitui todos os atuais dados de um recurso pelos dados passados na requisição, ou seja, estamos falando
de uma atualização integral. Então, com ele, fazemos a atualização total de um recurso em apenas uma requisição.

**PATCH**

O método PATCH, por sua vez, aplica modificações parciais em um recurso. Logo, é possível modificar apenas uma parte de
um recurso. Com o PATCH, então, realizamos atualizações parciais, o que torna as opções de atualização mais flexíveis.

**Qual escolher?**

Na prática, é difícil saber qual método utilizar, pois nem sempre saberemos se um recurso será atualizado parcialmente
ou totalmente em uma requisição - a não ser que realizemos uma verificação quanto a isso, algo que não é recomendado.