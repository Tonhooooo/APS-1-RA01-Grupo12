# Sistema de Gerenciamento de Atendimento ao Cliente
**Disciplina:** Estrutura de Dados  
**Tema:** Pilha e Fila usando Lista Encadeada (sem uso de funções prontas)  
**Linguagem:** Java  

---

## Descrição do Projeto

Este projeto implementa um **Sistema de Gerenciamento de Atendimento ao Cliente**, utilizando duas estruturas de dados fundamentais:

- **Pilha (Histórico de Solicitações)** — implementada com **lista encadeada**, segue o princípio **LIFO (Last In, First Out)**.  
- **Fila (Ordem de Atendimento)** — implementada com **lista encadeada**, segue o princípio **FIFO (First In, First Out)**.  

O sistema permite:
- Adicionar e remover solicitações no histórico (pilha);  
- Adicionar clientes e atender em ordem de chegada (fila);  
- Exibir o conteúdo completo de cada estrutura a qualquer momento.  

---

## Regras do Trabalho

Conforme solicitado, **não foram utilizadas funções prontas** da linguagem.  
**Permitidos:** `String`, `int`, `float`, `try-catch`, `Scanner`, `System.out.print`.  
**Proibidos:** `List`, `ArrayList`, `Stack`, `Queue`, `Arrays`, `StringBuilder` e qualquer estrutura de dados da biblioteca padrão.

---

## Estrutura do Código

### Classe `Elemento`
Armazena as informações básicas de cada registro.

- Para **pilha**: representa uma solicitação (ID, descrição, data e hora).  
- Para **fila**: representa um cliente (ID, nome, motivo do atendimento).

```java
class Elemento {
    String id;
    String nomeOuDescricao;
    String detalhe;
}
```

---

### Classe `Node`
Cada `Node` é um nó da lista encadeada, contendo um `Elemento` e a referência para o próximo nó.

```java
class Node {
    Elemento dado;
    Node proximo;
}
```

---

### Classe `Pilha`
Implementa a estrutura de **pilha** (histórico de solicitações) usando lista encadeada.

- `empilhar(Elemento e)` → adiciona uma solicitação no topo.  
- `desempilhar()` → remove a última solicitação inserida.  
- `estaVazia()` → verifica se a pilha está vazia.  
- `exibir()` → mostra todas as solicitações armazenadas.

A pilha segue a regra **LIFO (último que entra, primeiro que sai)**.

---

### Classe `Fila`
Implementa a estrutura de **fila** (ordem de atendimento dos clientes) usando lista encadeada.

- `enfileirar(Elemento e)` → adiciona cliente no fim da fila.  
- `desenfileirar()` → remove o cliente do início da fila.  
- `estaVazia()` → verifica se há clientes aguardando.  
- `exibir()` → lista todos os clientes na ordem de atendimento.

A fila segue a regra **FIFO (primeiro que entra, primeiro que sai)**.

---

### Classe `SistemaAtendimento`
Classe principal que apresenta o **menu interativo** e controla as operações sobre a pilha e a fila.

#### Menu:
```
1 - Adicionar solicitação ao histórico (Pilha)
2 - Remover solicitação do histórico
3 - Exibir histórico
4 - Adicionar cliente à fila
5 - Atender próximo cliente
6 - Exibir fila
0 - Sair
```

O sistema usa `Scanner` para entrada do usuário e `try-catch` para validação de opções inválidas.

---

## Exemplo de Execução

```
--- SISTEMA DE ATENDIMENTO ---
1 - Adicionar solicitação ao histórico (Pilha)
2 - Remover solicitação do histórico
3 - Exibir histórico
4 - Adicionar cliente à fila
5 - Atender próximo cliente
6 - Exibir fila
0 - Sair
Escolha: 1
ID da solicitação: REQ011
Descrição: Instalação de impressora
Data e hora: 2025-10-18 09:00
Solicitação adicionada ao histórico.
```

---

## Estruturas Auxiliares (Arquivos de Exemplo)

Os arquivos `historico.txt` e `filadeatendimento.txt` contêm exemplos de dados usados no programa:

**historico.txt**
```java
new Elemento("REQ001", "Instalação de software", "2024-08-20 10:30")
```

**filadeatendimento.txt**
```java
new Elemento("CLI001", "Maria Silva", "Dúvida sobre produto")
```

Esses exemplos podem ser usados para pré-carregar dados, se desejado.

---

## Autores

| Nome Completo | RA | Função no Projeto |
|----------------|----|-------------------|
| Antonio Tomasi | — | Lógica principal e revisão final |
| (Nome 2) | — | Implementação da fila |
| (Nome 3) | — | Implementação da pilha |
| (Nome 4) | — | Testes e documentação |

> *Substitua os nomes acima pelos integrantes reais do grupo antes de enviar ao professor.*

---

## Como Executar

1. Abra o terminal na pasta do projeto.  
2. Compile o programa:
   ```bash
   javac SistemaAtendimento.java
   ```
3. Execute:
   ```bash
   java SistemaAtendimento
   ```
4. Use o menu para interagir com o sistema.

---

## Conceitos Demonstrados

- Lista encadeada simples (ponteiros manuais)  
- Pilha (LIFO)  
- Fila (FIFO)  
- Estrutura de dados dinâmica (sem limite fixo)  
- Controle de exceções e entrada de dados  

