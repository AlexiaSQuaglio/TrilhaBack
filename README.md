# TrilhaBack
Desafio 3
Desafio 3 a) I. HTTP (Hypertext Transfer Protocol) é um protocolo de transferência de comunicação entre um navegador e um servidor web, sendo um dos principais da WWW (World Wide Web).

II. Rest é um protocolo para troca de mensagens (XML ou JSON) que podem usar HTTP para transportar como mensagens.

Web API é uma interface de programação de aplicações tanto para um servidor quanto para um navegador. III. Swagger é um framework para descrição, consumo e visualização de serviços Repousante, tendo como objetivo permitir que a documentação evolua na mesma necessidade que a implementação.

b) Obter - requisição por onde nós pedimos a representação de um recurso, por exemplo, html, xml, json e etc .; Pós - método utilizado quando desejamos criar um recurso; Put - método que requisita que um recurso seja guardado no URI previsto e se o recurso já existe o mesmo será atualizado; Excluir - exclui recursos associados; Trace - Devolve a mesma requisição que for enviada tanto se houver mudança e também se houver adição feita por servidores intermediários; Opções - retorna os métodos HTTP permitidos pelo servidor para um URL; Patch - usado para editar o recurso sem necessidade e enviar todos os atributos



Desafio 9
a)	Design Patterns (Padrões de Projetos) são soluções para problemas comuns encontrados no desenvolvimento ou na manutenção de softwares orientação a objeto.

b)	Padrões de criação:  Abstract Factory – Permite elaborar uma interface para criação de famílias de objetos relacionados ou interdependentes, que não especifica suas classes concretas. A partir desse padrão é possível criar fabricas concretas, que são responsáveis pela criação de novos objetos para entender as necessidades dos clientes. Portanto, essa prática ajuda a excluir a dependência entre o cliente e a classe dos objetos usados por ele.
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

