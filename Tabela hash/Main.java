public class Main {
    public static void main(String[] args) {
        TabelaHash tabela = new TabelaHash();
        tabela.imprimir();

        Aluno a1 = new Aluno(17354, "Jack");

        tabela.put(a1.getMatricula(), a1);
        tabela.imprimir();
    }
}
