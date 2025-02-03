import java.util.ArrayList;

public class Gerenciador {
    private ArrayList<Diretorio> diretorios;
    private Bloco[] memoriaPrincipal;

    public Gerenciador() {
        this.diretorios = new ArrayList<>();
        this.memoriaPrincipal = new Bloco [100];
        for(int i = 0; i < 100;i++){
            this.memoriaPrincipal[i] = new Bloco(); //populando array memoria
        }
    }


    public ArrayList<Diretorio> getDiretorios() {
        return this.diretorios;
    }

    public void setDiretorios(ArrayList<Diretorio> diretorios) {
        this.diretorios = diretorios;
    }

    public Bloco[] getMemoriaPrincipal() {
        return this.memoriaPrincipal;
    }

    public void setMemoriaPrincipal(Bloco[] memoriaPrincipal) {
        this.memoriaPrincipal = memoriaPrincipal;
    }

    public void printBlocos(Arquivo a){
        System.out.println("Blocos ocupados por " + a.getNome()+": \n");
        Bloco atual = a.getCabeca();
        int i;
        while(atual.isUltimo() == false){
            for(i = 0; i < this.getMemoriaPrincipal().length;i++){
                if (atual == this.getMemoriaPrincipal()[i]){
                    break;
                }
            }
            System.out.print(i + ", ");
            atual = atual.getNext();
        }
        for(i = 0; i < this.getMemoriaPrincipal().length;i++){
                if (atual == this.getMemoriaPrincipal()[i]){
                    break;
                }
            }
        System.out.print(i);
    }

     public static void main(String[] args) {
        Gerenciador raiz = new Gerenciador();
        Diretorio D1 = new Diretorio("D1");
        Diretorio D2 = new Diretorio("D2");
        Diretorio D3 = new Diretorio("D3");
        raiz.getDiretorios().add(D1);
        raiz.getDiretorios().add(D2);
        raiz.getDiretorios().add(D3);
        
        D1.getConteudo().add(new Arquivo("texto1.txt", 20, raiz.getMemoriaPrincipal()));
        D1.getConteudo().add(new Arquivo("texto2.txt", 3, raiz.getMemoriaPrincipal()));
        D1.getConteudo().add(new Arquivo("texto3.txt", 23, raiz.getMemoriaPrincipal()));
        D1.printDir();
        D1.delArq(0);
        System.out.println("\n\n\n");
        D1.getConteudo().add(new Arquivo("texto4.txt", 5, raiz.getMemoriaPrincipal()));
        D1.getConteudo().add(new Arquivo("texto5.txt", 10, raiz.getMemoriaPrincipal()));
        D1.printDir();
        System.out.println("\n\n\n");
        D2.getConteudo().add(new Arquivo("livro.pdf", 15, raiz.getMemoriaPrincipal()));
        raiz.printBlocos(D2.getConteudo().get(0));
     }
}
