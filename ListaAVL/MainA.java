public class MainA {
    public static void main(String[] args) {
        System.out.println("Arvore apos as insercoes");
        funcaoLetraA();
        System.out.println();
        System.out.println("Arvore apos as remocoes");
        funcaoLetraB();
    }

    public static void funcaoLetraA() {
        AVL tree = new AVL();

        tree.inserir(50);
        tree.inserir(1);
        tree.inserir(64);
        tree.inserir(12);
        tree.inserir(18);
        tree.inserir(66);
        tree.inserir(38);
        tree.inserir(95);
        tree.inserir(58);
        tree.inserir(59);
        tree.inserir(70);
        tree.inserir(68);
        tree.inserir(39);
        tree.inserir(62);
        tree.inserir(7);
        tree.inserir(60);
        tree.inserir(43);
        tree.inserir(16);
        tree.inserir(67);
        tree.inserir(34);
        tree.inserir(35);
        tree.imprimirEmOrdem();
        tree.printTree();
    }

    public static void funcaoLetraB() {
        AVL tree2 = new AVL();

        tree2.inserir(50);
        tree2.inserir(1);
        tree2.inserir(64);
        tree2.inserir(12);
        tree2.inserir(18);
        tree2.inserir(66);
        tree2.inserir(38);
        tree2.inserir(95);
        tree2.inserir(58);
        tree2.inserir(59);
        tree2.inserir(70);
        tree2.inserir(68);
        tree2.inserir(39);
        tree2.inserir(62);
        tree2.inserir(7);
        tree2.inserir(60);
        tree2.inserir(43);
        tree2.inserir(16);
        tree2.inserir(67);
        tree2.inserir(34);
        tree2.inserir(35);

        // 50,95,70,60,35
        tree2.remover(50);
        tree2.remover(95);
        tree2.remover(70);
        tree2.remover(60);
        tree2.remover(35);
        tree2.imprimirEmOrdem();
        tree2.printTree();
    }

}