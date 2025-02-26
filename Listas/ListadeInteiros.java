import java.util.Scanner;

class ListaArray {
    private int[] array;
    private int tamanho;

    public ListaArray(int capacidade) {
        this.array = new int[capacidade];
        this.tamanho = 0;
    }

    public void adicionar(int elemento) {
        if (tamanho == array.length) {
            System.out.println("Erro: Lista cheia!");
            return;
        }
        array[tamanho++] = elemento;
    }

    public void adicionarEmPosicao(int elemento, int posicao) {
        if (posicao < 0 || posicao > tamanho || tamanho == array.length) {
            System.out.println("Erro: Posição inválida ou lista cheia!");
            return;
        }
        for (int i = tamanho; i > posicao; i--) {
            array[i] = array[i - 1];
        }
        array[posicao] = elemento;
        tamanho++;
    }

    public void remover(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            System.out.println("Erro: Posição inválida!");
            return;
        }
        for (int i = posicao; i < tamanho - 1; i++) {
            array[i] = array[i + 1];
        }
        tamanho--;
    }

    public void imprimirLista() {
        System.out.print("Lista: ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

public class TesteLista {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite a capacidade da lista: ");
        int capacidade = scanner.nextInt();
        ListaArray lista = new ListaArray(capacidade);
        
        System.out.print("Digite o número de elementos a adicionar: ");
        int n = scanner.nextInt();
        
        for (int i = 0; i < n; i++) {
            System.out.print("Digite um número para adicionar à lista: ");
            int num = scanner.nextInt();
            lista.adicionar(num);
        }
        
        lista.imprimirLista();
        
        System.out.print("Digite a posição onde deseja adicionar um elemento: ");
        int posicao = scanner.nextInt();
        System.out.print("Digite o elemento para adicionar nesta posição: ");
        int elemento = scanner.nextInt();
        lista.adicionarEmPosicao(elemento, posicao);
        
        lista.imprimirLista();
        
        System.out.print("Digite a posição do elemento a ser removido: ");
        int posRemover = scanner.nextInt();
        lista.remover(posRemover);
        
        lista.imprimirLista();
        
        scanner.close();
    }
}
