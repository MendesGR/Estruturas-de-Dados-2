import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ex2Buscas {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] vetor = new int[100];
        int chaveBusca;

        PreencherVetor(vetor);

        System.out.print("Digite o valor a ser buscado no vetor: ");
        chaveBusca = scan.nextInt();
        System.out.println();

        // Chamando a função para realizar a busca sequencial
        List<Integer> resultadoSeq = BuscaSequencial(vetor, chaveBusca);

        // Exibindo o resultado da busca sequencial
        if (!resultadoSeq.isEmpty()) {
            System.out.println("Valor encontrado no(s) índice(s) (Busca Sequencial): " + resultadoSeq);
            System.out.println("========== Vetor Nao Ordenado ==========");

            for (int valor : vetor) {
                System.out.print(valor + " ");
            }
            System.out.println();
        } else {
            System.out.println("Valor não encontrado no vetor (Busca Sequencial).");
            resultadoSeq.clear();
        }

        // Ordenar o vetor para a busca binária
        Arrays.sort(vetor);

        // Chamando a função para realizar a busca binária
        List<Integer> resultadoBin = BuscaBinaria(vetor, chaveBusca);
        System.out.println();

        // Exibindo o resultado da busca binária
        if (!resultadoBin.isEmpty()) {
            System.out.println("Valor encontrado no(s) índice(s) (Busca Binária): " + resultadoBin);
            System.out.println("========== Vetor Ordenado ==========");

            for (int valor : vetor) {
                System.out.print(valor + " ");
            }
            System.out.println();
        } else {
            System.out.println("Valor não encontrado no vetor (Busca Binária).");
            resultadoBin.clear();
        }

        scan.close();
    }

    // Função de busca sequencial que retorna uma lista com todas as ocorrências
    public static List<Integer> BuscaSequencial(int[] vetor, int chaveBusca) {
        List<Integer> posicoes = new ArrayList<>();
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == chaveBusca) {
                posicoes.add(i);
            }
        }
        return posicoes;
    }

    // Função de busca binária que retorna uma lista com todas as ocorrências
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

    // Função para preencher um vetor de 0 a 99 com valores aleatórios
    public static void PreencherVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * 100);
        }
    }
}
