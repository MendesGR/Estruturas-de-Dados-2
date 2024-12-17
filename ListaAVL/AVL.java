import java.util.Stack;

public class AVL {
    public No raiz;

    public AVL() {
        this.raiz = null;
    }

    public No getRaiz() {
        return this.raiz;
    }

    public boolean isFolha(No no) {
        if (no.esq == null && no.dir == null) {
            return true;
        }
        return false;
    }

    public int getFatorBalanceamento(No no) {
        if (no == null) {
            return 0;
        }
        return altura(no.esq) - altura(no.dir);
    }

    public int altura() {
        return this.altura(raiz);
    }

    private int altura(No no) {
        if (no == null)
            return 0;
        return no.alt;
    }

    public void atualizarAltura(No no) {
        if (no != null)
            no.alt = 1 + Math.max(altura(no.esq), altura(no.dir));
    }

    public No rotacaoDireita(No A) {
        No B = A.esq;
        No Bdir = B.dir;

        B.dir = A;
        A.esq = Bdir;

        atualizarAltura(A);
        atualizarAltura(B);

        return B;
    }

    public No rotacaoEsquerda(No A) {
        No B = A.dir;
        No Besq = B.esq;

        B.esq = A;
        A.dir = Besq;

        atualizarAltura(A);
        atualizarAltura(B);

        return B;
    }

    private No rebalancear(No no) {
        int fatorBalanceamento = getFatorBalanceamento(no);

        if (fatorBalanceamento > 1 && getFatorBalanceamento(no.esq) >= 0) {
            return rotacaoDireita(no);
        }

        if (fatorBalanceamento > 1 && getFatorBalanceamento(no.esq) < 0) {
            no.esq = rotacaoEsquerda(no.esq);
            return rotacaoDireita(no);
        }

        if (fatorBalanceamento < -1 && getFatorBalanceamento(no.dir) <= 0) {
            return rotacaoEsquerda(no);
        }

        if (fatorBalanceamento < -1 && getFatorBalanceamento(no.dir) > 0) {
            no.dir = rotacaoDireita(no.dir);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    public void inserir(int valor) {
        if (this.raiz == null) {
            this.raiz = new No(valor);
        } else {
            inserir(this.raiz, valor);
        }
    }

    private No inserir(No noRaiz, int valor) {
        if (noRaiz == null) {
            return new No(valor);
        }

        if (valor < noRaiz.valor) {
            noRaiz.esq = inserir(noRaiz.esq, valor);
        } else if (valor > noRaiz.valor) {
            noRaiz.dir = inserir(noRaiz.dir, valor);
        } else {
            return noRaiz;
        }
        atualizarAltura(noRaiz);
        return rebalancear(noRaiz);
    }

    public boolean buscar(int valor) {
        return buscar(valor, raiz);
    }

    private boolean buscar(int valor, No raiz) {
        if (raiz == null) {
            return false;
        }
        if (raiz.valor == valor) {
            return true;
        }
        if (valor < raiz.valor) {
            return buscar(valor, raiz.esq);
        } else {
            return buscar(valor, raiz.dir);
        }
    }

    public void remover(int valor) {
        raiz = remover(this.raiz, valor);
    }

    private No remover(No noRaiz, int valor) {
        if (noRaiz == null) {
            return null;
        }
        if (valor < noRaiz.valor)
            noRaiz.esq = remover(noRaiz.esq, valor);
        else if (valor > noRaiz.valor)
            noRaiz.dir = remover(noRaiz.dir, valor);
        else {
            if (noRaiz.esq == null && noRaiz.dir == null) {
                return null;
            } else if (noRaiz.esq == null || noRaiz.dir == null) {
                if (noRaiz.esq != null)
                    noRaiz = noRaiz.esq;
                else
                    noRaiz = noRaiz.dir;
            } else {
                No temp = min(noRaiz.dir);
                noRaiz.valor = temp.valor;
                noRaiz.dir = remover(noRaiz.dir, temp.valor);
            }
        }
        atualizarAltura(noRaiz);
        return rebalancear(noRaiz);
    }

    private No min(No raiz) {
        if (raiz == null)
            return raiz;
        if (raiz.esq != null) {
            return min(raiz.esq);
        }
        return raiz;
    }

    private No max(No raiz) {
        if (raiz == null)
            return raiz;

        if (raiz.dir != null) {
            return max(raiz.dir);
        }
        return raiz;
    }

    public void imprimirPreOrdem() {
        this.imprimirPreOrdem(this.raiz);

    }

    private void imprimirPreOrdem(No raiz) {
        if (raiz != null) {
            imprimirPreOrdem(raiz.esq);
            System.out.print(raiz.valor + " ");
            imprimirPreOrdem(raiz.dir);

        }
    }

    public void imprimirEmOrdem() {
        this.imprimirEmOrdem(this.raiz);
    }

    private void imprimirEmOrdem(No raiz) {
        if (raiz != null) {
            imprimirEmOrdem(raiz.esq);
            System.out.print(raiz.valor + " ");
            imprimirEmOrdem(raiz.dir);

        }
    }

    public void imprimirPosOrdem() {
        this.imprimirPosOrdem(this.raiz);
    }

    private void imprimirPosOrdem(No raiz) {
        if (raiz != null) {
            imprimirPosOrdem(raiz.esq);
            System.out.print(raiz.valor + " ");
            imprimirPosOrdem(raiz.dir);

        }
    }

    public int nivelElemento(int valor) {
        return nivelElemento(this.raiz, valor, 0);
    }

    private int nivelElemento(No raiz, int valor, int nivel) {
        if (raiz == null)
            return -1;

        if (raiz.valor == valor)
            return nivel;

        if (valor < raiz.valor) {
            return nivelElemento(raiz.esq, valor, nivel + 1);
        } else {
            return nivelElemento(raiz.dir, valor, nivel + 1);
        }

    }

    public int getQtdNos() {
        return this.getQtdNos(this.raiz);
    }

    private int getQtdNos(No raiz) {
        if (raiz == null) {
            return 0;
        }

        return 1 + getQtdNos(raiz.esq) + getQtdNos(raiz.dir);
    }

    public int getQtdFolhas() {
        return this.getQtdFolhas(this.raiz);
    }

    private int getQtdFolhas(No raiz) {
        if (raiz == null) {
            return 0;
        }

        if (isFolha(raiz))
            return 1;
        else
            return getQtdFolhas(raiz.esq) + getQtdFolhas(raiz.dir);
    }

    public void printTree() {
        Stack globalStack = new Stack();
        globalStack.push(raiz);
        int gaps = 32;
        boolean isRowEmpty = false;
        String separator = "-----------------------------------------------------------------";
        System.out.println(separator);
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) {
                No temp = (No) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.valor);
                    localStack.push(temp.esq);
                    localStack.push(temp.dir);
                    if (temp.esq != null || temp.dir != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("__");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            gaps /= 2;
            while (localStack.isEmpty() == false) {
                globalStack.push(localStack.pop());
            }
        }
        System.out.println(separator);
    }
}