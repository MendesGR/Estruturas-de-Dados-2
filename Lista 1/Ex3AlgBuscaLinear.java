import java.util.Scanner;

public class Ex3AlgBuscaLinear {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int chaveBusca, tamanho = 100000;
        int[] vetor = new int[tamanho];

        PreencherVetor(vetor);

        System.out.print("Digite o valor a ser buscado no vetor: ");
        chaveBusca = scan.nextInt();
        System.out.println();

        // chamando a funcao para realizar a busca linear(sequencial) contar o tempo
        long inicio = System.currentTimeMillis();
        int resultado = BuscaSequencial(vetor, chaveBusca);

        // Exibindo o que esta na variavel resultado (resultado da busca)
        if (resultado != -1) {
            System.out.println("Valor encontrado no índice " + resultado + " do vetor.");
        } else {
            System.out.println("Valor não encontrado no vetor.");
        }
        long fim = System.currentTimeMillis();

        long tempoTotal = fim - inicio;
        TempoBusca(tempoTotal);

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

    // funcao para preencher um vetor de 0 a 100000 valores aleatorios
    public static void PreencherVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * 100001);
        }
    }

    public static void TempoBusca(long tempoTotal) {
        long minutos = tempoTotal / 60000; // 60.000ms = 1 min
        long segundos = (tempoTotal % 60000) / 1000;
        long milissegundos = tempoTotal % 1000;

        System.out.printf("Tempo da busca: %2d min, %2d seg, %2d ms%n", minutos, segundos, milissegundos);
        System.out.println();
    }

}