package Paginacao;

import java.util.ArrayList;
import java.util.Scanner;

public class Processo {
    private String nome;
    private int id;
    private int tamanho;

    public ArrayList<Pagina> paginas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public ArrayList<Pagina> getPaginas() {
        return paginas;
    }

    public void setPaginas(ArrayList<Pagina> paginas) {
        this.paginas = paginas;
    }

    public Processo(String nome, int id, int tamanho) {
        this.nome = nome;
        this.id = id;
        this.tamanho = tamanho;
        this.paginas = new ArrayList<>();
    }

    public Processo(){
        Scanner in = new Scanner(System.in);
        System.out.println("Digite uma String para ser o nome do processo: ");
        this.nome = in.nextLine();
        System.out.println("Digite um valor inteiro para ser o ID do processo: ");
        this.id = in.nextInt();
        System.out.println("Digite um valor inteiro para ser o tamanho do processo: ");
        this.tamanho = in.nextInt();
        this.paginas = new ArrayList<>();
    }
}
