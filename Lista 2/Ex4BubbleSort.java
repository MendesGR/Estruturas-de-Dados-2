import java.util.Random;

public class Ex4BubbleSort {
    public static void main(String[] args) {
        int tamanho = 100000;
        int maxVal = 100000;
        int repeticoes = 10;

        long[] tempos = new long[repeticoes];

        for (int i = 0; i < repeticoes; i++) {
            int[] vetor = gerarVetorAleatorio(tamanho, maxVal);

            // Medir tempo de execução da versão otimizada do BubbleSort
            long comeco = System.nanoTime();
            bubbleSortOtimizado(vetor);
            long fim = System.nanoTime();
            tempos[i] = fim - comeco;
        }

        // Exibir os resultados
        printResults(tempos);
    }

    // Método que gera um array de inteiros aleatórios
    public static int[] gerarVetorAleatorio(int tamanho, int maxVal) {
        int[] vetor = new int[tamanho];
        Random rand = new Random();

        for (int i = 0; i < tamanho; i++) {
            vetor[i] = rand.nextInt(maxVal);
        }

        return vetor;
    }

    // Versão otimizada do BubbleSort
    public static void bubbleSortOtimizado(int[] vetor) {
        int n = vetor.length;
        boolean troca;

        for (int i = 0; i < n - 1; i++) {
            troca = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];

                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;

                    troca = true;
                }
            }

            if (!troca)
                break;

        }
    }

    public static void printResults(long[] tempos) {
        System.out.printf("%-10s%15s\n", "Execução", "Tempo (ms)");
        for (int i = 0; i < tempos.length; i++) {
            System.out.printf("%-10d%15.3f\n", (i + 1), tempos[i] / 1_000_000.0);
        }
    }
}
