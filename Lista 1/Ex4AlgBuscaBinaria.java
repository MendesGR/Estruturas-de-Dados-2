import java.util.Arrays;
import java.util.Scanner;

public class Ex4AlgBuscaBinaria {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int chaveBusca, tamanho = 100000;
        int[] vetor = new int[tamanho];

        PreencherVetor(vetor);

        System.out.print("Digite o valor a ser buscado no vetor: ");
        chaveBusca = scan.nextInt();

        // Chamando a função para realizar a busca binária
        long inicio = System.currentTimeMillis();
        int resultadoBin = BuscaBinaria(vetor, chaveBusca);

        System.out.println();

        // Exibindo o resultado da busca binária
        if (resultadoBin != -1) {
            System.out.println("Valor encontrado no índice (Busca Binária) " + resultadoBin + " do vetor");
        } else {
            System.out.println("Valor não encontrado no vetor (Busca Binária).");
        }

        long fim = System.currentTimeMillis();

        long tempoTotal = fim - inicio;
        System.out.println("Vetor desordenado.");
        TempoBusca(tempoTotal);

        Arrays.sort(vetor);

        long inicio2 = System.currentTimeMillis();
        int resultadoBin2 = BuscaBinaria(vetor, chaveBusca);

        System.out.println();

        // Exibindo o resultado da busca binária
        if (resultadoBin2 != -1) {
            System.out.println("Valor encontrado no índice (Busca Binária) " + resultadoBin2 + " do vetor");
        } else {
            System.out.println("Valor não encontrado no vetor (Busca Binária).");
        }

        long fim2 = System.currentTimeMillis();

        long tempoTotal2 = fim2 - inicio2;
        System.out.println("Vetor ordenado.");
        TempoBusca(tempoTotal2);

        scan.close();
    }

    public static int BuscaBinaria(int[] vetor, int chaveBusca) {
        int posInicial = 0;
        int posFinal = vetor.length - 1;

        while (posInicial <= posFinal) {
            int posMeio = (posInicial + posFinal) / 2;

            if (vetor[posMeio] == chaveBusca)
                return posMeio;
            else if (chaveBusca < vetor[posMeio])
                posFinal = posMeio - 1;
            else if (chaveBusca > vetor[posMeio])
                posInicial = posMeio + 1;
        }

        return -1;
    }

    public static void TempoBusca(long tempoTotal) {
        long minutos = tempoTotal / 60000; // 60.000ms = 1 min
        long segundos = (tempoTotal % 60000) / 1000;
        long milissegundos = tempoTotal % 1000;

        System.out.printf("Tempo da busca: %2d min, %2d seg, %3d ms%n", minutos, segundos, milissegundos);
        System.out.println();
    }

    public static void PreencherVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * 100001);
        }
    }

}
