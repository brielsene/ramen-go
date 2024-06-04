# Ramen-Go

Ramen-Go é um aplicativo de delivery de ramen, oferecendo uma variedade de pratos deliciosos diretamente para sua porta.
Este projeto é uma plataforma de e-commerce desenvolvida em Java usando Spring Boot e algumas outras tecnologias.

## Funcionalidades Principais

- Visualização do cardápio envolvendo protéinas e caldos
- Seleção de itens para compra
- Processamento de pedidos

## Pontos de observações
A API demora a primeira requisição, pois o deploy foi feito de maneira gratuita no render.com, sendo assim a primeira requisição que a API está em estado de inatividade,
demora em torno de 1/2 minutos.


## Tecnologias Utilizadas

- Java
- Spring Boot
- Arquitetura MVC
- Spring Data JPA
- Lombok
- Spring DevTools
- Docker
- PostgreSQL
- Deploy no Render

## Organização de pacotes
![image](https://github.com/brielsene/ramen-go/assets/87671071/06f5e744-6682-40bd-84f8-fe4d75351a2a)



## Como utilizar
- A Requisição deve ser feita a partir da URL: https://ramen-go-gi25.onrender.com
- Os seus endpoints são -> GET -> /proteins e /broths
- O endpoint de POST utilizamos /order
- Passando sempre como parâmetro no Header a Key x-api-key com o valor: 2hdJdsGtyIns18d8shNjG32222sajsakJNaa1a
- o valor da x-api-key, também é encontrado no application.properties

## Retorno da API - Via Postman
- Proteins
![Captura de tela 2024-06-03 203557](https://github.com/brielsene/ramen-go/assets/87671071/fefa624e-aa25-4a2e-a156-16a247e670c3)

- Broths
![image](https://github.com/brielsene/ramen-go/assets/87671071/cb960a00-171d-40cf-8d98-663fa29d0113)

- Order
![image](https://github.com/brielsene/ramen-go/assets/87671071/03884503-5abc-4314-b2da-5677b9b2c396)

- Sem x-api-key (Tratamento de erro)
![image](https://github.com/brielsene/ramen-go/assets/87671071/bbb8a8e1-8a90-4df8-8492-dd9598922a47)


## Futuras atualizações
- Futuramente será adiciona JavaMail, para que seja enviado por e-mail um comprovante de compra, contendo o orderId e algumas outras informações
- A API também terá uma segunda versão com linguagem Golang

### Pré-requisitos

- Java Development Kit (JDK) 17 ou superior
- Maven
- PostgreSql
- Docker

### Instalação

1. Clone o repositório:

```bash
git clone https://github.com/brielsene/ramen-go.g

