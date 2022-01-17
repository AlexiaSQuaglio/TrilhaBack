# TrilhaBack
Desafio 3
Desafio 3 a) I. HTTP (Hypertext Transfer Protocol) é um protocolo de transferência de comunicação entre um navegador e um servidor web, sendo um dos principais da WWW (World Wide Web).

II. Rest é um protocolo para troca de mensagens (XML ou JSON) que podem usar HTTP para transportar como mensagens.

Web API é uma interface de programação de aplicações tanto para um servidor quanto para um navegador. III. Swagger é um framework para descrição, consumo e visualização de serviços Repousante, tendo como objetivo permitir que a documentação evolua na mesma necessidade que a implementação.

b) Obter - requisição por onde nós pedimos a representação de um recurso, por exemplo, html, xml, json e etc .; Pós - método utilizado quando desejamos criar um recurso; Put - método que requisita que um recurso seja guardado no URI previsto e se o recurso já existe o mesmo será atualizado; Excluir - exclui recursos associados; Trace - Devolve a mesma requisição que for enviada tanto se houver mudança e também se houver adição feita por servidores intermediários; Opções - retorna os métodos HTTP permitidos pelo servidor para um URL; Patch - usado para editar o recurso sem necessidade e enviar todos os atributos

Desafio 10
Spring Framework é um framework desenvolvido para a linguagem Java baseado nos padrões de desenvolvimento, inversão de controle e injeção de dependências.
Spring Boot foi desenvolvido com base na ideia de convenção sobre configuração, apenas utilizar sobmódulos necessários sem preocupação com o trabalho de configuração.
Spring Data JPA tem como proposito de fornecer um modelo de programação baseado em Spring para acesso a dados de maneira fácil e sem complicações, mantendo as características especiais do armazenamento de dados subjacente.

Spring Web é utilizado para criar aplicativos Web, incluindo RESTful, utilizando o Spring MVC. Essencial para criação aplicações web baseadas em baseadas em Spring Framework.

Na trilha foram usados o Spring Web, Spring Data JPA, Spring Boot e Java Persistence API.
Aumento de legibilidade do código, facilidade de manutenção e facilidade na construção dos testes.
E
Pom.xml contém tudo sobre o projeto, como as dependências, propriedades, tudo que será executado durante o build.
Applications.properties fornecem uma maneira de substituir os valores de propriedade incluídos no binário do aplicativo, podendo configurar alguns campos com suporte com propriedades do aplicativo ao configurar acionadores e atividades.
Annotations fornece a opção do uso de metadata ao longo do código que podem ser posteriormente interpretadas por um compilador ou pré compilador que irá realizar alguma tarefa pré definida. O Annotation evita em muitos casos a criação de arquivos XML de configuração.
@Override – é uma anotação que deve ser usada apenas com métodos. Serve para indicar que o método anotado está sobrescrevendo um método da superclasse.
@Deprecated – esta anotação é utilizada quando necessário indicar que um método não deveria mais ser usado.

@Autowired – é a anotação mais utiliza com relação a injeção de dependências, indica um ponto aonde a injeção automática deve ser aplicada. Esta anotação pode ser usada em métodos, atributos e construtores.

@Bean – serve para exportar uma classe para o Spring para que consiga carregar essa classe e fazer injeção de dependência dela em outra classe.

@Componente – pode ser usada no aplicativo para marcar os beans como componentes gerenciados do Spring.

@Repository – tem como objetivo criar beans para a parte de persistência, além de capturar exceções especificas de persistência e repeti-las como umas exceções não verificadas e unificadas do Spring.

@Service – serve para indicar que ele está mantendo logica de negócio.

@Controller – é utilizada para indicar que a classe é um manipulador de solicitação da web.

@SpringBootApplication – é usada para marcar uma classe de configuração que declara um ou mais @Bean métodos e triggers auto-configuration e varredura de componentes.

Advice é uma ação realizada por um aspecto em um ponto de junção específico. Diferentes tipos de advice, como por exemplo, Before advice: executado antes de um ponto de junção, mas não tem a capacidade de impedir que o fluxo de execução prossiga para o ponto de junção.
After returning advice: aviso a ser executado após um ponto de junção ser concluído normalmente.

After throwing advice: concelho a ser executado se um método sair lançando uma exceção.

After advice: aviso a ser executado independentemente do meio pelo qual um ponto de junção sai.

É um processo pelo qual os objetos definem suas dependências apenas por meio de argumentos do construtor, argumentos para um método factory ou propriedades que são definidas na instancia do objeto depois que ele é construído ou retornado de um método factory.
Spring Security tem o foco em tornar a parte de autenticação e autorização uma coisa simples de fazer.
DATABASE H2.
O agendamento de tarefas é bastante útil quando se precisa que determinada função da aplicação seja evocada em um momento específico do dia, sendo para aproveitar horas de menor trafego de rede, sendo para gerar relatórios e entre outras possibilidades. A repetição em intervalos pré-definidos tem como vantagem chegar o banco de dados, geração de logs, carregamento e entre outras checagens.