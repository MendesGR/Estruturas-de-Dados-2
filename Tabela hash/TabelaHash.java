public class TabelaHash implements ITabelaHash {
    public static void main(String[] args) {

    private Aluno[] tabela;

    public TabelaHash() {
        this.tabela = new Aluno[7];
    }

    // @Override
    // public Aluno get(int chave) {}

    // @Override
    // public Aluno hash(int chave) {}

    // @Override
    // public void put(int chave, Aluno elemento) {
    // int posicao = this.hash(chave)

    // @Override
    // public Aluno remove(int chave) {}

    // @Override
    // public void imprimir(){}

    @Override
    public Aluno hash(int chave) {
        // retorna um range de 0 a 108
        return chave % tabela.length;
    }

    @Override
    public void put(int chave, Aluno elemento) {
        // gera a posição baseando na chave, adicionar elemento na posição calculada
        int posicao = this.hash(chave);
        this.tabela[posicao] = elemento;
    }

    @Override
    public Aluno get(int chave) {
        // gera posição baseado na chave, retorna o elemento na posição calculada
        int posicao = this.hash(chave);
        return this.tabela[posicao];
    }

    @Override
    public Aluno remove(int chave) {
        // gera a posição baseado na chave, remove o elemento na posição calculada,
        // retorna o elemento removido
        int posicao = this.hash(chave);
        int elemento = this.tabela[posicao];
        this.tabela[posicao] = null;
        return elemento;
    }

    @Override
    public void imprimir() {
        System.out.println("====Tabela Hash ====");
        for (int i = 0; i < this.tabela.length; i++) {
            if (this.tabela[i] == null) {
                System.out.println("Posicao " + i + ": Vazia");
            } else {
                System.out.println("Posicao " + i + ": ");
            }
        }
    }
}
