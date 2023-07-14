# Teste Sicredi
![License](https://img.shields.io/github/license/oTalDoHud/ProjetoDashBoardVendas)


## Padrão MVC (Controllers, Services and repositories)
Modelo de arquitetura onde as funções e privilégios ficam divididos entre Rest Controller (Recebe requisições e envia respostas), Services (Realiza toda a lógica do negócio) e Repositories (Realiza todo tipo de acesso ao banco de dados).

## Modelo conceitual

![Modelo_relacional](/home/hudson/projetos/java/teste/assets/modelo_relacional.png)


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


# Autor

