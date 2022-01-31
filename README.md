# TrilhaBack
Desafio 3

a) I. HTTP (Hypertext Transfer Protocol) é um protocolo de transferência de comunicação entre um navegador e um servidor web, sendo um dos principais da WWW (World Wide Web).

II. Rest é um protocolo para troca de mensagens (XML ou JSON) que podem usar HTTP para transportar como mensagens.

Web API é uma interface de programação de aplicações tanto para um servidor quanto para um navegador. III. Swagger é um framework para descrição, consumo e visualização de serviços Repousante, tendo como objetivo permitir que a documentação evolua na mesma necessidade que a implementação.

b) Obter - requisição por onde nós pedimos a representação de um recurso, por exemplo, html, xml, json e etc .; Pós - método utilizado quando desejamos criar um recurso; Put - método que requisita que um recurso seja guardado no URI previsto e se o recurso já existe o mesmo será atualizado; Excluir - exclui recursos associados; Trace - Devolve a mesma requisição que for enviada tanto se houver mudança e também se houver adição feita por servidores intermediários; Opções - retorna os métodos HTTP permitidos pelo servidor para um URL; Patch - usado para editar o recurso sem necessidade e enviar todos os atributos



Desafio 9

a)	Design Patterns (Padrões de Projetos) são soluções para problemas comuns encontrados no desenvolvimento ou na manutenção
de softwares orientação a objeto.

b)	Padrões de criação: Abstract Factory – Permite elaborar uma interface para criação de famílias de objetos relacionados ou interdependentes, que não especifica suas classes concretas. A partir desse padrão é possível criar fabricas concretas, que são responsáveis pela criação de novos objetos para entender as necessidades dos clientes. Portanto, essa prática ajuda a excluir a dependência entre o cliente e a classe dos objetos usados por ele.
Padrões estruturais: Adapter – A ação desse padrão é converter a interface de uma classe em outra, esperada pelo objeto cliente. Através dessa conversão será permitido que classes com imcompatibilidade de interfaces, consigam serem adaptadas para que outros objetos possam trabalhar juntos.
Padrões comportamentais: Chain of Responsability – Esse padrão encadeia vários objetos receptores que transporta uma solicitação, sendo aguardada até que um dos objetos responda. Com isso, se evita o acoplamento entre o remetente de uma solicitação e seu destinatário, dando oportunidade para mais de um objeto tratar a solicitação.

c)	Arquitetura de software define a forma como um sistema trabalha e como os novos módulos podem ser construídos e de forma intuitiva.

d)	Estamos seguindo a lógica de negócio, pois 

g) SOLID é um acrônimo dos cinco primeiros princípios da programação orientação a objetos e design de códigos identificados por Robert C. Martin nos anos 2000 que tem como significado: 

S – SRP (Princípio da Responsabilidade Única) – Uma classe deve ter um e somente um motivo para mudar.

O: OCP (Princípio Aberto-Fechado) – Você deve ser capaz de estender um comportamento de uma classe sem modificá-lo.

L: LSP (Princípio da Substituição de Liskov) – As classes base devem ser substituíveis por suas classes derivadas.

I: ISP (Princípio de Segregação de Interface) – Muitas interfaces especificas são melhores do que uma interface única

D: DIP (Princípio de inversão da dependência) – Dependa de uma abstração e não de uma implementação.

h) Foi utilizado até o momento o OCP(Open/Closed principle), LSP(Liskov Substitution Principle), ISP(Interface Segregation Principle)

O que é DDD?
  O Domain Driven Design combina práticas de design e desenvolvimento, oferecendo ferramentqas de modelagem
  estratégica e tática para entregar um software de alta qualidade. Tem como objetivo acelerar o desenvolvimento de
  software que lidam com complexos processos de négocios.

- Por que os padrões são divididos entre criação, estruturais e comportamentais?
  Existem vários tipos de padrões de projetos, sendo assim, para ter uma melhor organização e facilitar o programador, foi divididos em
  3 grandes categorias sendo os de criação, estrututais e comportametais. Todos os padrões destas categorias tem um conjunto de 
  características específicas, que motivam a categorização deles.

Desafio 11

a)Lib(ou biblioteca) é um conjunto de funcionalidades que podem ser reaproveitadas pelos seus projetos.

b)Clojure - uma linguagem de programação que combina a flexibilidade e facilidade de uma linguagem de script com a robustez do Java;

Apache Log4j – ele fornece uma excelente estrutura para produzir logs coerentes para aplicativos.

c)O Maven é uma ferramenta de integração de projetos, tendo como objetivo gerenciar dependências, 

controlar versões de artefatos, gerar relatórios de produtividade, garantir execução de testes,

manter nível de qualidade do código e entre outros.

d)O Maven é uma ferramenta de gerenciamento e compreensão de projetos de software usada principalmente 

em projetos Java, já o Gadle é um sistema de automação de códigos abertos baseado nos conceitos do Apache Ant e do Apache Maven.

e) I. Driver em Java são classes de utilitário usadas para realizar tarefas, essas classes são usadas em JDBC para 

conectar um aplicativo Java a um banco de dados.

   II. As bibliotecas são adicionadas no Pom.xml quando adicionamos as dependências e suas versões, com isso o Maven 

baixa essas bibliotecas e assim sendo possível sua utilização no projeto.

  III.Para realizar a conexão ao banco de dados SQL Server em um projeto Java, é necessário utilizar um driver JDBC 

adequado com uma rotina de programação. Com o SQL Server existem dois drivers, o oficial da Microsoft e o opensource jTDS. Para o driver da Microsoft

deve se seguir adicionar na classe Java ou no arquivo JSP a seguinte rotina:

String usuario = "exemplo";

String senha = "123456";

String url = "jdbc:sqlserver://sql.locadados.com.br:1433;databaseName=hsegura_tutorial" +

                       ";user=" + usuario + ";password=" + senha + ";";

try {

    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

    Connection conexao = DriverManager.getConnection(url);

} catch (ClassNotFoundException e) {

    // Erro caso o driver JDBC não foi instalado

    e.printStackTrace();

} catch (SQLException e) {

    // Erro caso haja problemas para se conectar ao banco de dados

    e.printStackTrace();

}

Já para o driver jTDS é feito da seguinte maneira:

String url = "jdbc:jtds:sqlserver://sql.locadados.com.br:1433/hsegura_tutorial";

String usuario = "exemplo";

String senha = "123456";

try {
Class.forName("net.sourceforge.jtds.jdbc.Driver");
Connection conexao = DriverManager.getConnection(url, usuario, senha);
} catch (ClassNotFoundException e) {
// Erro caso o driver JDBC não foi instalado
e.printStackTrace();
} catch (SQLException e) {
// Erro caso haja problemas para se conectar ao banco de dados
e.printStackTrace();
}

Desafio 12

a) O teste unitário ou de unidade é uma modalidade de testes que se concentra
na verificação da menor unidade do projeto de software. É realizado o teste de uma 
unidade lógica, com uso de dados suficientes para se testar apenas a lógica da unidade 
em questão.

b) Criar uma classe teste que estenda junit.framework.TestCase, depois as classes com regra de 
negocio, dentro da classe teste é de boa pratica colocar como nome dos metodos de 
teste facilitando o entendimento do código.
Verificar se o teste só tenha sucesso porque o código esta correto e para o teste der falha
somente se o cogigo testado estiver incorreto.
Também é de boa pratica criar mensagens curtas e de facil compreensão.
É colocado a anotação @SpringBootTest para iniciar o código para o teste e como isso podera ser
usado a @Autowire em qualquer bean selecionada pela varredura de componentes no teste.

c) O intuito de realizar teste unitario é previnir contra o aparecimento de bug´s vindo de
um código mau estrito, poder realizar alterações, verificar se tem falha

d) Bibliotecas de Mock e Runners