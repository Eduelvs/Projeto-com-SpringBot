# Projeto com Java Swing

Este projeto é uma aplicação Java que modela elementos do universo de "Hora de Aventura", utilizando Java, JPA (Java Persistence API) e Swing para interface gráfica. A aplicação simula uma civilização inspirada na série, permitindo criar, alterar, excluir e visualizar entidades como personagens, armas, objetos, reinos e outros elementos do mundo fictício.

## Funcionalidades

- **Modelagem de Dados:** Diversas classes Java representam entidades como Humanos, Armas, Objetos Mágicos, Reinos, Governantes, Vilas, etc., mapeadas via JPA para persistência em banco de dados.
- **Interface Gráfica (Swing):** O projeto possui telas para inserção, alteração e exclusão de dados das entidades, facilitando a manipulação do universo criado.
- **Operações CRUD:** Através da interface é possível inserir, alterar e excluir personagens e objetos do universo "Hora de Aventura".
- **Exemplo de entidades:** Finn, Princesa Jujuba, Espada de Grama, Princesa Caroço, Cidadela Além do Multiverso, entre outros.

## Estrutura do Projeto

- `src/main/java/br/edu/unifei/ecot13/trabalho`: Contém as entidades do domínio, como `Humano`, `Arma`, `Objeto`, `CidadelaAlemDoMultiverso`, etc.
- `src/main/java/interface_swing`: Contém as telas da interface gráfica (`incluir`, `alterar`, `excluir`, `tela`), responsáveis pelas operações CRUD com os dados.
- Uso de anotações do Lombok para reduzir boilerplate nas entidades (ex: `@Data`, `@EqualsAndHashCode`).

## Exemplos de Uso

- Adicionar um novo personagem (ex: Finn, com habilidades, moradia, idade, etc).
- Alterar informações de entidades já existentes (ex: mudar a habilidade de um personagem).
- Excluir entidades do universo simulado.

## Tecnologias Utilizadas

- **Java 8+**
- **JPA (Java Persistence API)**
- **Swing** (interface gráfica)
- **Lombok** (para facilitar o código das entidades)

## Inspiração

O projeto é inspirado na série "Hora de Aventura", trazendo elementos e personagens para um modelo relacional e orientado a objetos, permitindo manipulação e simulação de acontecimentos dentro desse universo.

## Como Executar

1. Clone o repositório.
2. Importe o projeto em sua IDE Java de preferência.
3. Certifique-se de ter um banco de dados configurado (ex: MySQL) e ajuste a `persistence.xml` conforme necessário.
4. Execute as classes de interface Swing para acessar as telas de manipulação dos dados.

## Créditos

Projeto acadêmico desenvolvido por [Eduelvs](https://github.com/Eduelvs) para fins de estudo e aprendizado em modelagem de dados, Java e interface gráfica.
