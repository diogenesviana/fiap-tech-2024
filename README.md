﻿![Logo](https://avatars.githubusercontent.com/u/79948663?s=200&v=4)

# Tech Challenge - FIAP TECH 2024

Este repositório contém o código fonte do projeto desenvolvido para o projeto do Tech Challenge referente a pós-graduação da FIAP TECH no ano de 2024:

## Stack utilizada

**Back-end:** Java 21, MySQL

## Rodando localmente

Clone o projeto:

```bash
  git clone https://github.com/diogenesviana/fiap-tech-2024.git
```

Entre no diretório do projeto:

```bash
  cd fiap-tech-2024
```

Suba o container utilizando o docker-compose:

```bash
  docker compose up
```

## Variáveis de Ambiente

Para rodar esse projeto, você vai precisar adicionar as seguintes variáveis de ambiente no seu .env

`MYSQL_ROOT_PASSWORD`
`MYSQL_DATABASE`
`MYSQL_USER`
`MYSQL_PASSWORD`

Foi criado um arquivo `.example.env` com as variáveis necessárias.

## Documentação

No projeto foi instalado e configurado o
[Swagger](https://swagger.io/). Por isso, assim que for executado o comando para iniciar o servidor, vai estar disponível na rota http://localhost:8080/swagger-ui/index.html# a documentação da API utilizando Swagger.

A documentação referente ao event storming está disponível neste link. https://miro.com/app/board/uXjVKZetEuc=/

## Autores

-  [@Bruno Campos](https://github.com/brunocamposousa)
-  [@Bruno Oliveira](https://github.com/bgoulart)
-  [@Diógenes Viana](https://github.com/diogenesviana)
-  [@Filipe Borba](https://www.github.com/filipexxborba)
-  [@Rhuan Patriky](https://github.com/rhuanpk)
