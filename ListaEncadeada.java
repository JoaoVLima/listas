/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrey
 */
public class ListaEncadeada {
    // Classe interna para representar um nó
    class No {
        int dado; // Dado armazenado no nó
        No proximo; // Referência para o próximo nó

        // Construtor do nó
        No(int elemento) {
            this.dado = elemento;
            this.proximo = null;
        }
    }

    No inicio = null; // Referência para o primeiro nó da lista

    // Método para inserir um elemento no final da lista
    public void insereElemento(int elemento) {
        No novoNo = new No(elemento); // Cria um novo nó
        if (inicio == null) {
            inicio = novoNo; // Lista está vazia, o início aponta para o novo nó
        } else {
            No atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo; // Percorre até o final
            }
            atual.proximo = novoNo; // Insere o novo nó no final
        }
    }

    // Método para remover um elemento da lista
    public void removeElemento(int valor) {
        if (inicio == null) {
            System.out.println("Erro: Lista vazia");
            return;
        }

        // Caso especial: remover o primeiro nó
        if (inicio.dado == valor) {
            inicio = inicio.proximo; // O início aponta para o próximo nó
            return;
        }

        // Percorre a lista para encontrar o nó
        No atual = inicio;
        while (atual.proximo != null) {
            if (atual.proximo.dado == valor) {
                atual.proximo = atual.proximo.proximo; // Ajusta o ponteiro do nó anterior
                return;
            }
            atual = atual.proximo; // Avança para o próximo nó
        }

        System.out.println("Erro: Elemento não encontrado");
    }

    // Método para exibir os elementos da lista
    public void exibeLista() {
        No atual = inicio;
        System.out.print("Lista: ");
        while (atual != null) {
            System.out.print(atual.dado + " ");
            atual = atual.proximo; // Move para o próximo nó
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();

        // Inserindo elementos
        lista.insereElemento(10);
        lista.insereElemento(20);
        lista.insereElemento(30);
        lista.insereElemento(40);

        lista.exibeLista(); // Deve exibir: Lista: 10 20 30 40

        // Removendo elementos
        lista.removeElemento(20); // Remove o elemento 20
        lista.exibeLista(); // Deve exibir: Lista: 10 30 40

        lista.removeElemento(10); // Remove o elemento 10 (primeiro elemento)
        lista.exibeLista(); // Deve exibir: Lista: 30 40

        lista.removeElemento(50); // Tenta remover um elemento inexistente
    }
}

