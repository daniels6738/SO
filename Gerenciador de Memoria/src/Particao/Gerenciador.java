package Particao;

import java.util.ArrayList;
import java.util.Scanner;

public class Gerenciador {
    private int tamanhoMax;
    private int tamanhoParticao;
    private ArrayList<Processo> memPrincipal;
    private ArrayList<Processo> memSecundaria;

    public int getTamanhoMax() {
        return tamanhoMax;
    }

    public void setTamanhoMax(int tamanhoMax) {
        this.tamanhoMax = tamanhoMax;
    }

    public int getTamanhoParticao() {
        return tamanhoParticao;
    }

    public void setTamanhoParticao(int tamanhoParticao) {
        this.tamanhoParticao = tamanhoParticao;
    }


    public ArrayList<Processo> getMemSecundaria() {
        return memSecundaria;
    }

    public void setMemSecundaria(ArrayList<Processo> memSecundaria) {
        this.memSecundaria = memSecundaria;
    }

    public ArrayList<Processo> getMemPrincipal() {
        return memPrincipal;
    }

    public void setMemPrincipal(ArrayList<Processo> memPrincipal) {
        this.memPrincipal = memPrincipal;
    }

    public Gerenciador(){
        Scanner in = new Scanner(System.in);
        System.out.println("Digite um valor inteiro para ser o tamanho máximo (em KB) da memória principal: ");
        this.tamanhoMax = in.nextInt();
        System.out.println("Digite um valor inteiro para ser o tamanho da partição (em KB) :");
        this.tamanhoParticao = in.nextInt();
        this.memPrincipal = new ArrayList<>();
        this.memSecundaria = new ArrayList<>();
    }

    public void printFrag(Gerenciador g){
        System.out.println("Estado da fragmentação: ");
        for(Processo p: g.getMemPrincipal()){
            System.out.println("Posição " + g.getMemPrincipal().indexOf(p)+"\nNome e ID: "+ p.getNome()+ " "+p.getId()+"\nMemória ocupada na partição: " + p.getTamanho()+
                    "KB\nMemória livre na partição: " + (g.getTamanhoParticao() - p.getTamanho())+"KB\n");
        }
        System.out.println("Partições restantes na memória: " + (((g.tamanhoMax - g.tamanhoParticao) - g.getMemPrincipal().size()) - 1));

    }


}
