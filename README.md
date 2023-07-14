# Teste Sicredi
![License](https://img.shields.io/github/license/oTalDoHud/ProjetoDashBoardVendas)


## Padrão MVC (Controllers, Services and repositories)
Modelo de arquitetura onde as funções e privilégios ficam divididos entre Rest Controller (Recebe requisições e envia respostas), Services (Realiza toda a lógica do negócio) e Repositories (Realiza todo tipo de acesso ao banco de dados).

## Modelo conceitual

![Modelo_relacional](https://github.com/oTalDoHud/teste_sicredi/blob/master/assets/modelo_relacional.png)


## Execução da aplicação em Docker
No diretório raiz do projeto, execute:
```bash
docker compose up
```

### Curl dos endpoints
Primeiro, precisamos criar a Pauta:
```bash
curl --request POST \
--url http://localhost:8080/pauta \
--header 'Content-Type: application/json' \
--data '{
"assunto_pauta" : "Moradia para todos",
"ds_pauta" : "Resolução do problema de morádia em capitais"
}'
```

Podemos consulta-la:
```bash
curl --request GET \
  --url http://localhost:8080/pauta/1
```
Depois criar uma sessão de votos de uma pauta
```bash
curl --request POST \
  --url http://localhost:8080/sessao \
  --header 'Content-Type: application/json' \
  --data '{
	"pauta" : 1,
	"duracao_minutos" : 5
}'
```
Depois, consultar essa sessão:
```bash
curl --request GET \
  --url http://localhost:8080/sessao/1
```
E para votar, precisamos de um usuário:
```bash
curl --request POST \
--url http://localhost:8080/user \
--header 'Content-Type: application/json' \
--data '{
"nome" : "Hudson Lucas",
"cpf" : "10140872019"
}'
```
E com o usuário podemos votar nessa sessão enquanto estiver aberta
```bash
curl --request POST \
--url http://localhost:8080/sessao/voto \
--header 'Content-Type: application/json' \
--data '{
"sessao" : 1,
"cpf" : 10140872019,
"voto": 1
}'
```
E, posteriormente é possível consultar novamente essa sessão:
![Modelo_relacional](https://github.com/oTalDoHud/teste_sicredi/blob/master/assets/retorno_sessao.png)

# Tecnologias utilizadas
- Java
- Spring Boot
- JPA / Hibernate
- Rest
- Swagger
- Flyway
- PostgreSQL
- Docker
- Maven


## Autor
Hudson Lucas Teles Vieira

www.linkedin.com/in/otaldohud

hudson.lucas.vieira@gmail.com

