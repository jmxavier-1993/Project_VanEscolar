Nomes dos envolvidos no projeto:  

Abner Wesley Calado dos Santos - 01654143
Diogo Martins De Cristo- 01630970
Juliana Marinho Xavier- 01132389
Amanda Francelina da Silva- 01601710
Jose Antonio de Lima-01634771


## Considerações tecnicas
No frontend, utilizamos a plataforma de low-code FlutterFlow que possui uma biblioteca 
vasta do framework Flutter. Essa escolha nos permitiu desenvolver uma aplicação mais 
flexível e fluida, além de facilitar a criação de Progressive Web Apps (PWA). 
O FlutterFlow oferece uma interface intuitiva que acelera o processo de desenvolvimento 
sem comprometer a qualidade ou a funcionalidade da aplicação. 

Para o backend, optou-se pelo robusto conjunto de ferramentas do Spring, incluindo Spring Boot,
 Spring Data e Spring Framework, aproveitando a potência do Java 17 para garantir a s
egurança e a eficiência do sistema. Como banco de dados, foi escolhido o MySql para armazenamento 
de dados, garantindo confiabilidade e desempenho em todo o ciclo de vida da aplicação. 
Além disso, conectamos nosso banco de dados Spring ao Firebase através de APIs. Essa integração 
foi fundamental, pois o FlutterFlow possui integração nativa com o Firebase, o que simplifica 
a gestão de dados e a implementação de funcionalidades em tempo real. Com essa configuração, 
conseguimos unir a robustez do Spring Boot com a praticidade e eficiência do Firebase, essa 
abordagem resultou em uma aplicação moderna, sólida, escalável e própria para mobile, pronta 
para atender às necessidades dos usuários de forma eficaz.


# Documentação das Requisições e Respostas da API

## 1. OBJETIVO

Este documento tem por objetivo especificar a parte técnica relacionada ao consumo
do serviço de cadastro do motorista. Para tal, serão descritas abaixo as URIs que
respondem as requisições to front-end, assim como os dados (payload) esperados por
essas URIs com algumas informações pessoais de exemplo, descrição dos campos
obrigatórios, os métodos de requisição.

## 2. MÉTODOS E URI

### 2.1. POST /MOTORISTA

Requisição do tipo POST para /motorista e payload enviado:

```json
{
    "nome":"Fulano de Tall",
    "telefone":"+55(62)98745-6321",
    "cpf" : "000.000.000-00",
    "cnh": "123456789",
    "dataDeNascimento":"1984-08-30",
    "endereco": {
        "cep":"76400-000",
        "cidade":"Goiânia",
        "bairro":"Alto da Glória",
        "complemento":"Próximo ao Carrefour",
        "numero":"123",
        "localidade":"GO",
        "logradouro":"Avenida 2 Radial"
    },
    "automovel": {
        "modelo":"Renault",
        "nomeCarro":"Master",
        "placa":"DKV0J01"
    }
}
```

Resposta esperada para esta requisição:

```json
{
    "id": 33,
    "nome": "Fulano de Tall",
    "cpf": "000.000.000-00",
    "cnh": "123456789",
    "endereco": {
        "cep": "76400-000",
        "cidade": "Goiânia",
        "numero": "123",
        "logradouro": "Avenida 2 Radial",
        "complemento": "Próximo ao Carrefour",
        "bairro": "Alto da Glória",
        "localidade": "GO"
    },
    "telefone": "+55(62)98745-6321",
    "dataDeNascimento": "1984-08-30T00:00:00.000+00:00",
    "automovel": {
        "id": 33,
        "modelo": "Renault",
        "nomeCarro": "Master",
        "placa": "DKV0J01"
    }
}
```

## 2.2. GET /MOTORISTA/ID

Requisição do tipo GET para /motorista/id e a resposta recebida:

```json
{
    "id": 1,
    "nome": "Fulano de Tall",
    "cpf": "000.000.000-00",
    "cnh": "123456789",
    "endereco": {
        "cep": "76400-000",
        "cidade": "Goiânia",
        "numero": "123",
        "logradouro": "Avenida 2 Radial",
        "complemento": "Próximo ao Carrefour",
        "bairro": "Alto da Glória",
        "localidade": "GO"
    },
    "telefone": "+55(62)98745-6321",
    "dataDeNascimento": "1984-08-30T00:00:00.000+00:00",
    "automovel": {
        "id": 1,
        "modelo": "Renault",
        "nomeCarro": "Master",
        "placa": "DKV0J01"
    }
}
```

## 2.3. PUT /MOTORISTA/ID

Requisição do tipo PUT para /motorista/id e payload enviado:

```json
{
    "nome":"Motoristaatualiza21",
    "telefone":"231232132323232",
    "cpf" : "23232323232323",
    "cnh": "23123123212",
    "dataNascimento":"2222-00-22",
    "endereco": {
        "cep":"03101010",
        "cidade":"suzano",
        "bairro":"aaa",
        "complemento":"apto 47",
        "numero":"331",
        "localidade":"asd",
        "logradouro":"asd"
    },
    "automovel": {
        "modelo":"testee",
        "nomeCarro":"poa",
        "placa":"nova poa"
    }
}
```

Resposta esperada para esta requisição:

```json
{
    "id": 1,
    "nome": "Motoristaatualiza21",
    "cpf": "23232323232323",
    "cnh": "23123123212",
    "endereco": {
        "cep": "03101010",
        "cidade": "suzano",
        "numero": "331",
        "logradouro": "asd",
        "complemento": "apto 47",
        "bairro": "aaa",
    "localidade": "asd"
    },
    "telefone": "231232132323232",
    "automovel": {
        "id": null,
        "modelo": "testee",
        "nomeCarro": "poa",
        "placa": "nova poa"
    }
}
```

## 2.4. GET /MOTORISTA/PEDIDOS/{id}

Requisição do tipo GET para /motorista/pedidos/1 e a resposta recebida:

```json
{
    "content": [
        {
            "id": 1,
            "nome": "Responsavel4",
            "dataNascimento": "2022-05-10T00:00:00.000+00:00",
            "cpf": "555555555555",
            "telefone": "2312312323232",
            "endereco": {
                "cep": "03101010",
                "cidade": "suzano",
                "numero": "331",
                "logradouro": "asd",
                "complemento": "apto 47",
                "bairro": "aaa",
                "localidade": "asd"
            },
            "statusPedidoCorrida": "Feito_Pedido",
            "estadoCivil": "SOLTEIRO",
            "aluno": [
                {
                    "id": 1,
                    "nome": "nomeAluno",
                    "dataNascimento": "2022-05-10",
                    "cpf": "555555555555",
                    "telefone": "2312312323232"
                }
            ]
        }
    ],
    "pageable": {
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 20,
        "paged": true,
        "unpaged": false
    },
    "last": true,
    "totalPages": 1,
    "totalElements": 1,
    "size": 20,
    "number": 0,
    "sort": {
    "empty": true,
    "sorted": false,
    "unsorted": true
    },
    "first": true,
    "numberOfElements": 1,
    "empty": false
}
```

## 2.5. PATCH /MOTORISTA/ACEITARCORRIDA/{ID}

Requisição do tipo PATCH para /motorista/aceitarCorrida/{id} e o payload enviado:

```json
{
    "idResponsavel": 1
}
```

Resposta esperada para esta requisição:

```json
{
    "id": 1,
    "nome": "Responsavel4",
    "dataNascimento": "2022-05-10T00:00:00.000+00:00",
    "cpf": "555555555555",
    "telefone": "2312312323232",
    "endereco": {
        "cep": "03101010",
        "cidade": "suzano",
        "numero": "331",
        "logradouro": "asd",
        "complemento": "apto 47",
        "bairro": "aaa",
        "localidade": "asd"
    },
    "statusPedidoCorrida": "Pedido_Aceito",
    "estadoCivil": "SOLTEIRO",
    "aluno": [
        {
            "id": 1,
            "nome": "nomeAluno",
            "dataNascimento": "2022-05-10",
            "cpf": "555555555555",
            "telefone": "2312312323232"
        }
    ],
    "motorista": {
        "id": 1,
        "nome": "Motoristaatualiza21",
        "cpf": "23232323232323",
        "cnh": "23123123212",
        "endereco": {
            "cep": "03101010",
            "cidade": "suzano",
            "numero": "331",
            "logradouro": "asd",
            "complemento": "apto 47",
            "bairro": "aaa",
            "localidade": "asd"
        },
        "statusPedidoCorrida": "Pedido_Aceito",
        "telefone": "231232132323232",
        "dataDeNascimento": null
    }
}
```

## 2.6. GET /MOTORISTA/NEGARCORRIDA/{ID}

Requisição do tipo GET para /motorista/negarCorrida/{id} e o payload enviado:

```json
{
    "idResponsavel": 1
}
```
Resposta esperada para esta requisição:

```json
{
    "id": 1,
    "nome": "Responsavel4",
    "dataNascimento": "2022-05-10T00:00:00.000+00:00",
    "cpf": "555555555555",
    "telefone": "2312312323232",
    "endereco": {
        "cep": "03101010",
        "cidade": "suzano",
        "numero": "331",
        "logradouro": "asd",
        "complemento": "apto 47",
        "bairro": "aaa",
        "localidade": "asd"
    },
    "statusPedidoCorrida": "Pedido_Negado",
    "estadoCivil": "SOLTEIRO",
    "aluno": [
        {
            "id": 1,
            "nome": "nomeAluno",
            "dataNascimento": "2022-05-10",
            "cpf": "555555555555",
            "telefone": "2312312323232"
        }
    ],
    "motorista": {
        "id": 1,
        "nome": "Motoristaatualiza21",
        "cpf": "23232323232323",
        "cnh": "23123123212",
        "endereco": {
            "cep": "03101010",
            "cidade": "suzano",
            "numero": "331",
            "logradouro": "asd",
            "complemento": "apto 47",
            "bairro": "aaa",
            "localidade": "asd"
        },
        "statusPedidoCorrida": "Pedido_Negado",
        "telefone": "231232132323232",
        "dataDeNascimento": null
    }
}
```
## 2.7. POST /RESPONSAVEL

Requisição do tipo POST para /responsavel e o payload enviado:
```json
{
    "nome":"Responsavel4",
    "dataNascimento": "2022-05-10",
    "cpf" : "555555555555",
    "estadoCivil":"SOLTEIRO",
    "telefone": "2312312323232",
    "endereco": {
        "cep":"03101010",
        "cidade":"suzano",
        "bairro":"aaa",
        "complemento":"apto 47",
        "numero":"331",
        "localidade":"asd",
        "logradouro":"asd"
    },
    "aluno": [
        {
            "nome":"nomeAluno",
            "dataNascimento": "2022-05-10",
            "cpf" : "555555555555",
            "estadoCivil":"SOLTEIRO",
            "telefone": "2312312323232"
        }
    ]
}
```
Resposta esperada para esta requisição:
```json
{
    "id": 1,
    "nome": "Responsavel4",
    "dataNascimento": "2022-05-10T00:00:00.000+00:00",
    "cpf": "555555555555",
    "telefone": "2312312323232",
    "endereco": {
        "cep": "03101010",
        "cidade": "suzano",
        "numero": "331",
        "logradouro": "asd",
        "complemento": "apto 47",
        "bairro": "aaa",
        "localidade": "asd"
    },
    "statusPedidoCorrida": null,
    "estadoCivil": "SOLTEIRO",
    "aluno": [
        {
            "id": 1,
            "nome": "nomeAluno",
            "dataNascimento": "2022-05-10",
            "cpf": "555555555555",
            "telefone": "2312312323232"
        }
    ]
}
```
## 2.8. GET /RESPONSAVEL/MOTORISTA?CIDADE={TEXTO}

Requisição do tipo GET para /responsavel/motorista?cidade={texto} e a resposta
recebida:
```json
{
    "content": [
        {
            "id": 1,
            "nome": "Motoristaatualiza21",
            "cpf": "23232323232323",
            "cnh": "23123123212",
            "endereco": {
                "cep": "03101010",
                "cidade": "suzano",
                "numero": "331",
                "logradouro": "asd",
                "complemento": "apto 47",
                "bairro": "aaa",
                "localidade": "asd"
            },
            "statusPedidoCorrida": "Feito_Pedido",
            "telefone": "231232132323232",
            "dataDeNascimento": null
        }
    ],
    "pageable": {
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 20,
        "paged": true,
        "unpaged": false
    },
    "last": true,
    "totalPages": 1,
    "totalElements": 1,
    "size": 20,
    "number": 0,
    "sort": {
        "empty": true,
        "sorted": false,
        "unsorted": true
    },
    "first": true,
    "numberOfElements": 1,
    "empty": false
}
```
## 2.9. PATCH /RESPONSAVEL/PEDIDO/{ID}

Requisição do tipo PATCH para /responsavel/pedido/{id} e o payload enviado:
```json
{
    "idMotorista": 1
}
```
Resposta esperada para esta requisição:
```json
{
    "id": 1,
    "nome": "Responsavel4",
    "dataNascimento": "2022-05-10T00:00:00.000+00:00",
    "cpf": "555555555555",
    "telefone": "2312312323232",
    "endereco": {
        "cep": "03101010",
        "cidade": "suzano",
        "numero": "331",
        "logradouro": "asd",
        "complemento": "apto 47",
        "bairro": "aaa",
        "localidade": "asd"
    },
    "statusPedidoCorrida": "Feito_Pedido",
    "estadoCivil": "SOLTEIRO",
    "aluno": [
        {
            "id": 1,
            "nome": "nomeAluno",
            "dataNascimento": "2022-05-10",
            "cpf": "555555555555",
            "telefone": "2312312323232"
        }
    ],
    "motorista": {
        "id": 1,
        "nome": "Motoristaatualiza21",
        "cpf": "23232323232323",
        "cnh": "23123123212",
        "endereco": {
            "cep": "03101010",
            "cidade": "suzano",
            "numero": "331",
            "logradouro": "asd",
            "complemento": "apto 47",
            "bairro": "aaa",
            "localidade": "asd"
        },
        "statusPedidoCorrida": "Feito_Pedido",
        "telefone": "231232132323232",
        "dataDeNascimento": null
    }
}

```
## 2.10. GET /RESPONSAVEL/{ID}

Requisição do tipo GET para /responsavel{id} e a resposta recebida:
```json
{
    
    "id": 1,
    "nome": "Responsavel4",
    "dataNascimento": "2022-05-10T00:00:00.000+00:00",
    "cpf": "555555555555",
    "telefone": "2312312323232",
    "endereco": {
        "cep": "03101010",
        "cidade": "suzano",
        "numero": "331",
        "logradouro": "asd",
        "complemento": "apto 47",
        "bairro": "aaa",
        "localidade": "asd"
    },
    "statusPedidoCorrida": "Pedido_Negado",
    "estadoCivil": "SOLTEIRO",
    "aluno": [
        {
            "id": 1,
            "nome": "nomeAluno",
            "dataNascimento": "2022-05-10",
            "cpf": "555555555555",
            "telefone": "2312312323232"
        }
    ],
    "motorista": {
        "id": 1,
        "nome": "Motoristaatualiza21",
        "cpf": "23232323232323",
        "cnh": "23123123212",
        "endereco": {
            "cep": "03101010",
            "cidade": "suzano",
            "numero": "331",
            "logradouro": "asd",
            "complemento": "apto 47",
            "bairro": "aaa",
            "localidade": "asd"
        },
        "statusPedidoCorrida": "Pedido_Negado",
        "telefone": "231232132323232",
        "dataDeNascimento": null
    }
}
