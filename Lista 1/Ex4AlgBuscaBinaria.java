import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        List<Integer> resultadoBin = BuscaBinaria(vetor, chaveBusca);

        System.out.println();

        // Exibindo o resultado da busca binária
        if (!resultadoBin.isEmpty()) {
            System.out.println("Valor encontrado no(s) índice(s) (Busca Binária) " + resultadoBin + " do vetor");
        } else {
            System.out.println("Valor não encontrado no vetor (Busca Binária).");
            resultadoBin.clear();
        }

        long fim = System.currentTimeMillis();

        long tempoTotal = fim - inicio;
        System.out.println("Vetor desordenado.");
        TempoBusca(tempoTotal);

        Arrays.sort(vetor);

        long inicio2 = System.currentTimeMillis();
        List<Integer> resultadoBin2 = BuscaBinaria(vetor, chaveBusca);

        System.out.println();

        // Exibindo o resultado da busca binária
        if (!resultadoBin2.isEmpty()) {
            System.out.println("Valor encontrado no(s) índice(s) (Busca Binária) " + resultadoBin2 + " do vetor");
        } else {
            System.out.println("Valor não encontrado no vetor (Busca Binária).");
            resultadoBin2.clear();
        }

        long fim2 = System.currentTimeMillis();

        long tempoTotal2 = fim2 - inicio2;
        System.out.println("Vetor ordenado.");
        TempoBusca(tempoTotal2);

        scan.close();
    }

    public static List<Integer> BuscaBinaria(int[] vetor, int chaveBusca) {
        List<Integer> posicoes = new ArrayList<>();

        int posInicial = 0;
        int posFinal = vetor.length - 1;

        // Busca o primeiro índice da ocorrência usando busca binária padrão
        while (posInicial <= posFinal) {
            int posMeio = (posInicial + posFinal) / 2;

            if (vetor[posMeio] == chaveBusca) {
                // Encontrou a chave, agora procura todas as ocorrências
                posicoes.add(posMeio);

                // Procura à esquerda para outras ocorrências
                int esquerda = posMeio - 1;

                while (esquerda >= 0 && vetor[esquerda] == chaveBusca) {
                    posicoes.add(esquerda);
                    esquerda--;
                }

                // Procura à direita para outras ocorrências
                int direita = posMeio + 1;

                while (direita < vetor.length && vetor[direita] == chaveBusca) {
                    posicoes.add(direita);
                    direita++;
                }
                break;

            } else if (chaveBusca < vetor[posMeio]) {
                posFinal = posMeio - 1;
            } else {
                posInicial = posMeio + 1;
            }
        }

        // Ordena a lista de posições
        posicoes.sort(null);
        return posicoes;
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
