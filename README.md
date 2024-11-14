# Projeto back-end API Pokemon
#### Escolhi trazer os dados da API para meu banco de dados, dessa forma eu evito de ser barrado pela API por multiplas requests.
#### Criei uma JOB chamada PokemonDataJob ela roda assim que eu subir o projeto e depois toda segunda as 00:00. Essa job tem como objetivo fazer algumas requisições na API do pokemon e estruturar eles no banco de dados. 
#### Criei Algumas tabelas que serão populadas por essa JOB elas são Color, Types, Habitat e Pokemon. O banco também possui 2 tabelas para ao relacionamento de type_pokemon e color_pokemon, pois um pokemon pode ter mais de um tipo e mais de uma cor.
#### Escolhi usar o padrão Repository, pois acho ele muito organizado e ele funciona muito bem para esse preojeto. Nesse padrão temos os seguintes pacotes.
<ol>
  <li>entities</li>
  <li>dto</li>
  <li>form</li>
  <li>jobs</li>
  <li>repositories</li>
  <li>services</li>
  <li>servicesImpl</li>
  <li>controller</li>
</ol>

## Entities
#### Esta classe define como está a estrutura do banco cada classe refere a uma tabela no banco.
## Dto
#### Esta classe define como será a resposta da API do pokemon, estou usando ela para formatar os dados em uma classe para que eu possa usar depois.
## Form
#### Esta classe serve para definir os parâmetros que serão mandados para a minha controller do filtro
## Jobs
#### Esta classe é uma backgroundJob criada para montar e estrutrurar o banco de dados, essa job é muito importante pois a forma que eu implementei faço consulta no banco ao invés de ficar fazendo as requisições diretas a API do pokemon.
## Repositories
#### Esta interface me entrega as funções que posso usar para manipular o banco
## Services
#### Uso essa interface para eu definir os serviços que vou usar, depois faço uma injeção de depêndencia dela nas controller que eu for usar evitando ficar fazendo new.
## ServicesImpl
#### Aqui se encontra a implementação de fato das services acima.
## Controllers
#### Ela recebe as requests do front-end e redireciona para seus respectivos serviços.

## ApiHttpService 
#### Onde se encontra todas as funções que fazem requisições a API do pokemon.

## JWT
#### Para essa segunda etapa do projeto como eu estou usando uma API, com o diferêncial que agora terá uma autenticação por login. Tendo isso em mente escolhi usar JWT com `Bearer Token` para manter minhas requisições mais seguras. Para que eu conseguisse usar o JWT precisei criar algumas `Classes`.
<ol>
  <li>SecurityConfig</li>
  <li>JwtAuthenticationFilter</li>
  <li>JwtServiceImpl</li>
</ol>

## SecurityConfig
#### Esta classe é responsavel por algumas configurações de segurança. Aqui definimos rotas que precisarão de autenticação. Nesta classe também configurei o cors, para que eu consiga fazer minhas requisições.

## JwtAuthenticationFilter
#### Essa classe é responsavel pela autenticação de fato, aqui verifico cabeçalho, jwt token, username tudo referente a autenticação. O principal método dessa classe é o doFilterInternalque é herdado da classe `OncePerRequestFilter`. Isso indica que o filtro será executado uma vez por requisição.

## JwtServiceImpl
#### Essa classe é um serviço que possui métodos que irão auxiliar na autenticação. Alguns métodos são `generateToken` e `isTokenValid`.

#### Usando toda essa arquitetura me possibilita fazer uma conexão mais segura entre meu back-end e o meu front-end. Algumas estratégias de expiração do token também foram adotadas e a implementação está localizada na Classe `JwtServiceImpl`. O token tem um prazo de validade de 24 horas definido no meu `aplication.properties`.
`jwt.expiration=86400000`

## Rotas
#### Defini algumas rotas como livres de autenticação, ou seja, elas não precisam do token para serem acessadas. Essas rotas são `auth/login` e `user/register`.

## Banco de dados
#### Em relação ao banco de dados foi apenas criar uma tabela a mais e fazer um relacionamento 1:N entre usuário e pokemons. Foi preciso criar os outros arquivos, que são os do padrão repository que eu estou seguindo, mas em relação ao banco a arquitetura se mantém a mesma.

## Muitas requisições e API externa bloqueando.
#### isso não acontece comigo pois como fiz uma Job que trouxe todos os dados mais importantes dos pokemons para mim e salvou no banco. Escolhi fazer isso justamente para evitar de ser bloqueado, como todos os dados estão no meu banco de dados me facilitou o relacionamento dos dados.