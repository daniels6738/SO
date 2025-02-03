import java.util.ArrayList;

public class GerenciadorRAID {
    private ArrayList<DiretorioRAID> diretorios;
    private Bloco[] disco1;
    private Bloco[] disco2;

    public GerenciadorRAID() {
        this.diretorios = new ArrayList<>();
        this.disco1 = new Bloco[100];
        this.disco2 = new Bloco[100];
        for(int i = 0; i < 100;i++){
            this.disco1[i] = new Bloco(); //populando array memoria
        }
        for(int i = 0; i < 100;i++){
            this.disco2[i] = new Bloco(); //populando array memoria
        }
    }


    public ArrayList<DiretorioRAID> getDiretorios() {
        return this.diretorios;
    }

    public void setDiretorios(ArrayList<DiretorioRAID> diretorios) {
        this.diretorios = diretorios;
    }

    public Bloco[] getDisco1() {
        return this.disco1;
    }

    public void setDisco1(Bloco[] disco1) {
        this.disco1 = disco1;
    }

    public Bloco[] getDisco2() {
        return this.disco2;
    }

    public void setDisco2(Bloco[] disco2) {
        this.disco2 = disco2;
    }

    

    public void printBlocos(ArquivoRAID a){
        System.out.println("Blocos ocupados por " + a.getNome()+": \n");
        Bloco atual = a.getCabeca();
        int i;
        while(atual.isUltimo() == false){
            for(i = 0; i < this.getDisco1().length;i++){ //assumindo que ambos os discos tem mesmo tamanho
                if (atual == this.getDisco1()[i]){
                    System.out.print(i + "(1), ");
                    break;
                } else if(atual == this.getDisco2()[i]){
                    System.out.print(i + "(2), ");
                    break;
                }
            }
            atual = atual.getNext();
        }
        for(i = 0; i < this.getDisco1().length;i++){
                if (atual == this.getDisco1()[i]){
                    if (atual == this.getDisco1()[i]){
                        System.out.print(i + "(1), ");
                        break;
                    } else if(atual == this.getDisco2()[i]){
                        System.out.print(i + "(2), ");
                        break;
                    }
                }
            }
    }

     public static void main(String[] args) {
        GerenciadorRAID raiz = new GerenciadorRAID();
        DiretorioRAID D1 = new DiretorioRAID("D1");
        DiretorioRAID D2 = new DiretorioRAID("D2");
        DiretorioRAID D3 = new DiretorioRAID("D3");
        raiz.getDiretorios().add(D1);
        raiz.getDiretorios().add(D2);
        raiz.getDiretorios().add(D3);
        
        D1.getConteudo().add(new ArquivoRAID("texto1.txt", 20, raiz.getDisco1(), raiz.getDisco2()));
        D1.getConteudo().add(new ArquivoRAID("texto2.txt", 3, raiz.getDisco1(), raiz.getDisco2()));
        D1.getConteudo().add(new ArquivoRAID("texto3.txt", 23, raiz.getDisco1(), raiz.getDisco2()));
        D1.printDir();
        D1.delArq(0);
        System.out.println("\n\n\n");
        D1.getConteudo().add(new ArquivoRAID("texto4.txt", 5, raiz.getDisco1(), raiz.getDisco2()));
        D1.getConteudo().add(new ArquivoRAID("texto5.txt", 10, raiz.getDisco1(), raiz.getDisco2()));
        D1.printDir();
        System.out.println("\n\n\n");
        D2.getConteudo().add(new ArquivoRAID("livro.pdf", 15, raiz.getDisco1(), raiz.getDisco2()));
        raiz.printBlocos(D2.getConteudo().get(0));
     }
}
