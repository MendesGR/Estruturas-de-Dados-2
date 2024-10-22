import java.util.Arrays;
import java.util.Random;

public class Ex2AlgoritmosOrdenacao {
    public static void main(String[] args) {
        int tamanho = 100000;
        int maxVal = 100000;
        int repeticoes = 10;

        long[][] tempos = new long[6][repeticoes];

        for (int i = 0; i < repeticoes; i++) {
            int[] vetorOriginal = gerarVetorAleatorio(tamanho, maxVal);

            // tempo do BubbleSort
            int[] vetor = Arrays.copyOf(vetorOriginal, vetorOriginal.length);
            long comeco = System.nanoTime();
            bubbleSort(vetor);
            tempos[0][i] = System.nanoTime() - comeco;

            // tempo do InsertionSort
            vetor = Arrays.copyOf(vetorOriginal, vetorOriginal.length);
            comeco = System.nanoTime();
            insertionSort(vetor);
            tempos[1][i] = System.nanoTime() - comeco;

            // tempo do SelectionSort
            vetor = Arrays.copyOf(vetorOriginal, vetorOriginal.length);
            comeco = System.nanoTime();
            selectionSort(vetor);
            tempos[2][i] = System.nanoTime() - comeco;

            // tempo do ShellSort
            vetor = Arrays.copyOf(vetorOriginal, vetorOriginal.length);
            comeco = System.nanoTime();
            shellSort(vetor);
            tempos[3][i] = System.nanoTime() - comeco;

            // tempo do MergeSort
            vetor = Arrays.copyOf(vetorOriginal, vetorOriginal.length);
            comeco = System.nanoTime();
            mergeSort(vetor, 0, vetor.length - 1);
            tempos[4][i] = System.nanoTime() - comeco;

            // tempo do QuickSort
            vetor = Arrays.copyOf(vetorOriginal, vetorOriginal.length);
            comeco = System.nanoTime();
            quickSort(vetor, 0, vetor.length - 1);
            tempos[5][i] = System.nanoTime() - comeco;
        }

        exibirResultados(tempos, repeticoes);
    }

    public static int[] gerarVetorAleatorio(int tamanho, int maxVal) {
        int[] vetor = new int[tamanho];
        Random rand = new Random();

        for (int i = 0; i < tamanho; i++) {
            vetor[i] = rand.nextInt(maxVal);
        }

        return vetor;
    }

    public static void bubbleSort(int[] vetor) {

        for (int i = 0; i < vetor.length - 1; i++) {
            for (int j = 0; j < vetor.length - i - 1; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];

                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }

        }

    }

    public static void insertionSort(int[] vetor) {
        for (int i = 1; i < vetor.length; i++) {
            int elemento = vetor[i];

            int j = i - 1;

            while (j >= 0 && vetor[j] > elemento) {
                vetor[j + 1] = vetor[j];
                j--;
            }

            vetor[j + 1] = elemento;
        }

    }

    public static void selectionSort(int[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            int pos_menor = i;

            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[pos_menor]) {
                    pos_menor = j;
                }
            }

            int aux = vetor[i];

            vetor[i] = vetor[pos_menor];
            vetor[pos_menor] = aux;
        }
    }

    public static void shellSort(int[] vetor) {
        int tamanho = vetor.length;
        int h = 1;

        while (h < tamanho) {
            h = 3 * h + 1;
        }

        while (h > 1) {
            h /= 3;
            for (int i = h; i < tamanho; i++) {
                int temp = vetor[i];
                int j = i - h;
                while (j >= 0 && temp < vetor[j]) {
                    vetor[j + h] = vetor[j];
                    j -= h;
                }
                vetor[j + h] = temp;
            }

        }

    }

    public static void mergeSort(int[] vetor, int esq, int dir) {
        if (esq >= dir) {
            return;

        } else {
            int meio = (esq + dir) / 2;

            mergeSort(vetor, esq, meio);
            mergeSort(vetor, meio + 1, dir);

            merge(vetor, esq, meio, dir);
        }
    }

    public static void merge(int[] vetor, int esq, int meio, int dir) {
        int[] helper = new int[vetor.length];
        for (int i = esq; i <= dir; i++) {
            helper[i] = vetor[i];
        }

        int i = esq;
        int j = meio + 1;
        int k = esq;

        while (i <= meio && j <= dir) {
            if (helper[i] <= helper[j]) {
                vetor[k] = helper[i];
                i++;
            } else {
                vetor[k] = helper[j];
                j++;
            }

            k++;
        }

        while (i <= meio) {
            vetor[k] = helper[i];
            i++;
            k++;
        }
    }

    public static void quickSort(int[] vetor, int ini, int fim) {
        if (ini < fim) {
            int index_pivot = particionaHoare(vetor, ini, fim);
            quickSort(vetor, ini, index_pivot - 1);
            quickSort(vetor, index_pivot + 1, fim);
        }
    }

    public static int particionaHoare(int[] vetor, int ini, int fim) {
        int i = ini + 1;
        int j = fim;
        int pivot = vetor[ini];

        while (i <= j) {

            while (i <= j && vetor[i] <= pivot)
                i++;

            while (i <= j && vetor[j] > pivot)
                j = j - 1;

            if (i < j) {
                int temp = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = temp;
            }
        }

        int temp = vetor[ini];
        vetor[ini] = vetor[j];
        vetor[j] = temp;

        return j;
    }

    public static void exibirResultados(long[][] tempos, int repeticoes) {
        String[] algoritmos = { "BubbleSort", "InsertionSort", "SelectionSort", "ShellSort", "MergeSort", "QuickSort" };
        System.out.printf("%-12s", "Algoritmo");

        for (int i = 1; i <= repeticoes; i++) {
            System.out.printf("%10s", "Exec " + i);
        }

        System.out.println();

        for (int i = 0; i < tempos.length; i++) {
            System.out.printf("%-12s", algoritmos[i]);

            for (int j = 0; j < tempos[i].length; j++) {
                System.out.printf("%10d", tempos[i][j] / 1000000); // Exibir em milissegundos
            }

            System.out.println();
        }

    }

}
