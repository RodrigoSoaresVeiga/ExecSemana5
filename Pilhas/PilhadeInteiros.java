import java.util.Scanner;

class Pilha {
    private int topo;
    private int[] elementos;
    private int capacidade;

    public Pilha(int capacidade) {
        this.capacidade = capacidade;
        this.elementos = new int[capacidade];
        this.topo = -1;
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public boolean isFull() {
        return topo == capacidade - 1;
    }

    public void push(int elemento) {
        if (isFull()) {
            System.out.println("Erro: Pilha cheia!");
            return;
        }
        elementos[++topo] = elemento;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Erro: Pilha vazia!");
            return -1;
        }
        return elementos[topo--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Erro: Pilha vazia!");
            return -1;
        }
        return elementos[topo];
    }

    public void imprimirPilha() {
        System.out.print("Pilha: ");
        for (int i = 0; i <= topo; i++) {
            System.out.print(elementos[i] + " ");
        }
        System.out.println();
    }
}

public class TestePilha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite a capacidade da pilha: ");
        int capacidade = scanner.nextInt();
        Pilha pilha = new Pilha(capacidade);
        
        System.out.print("Digite o número de elementos a empilhar: ");
        int n = scanner.nextInt();
        
        for (int i = 0; i < n; i++) {
            System.out.print("Digite um número para empilhar: ");
            int num = scanner.nextInt();
            pilha.push(num);
        }
        
        pilha.imprimirPilha();
        
        System.out.println("Topo da pilha: " + pilha.peek());
        
        System.out.println("Desempilhando: " + pilha.pop());
        pilha.imprimirPilha();
        
        scanner.close();
    }
}
