package Paginacao;

import java.util.ArrayList;
import java.util.Scanner;

public class Gerenciador {
    private int tamanhoMemFis;
    private int tamanhoMemVir;
    private ArrayList<Pagina> memPri;
    private int tamanhoPagina;
    private ArrayList<Pagina> memSec;

    public ArrayList<Pagina> getMemSec() {
        return memSec;
    }

    public void setMemSec(ArrayList<Pagina> memSec) {
        this.memSec = memSec;
    }

    public int getTamanhoMemFis() {
        return tamanhoMemFis;
    }

    public void setTamanhoMemFis(int tamanhoMemFis) {
        this.tamanhoMemFis = tamanhoMemFis;
    }

    public int getTamanhoMemVir() {
        return tamanhoMemVir;
    }

    public void setTamanhoMemVir(int tamanhoMemVir) {
        this.tamanhoMemVir = tamanhoMemVir;
    }

    public ArrayList<Pagina> getMemPri() {
        return memPri;
    }

    public void setMemPri(ArrayList<Pagina> memPri) {
        this.memPri = memPri;
    }

    public int getTamanhoPagina() {
        return tamanhoPagina;
    }

    public void setTamanhoPagina(int tamanhoPagina) {
        this.tamanhoPagina = tamanhoPagina;
    }

    public Gerenciador(){
        Scanner in = new Scanner(System.in);
        System.out.println("Digite um valor inteiro para ser o tamanho máximo (em KB) da memória física: ");
        this.tamanhoMemFis = in.nextInt();
        System.out.println("Digite um valor inteiro para ser o tamanho máximo (em KB) da memória virtual: ");
        this.tamanhoMemVir = in.nextInt();
        System.out.println("Digite um valor inteiro para ser o tamanho das páginas (em KB): ");
        this.tamanhoPagina = in.nextInt();
        this.memPri = new ArrayList<>();
        this.memSec = new ArrayList<>();
    }

    public void preencherPag(Processo p){
        int i;
        for(i = 0; i < p.getTamanho()/this.tamanhoPagina;i++){
            p.getPaginas().add(new Pagina(this.tamanhoPagina, i, p));
        }
        if((double) p.getTamanho()/this.tamanhoPagina != p.getTamanho()/this.tamanhoPagina){
            p.getPaginas().add(new Pagina(this.tamanhoPagina * (double)p.getTamanho()/this.tamanhoPagina, i, p));
        }
    }

    public double getEspacoOcupado(ArrayList<Pagina> pags){
        double a = 0;
        for(Pagina pag:pags){
            a+=pag.getTamanho();
        }
        return a;
    }

    // se mem principal possui espaço livre, retornar true, else retornar false
    public boolean checarDispMemPri(){
        return this.memPri.size() < this.getEspacoOcupado(this.getMemPri());
    }

    public void alocPagMemPri(Pagina p){ //FIFO substituição de página
        if (!this.checarDispMemPri()){ // se a memoria principal estiver ocupada, colocar a mais antiga na secundaria e colocar a nova no inicio do array
            this.getMemSec().add(0, this.getMemPri().getLast());
            this.getMemPri().remove(this.getMemPri().getLast());
            this.getMemPri().add(0, p);
        } else {
            this.getMemPri().add(0, p);
        }
    }

    public int getPageFaults(Processo p){
        int a = 0;
        for(Pagina pag:this.memSec){
            if(pag.getProcessoCorresp() == p){
                a++;
            }
        }
        return a;
    }

    public int getPageHit(Processo p){
        int a = 0;
        for(Pagina pag:this.memPri){
            if(pag.getProcessoCorresp() == p){
                a++;
            }
        }
        return a;
    }

    public void printFrag(ArrayList<Processo> procs){
        System.out.println("Estado da fragmentação: ");
        for(Processo p: procs){
            System.out.println("Nome e ID: "+ p.getNome()+ " "+p.getId()+"\nPage faults: " + this.getPageFaults(p)+
                    "\nPage Hits: " + this.getPageHit(p)+"\n");
        }
        System.out.println("KB restantes na memória principal: " + (this.getTamanhoMemFis() - this.getEspacoOcupado(this.getMemPri())));
        System.out.println("Posições restantes na memória virtual: " + (this.getTamanhoMemVir() - (this.getEspacoOcupado(this.getMemPri()) + this.getEspacoOcupado(this.getMemSec()))));

    }


}
