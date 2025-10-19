import java.util.Scanner;

// Classe representando um nó genérico da lista encadeada
class Node {
    Elemento dado;
    Node proximo;

    Node(Elemento dado) {
        this.dado = dado;
        this.proximo = null;
    }
}

// Classe representando um elemento
class Elemento {
    String id;
    String nomeOuDescricao;
    String detalhe;

    Elemento(String id, String nomeOuDescricao, String detalhe) {
        this.id = id;
        this.nomeOuDescricao = nomeOuDescricao;
        this.detalhe = detalhe;
    }

    void exibir() {
        System.out.println("ID: " + id + " | " + nomeOuDescricao + " | " + detalhe);
    }
}

// PILHA
class Pilha {
    private Node topo;

    Pilha() {
        topo = null;
    }

    boolean estaVazia() {
        return topo == null;
    }

    void empilhar(Elemento e) {
        Node novo = new Node(e);
        novo.proximo = topo;
        topo = novo;
    }

    Elemento desempilhar() {
        if (estaVazia()) {
            System.out.println("Pilha vazia!");
            return null;
        }
        Elemento removido = topo.dado;
        topo = topo.proximo;
        return removido;
    }

    void exibir() {
        if (estaVazia()) {
            System.out.println("Histórico vazio!");
            return;
        }
        Node atual = topo;
        System.out.println("--- Histórico de Solicitações ---");
        while (atual != null) {
            atual.dado.exibir();
            atual = atual.proximo;
        }
    }
}

// FILA 
class Fila {
    private Node frente;
    private Node tras;

    Fila() {
        frente = null;
        tras = null;
    }

    boolean estaVazia() {
        return frente == null;
    }

    void enfileirar(Elemento e) {
        Node novo = new Node(e);
        if (estaVazia()) {
            frente = novo;
            tras = novo;
        } else {
            tras.proximo = novo;
            tras = novo;
        }
    }

    Elemento desenfileirar() {
        if (estaVazia()) {
            System.out.println("Fila vazia!");
            return null;
        }
        Elemento removido = frente.dado;
        frente = frente.proximo;
        if (frente == null) tras = null;
        return removido;
    }

    void exibir() {
        if (estaVazia()) {
            System.out.println("Fila vazia!");
            return;
        }
        Node atual = frente;
        System.out.println("--- Fila de Atendimento ---");
        while (atual != null) {
            atual.dado.exibir();
            atual = atual.proximo;
        }
    }
}

// PROGRAMA PRINCIPAL
public class SistemaAtendimento {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pilha historico = new Pilha();
        Fila fila = new Fila();

        int opcao = 0;
        do {
            System.out.println("\n--- SISTEMA DE ATENDIMENTO ---");
            System.out.println("1 - Adicionar solicitação ao histórico (Pilha)");
            System.out.println("2 - Remover solicitação do histórico");
            System.out.println("3 - Exibir histórico");
            System.out.println("4 - Adicionar cliente à fila");
            System.out.println("5 - Atender próximo cliente");
            System.out.println("6 - Exibir fila");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            try {
                opcao = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Entrada inválida!");
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    System.out.print("ID da solicitação: ");
                    String id = sc.nextLine();
                    System.out.print("Descrição: ");
                    String desc = sc.nextLine();
                    System.out.print("Data e hora: ");
                    String data = sc.nextLine();
                    historico.empilhar(new Elemento(id, desc, data));
                    System.out.println("Solicitação adicionada ao histórico.");
                    break;

                case 2:
                    Elemento removidoPilha = historico.desempilhar();
                    if (removidoPilha != null)
                        System.out.println("Removido do histórico: " + removidoPilha.id);
                    break;

                case 3:
                    historico.exibir();
                    break;

                case 4:
                    System.out.print("ID do cliente: ");
                    String idCli = sc.nextLine();
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Motivo: ");
                    String motivo = sc.nextLine();
                    fila.enfileirar(new Elemento(idCli, nome, motivo));
                    System.out.println("Cliente adicionado à fila.");
                    break;

                case 5:
                    Elemento atendido = fila.desenfileirar();
                    if (atendido != null)
                        System.out.println("Cliente atendido: " + atendido.nomeOuDescricao);
                    break;

                case 6:
                    fila.exibir();
                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}
