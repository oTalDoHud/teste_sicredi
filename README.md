# Teste Sicredi
![License](https://img.shields.io/github/license/oTalDoHud/ProjetoDashBoardVendas)


## Padrão MVC (Controllers, Services and repositories)

![Modelo_relacional](/home/hudson/projetos/java/teste/assets/modelo_rela.png)

Modelo de arquitetura onde as funções e privilégios ficam divididos entre Rest Controller (Recebe requisições e envia respostas), Services (Realiza toda a lógica do negócio) e Repositories (Realiza todo tipo de acesso ao banco de dados).

## Modelo conceitual - UML

![Modelo_relacional](/home/hudson/projetos/java/teste/assets/modelo_rela.png)


## Pedidos Json

### Execução da aplicação em Docker
```bash
{
    "id": 1,
    "moment": "2019-06-20T19:53:07Z",
    "orderStatus": "PAID",
    "client": {
        "id": 1,
        "name": "Hudson",
        "email": "Hudson@gmail.com",
        "phone": "11 932165604",
        "password": "1234"
    },
    "items": [
        {
            "quantity": 2,
            "price": 90.5,
            "product": {
                "id": 1,
                "name": "The Lord of the Rings",
                "description": "Lorem ipsum dolor sit amet, consectetur.",
                "price": 90.5,
                "imgUrl": "",
                "categories": [
                    {
                        "id": 2,
                        "name": "Books"
                    }
                ]
            },
            "subTotal": 181.0
        },
        {
            "quantity": 1,
            "price": 1250.0,
            "product": {
                "id": 3,
                "name": "Macbook Pro",
                "description": "Nam eleifend maximus tortor, at mollis.",
                "price": 1250.0,
                "imgUrl": "",
                "categories": [
                    {
                        "id": 3,
                        "name": "Computers"
                    }
                ]
            },
            "subTotal": 1250.0
        }
    ],
    "payment": {
        "id": 1,
        "moment": "2019-06-20T22:53:07Z"
    },
    "total": 1431.0
}
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


# Como testar projeto

## As requisições podem ser testadas no [Postman](https://web.postman.co "Site Postman") , utilizando as seguintes URL's:

#### https://spring-generico-um.herokuapp.com/user/id/2

#### https://spring-generico-um.herokuapp.com/user/all

# Autor