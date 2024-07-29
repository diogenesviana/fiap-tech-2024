![Logo](https://avatars.githubusercontent.com/u/79948663?s=200&v=4)

# Tech Challenge - FIAP TECH 2024

Este repositório contém o código fonte do projeto desenvolvido para o projeto do Tech Challenge referente a pós-graduação da FIAP TECH no ano de 2024:

## Desenho Arquitetura

**Requisitos de negócio** 

Implementação de um sistema de autoatendimento de fast food que deve permitir que clientes selecionem os produtos disponíveis, realize seu pedido contemplando seu respectivo pagamento e seja informado quando estiver disponível para retirada.

O cliente terá interação com um totem (front end) para seleção dos produtos e confirmação do pedido e com um monitor (front end) para informar o progresso / retirada do pedido no balcão.

O sistema persistirá os dados de produtos, clientes e pedidos em uma banco de dados, além de realizar integração com o gateway de pagamento (mercado pago).

O desenvolvimento do sistema seguirá os padrões do clean code e clean architecture.

O sistema terá alta disponibilidade e escalabilidade.

O diagrama abaixo resume as interações de atores e componentes do requisitos de negócios:

![image](https://drive.google.com/file/d/1q7F0ZAob0yztDwp5rVxuLN7I_hG4z34e/view)

**Requisitos de infraestrutura** 

Visando atender o requisito de negócio de alta disponibilidade e escalabilidade, a infraestrutura do sistema está na arquitetura de Kubernetes conforme detalhado no diagrama abaixo:

![image](https://github.com/user-attachments/assets/3c9c0410-3692-4499-a903-1908e206e543)


## Collection APIs 

**Swagger:** http://a99605b88cb5045e29f6a70cf5702e89-132306677.us-east-1.elb.amazonaws.com/swagger-ui/index.html

**Postman:** https://documenter.getpostman.com/view/10582474/2sA3kbexHD

## Guia execução do projeto e ordem de execução APIs:

**1. Criação de Produtos:** Lanchonete envia uma requisição POST para /produtos informando nome, preço e tipo do produto.

**2. Consulta de Produtos:** Lanchonete envia uma requisição GET para /produtos/{tipoProduto} para verificar a listagem de produtos por tipo de produto.

**3. Criação do Cliente:** liente envia uma requisição POST para /clientes informando nome, CPF e email.

**4. Criação do Pedido:** Cliente envia uma requisição POST para /pedidos com o novo pedido, onde é passado o ID do cliente e a lista com os IDs dos produtos que o cliente deseja. No retorno, também é atribuído o status do pagamento como AGUARDANDO e o status do pedido como RECEBIDO.

**5. Atualização de Status de Pagamento via Webhook:** Mercado Pago envia uma notificação POST (mock) para /pagamentos com ID do pedido e status do pagamento.

**6. Atualização de Status do Pedido:** Lanchonete envia uma notificação PUT para /pedidos/{id} com o status do pagamento.

**7. Listagem de Status do Pedido:** Lanchonete envia uma requisição GET para /pedidos/{statusPedido} para verificar a listagem de pedidos por status de pedido.


## Links demonstração arquitetura:

Link clean architecture: https://youtu.be/RniUx5XP1Vs

Link infraestrutura kubernetes: https://www.youtube.com/watch?v=qRCLTTGmkCM

## Autores

-  [@Bruno Campos](https://github.com/brunocamposousa)
-  [@Bruno Oliveira](https://github.com/bgoulart)
-  [@Diógenes Viana](https://github.com/diogenesviana)
-  [@Filipe Borba](https://www.github.com/filipexxborba)
-  [@Rhuan Patriky](https://github.com/rhuanpk)
