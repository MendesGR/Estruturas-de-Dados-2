public interface ITabelaHash {
    public Aluno hash(int chave);

    public void put(int chave, Aluno elemento);

    public Aluno get(int chave);

    public Aluno remove(int chave);

    public void imprimir();
}
