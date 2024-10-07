import java.util.Scanner;

public class Ex1BuscaSequencial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] vetor = new int[100];
        int chaveBusca;
        PreencherVetor(vetor);

        System.out.print("Digite o valor a ser buscado no vetor: ");
        chaveBusca = scan.nextInt();
        System.out.println();

        // chamando a funcao para realizar a busca linear(sequencial)
        int resultado = BuscaSequencial(vetor, chaveBusca);

        // Exibindo o que esta na variavel resultado (resultado da busca)
        if (resultado != -1) {
            System.out.println("Valor encontrado no índice: " + resultado);
        } else {
            System.out.println("Valor não encontrado no vetor.");
        }
        System.out.println();

        // imprimir o vetor
        System.out.println("==========Vetor==========");
        System.out.println();
        for (int valor : vetor) {
            System.out.print("Valor:" + valor + "  ");
        }
        System.out.println();

        scan.close();
    }

    // funcao de busca linear(busca sequencial)
    public static int BuscaSequencial(int[] vetor, int chaveBusca) {
        int i = 0;
        while (i < vetor.length) {
            if (vetor[i] == chaveBusca) {
                return i;
            }
            i++;
        }
        return -1;
    }

    // funcao para preencher um vetor de 0 a 99 valores aleatorios
    public static void PreencherVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * 100);
        }
    }

}