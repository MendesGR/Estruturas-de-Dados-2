import java.util.ArrayList;
import java.util.Scanner;

public class Ex3InsertionSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> lista = new ArrayList<>();

        System.out.print("Digite a quantidade de valores a serem inseridos: ");
        int n = scanner.nextInt();
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print("Digite o valor " + (i + 1) + ": ");
            int valor = scanner.nextInt();

            inserirOrdenando(lista, valor);
            System.out.println("Lista ordenada: " + lista);
            System.out.println();
        }

        scanner.close();
    }

    public static void inserirOrdenando(ArrayList<Integer> lista, int valor) {
        lista.add(valor);
        int i = lista.size() - 1;

        // lógica do Insertion Sort para reposicionar o último elemento
        while (i > 0 && lista.get(i - 1) > valor) {
            lista.set(i, lista.get(i - 1));
            i--;
        }

        lista.set(i, valor);
    }

}