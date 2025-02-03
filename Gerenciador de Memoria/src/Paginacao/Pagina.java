package Paginacao;

import java.time.LocalDateTime;

public class Pagina {
    private double tamanho;
    private int endVirtual;
    private Processo processoCorresp;


    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    public int getEndVirtual() {
        return endVirtual;
    }

    public void setEndVirtual(int endVirtual) {
        this.endVirtual = endVirtual;
    }

    public Processo getProcessoCorresp() {
        return processoCorresp;
    }

    public void setProcessoCorresp(Processo processoCorresp) {
        this.processoCorresp = processoCorresp;
    }

    public Pagina(double tamanho, int endVirtual, Processo processoCorresp) {
        this.tamanho = tamanho;
        this.endVirtual = endVirtual;
        this.processoCorresp = processoCorresp;
    }
}
