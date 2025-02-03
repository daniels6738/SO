import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Escalonador {
    private ArrayList<Processo> processos;

    public Escalonador(ArrayList<Processo> processos) {
        this.processos = processos;
    }

    public ArrayList<Processo> getProcessos() {
        return processos;
    }

    public void setProcessos(ArrayList<Processo> processos) {
        this.processos = processos;
    }


    public ArrayList<Processo> executarFIFO() {
        ArrayList<Processo> finalizados = new ArrayList<>(); //arraylist para guardar os processos finalizados

        while (!this.processos.isEmpty()) {
            for (Processo processo : this.processos) { //imprimir fila
                System.out.println("Nome: " + processo.getNome() + ". Tempo de execução: " + processo.getTempoRestante());
            }
            finalizados.add(this.processos.get(0)); //colocar o primeiro da fila na lista dos finalizados
            this.processos.remove(0); //remover o processo finalizado da fila
            for (Processo processo : this.processos) { //adicionar o tempo de execução do processo finalizado ao tempo de espera dos processos na fila
                processo.setTempoDeEspera(processo.getTempoDeEspera() +
                        finalizados.get((finalizados.size() - 1)).getTempoRestante());
            }

            System.out.println("\n\n");
        }
        return finalizados;
    }

    public ArrayList<Processo> executarSJF(){
        Collections.sort(this.processos, Comparator.comparing(Processo::getTempoRestante)); //ordenar fila por menor tempo para executar
        ArrayList<Processo> finalizados = new ArrayList<>(); //arraylist para guardar os processos finalizados

        while(!this.processos.isEmpty()){ //imprimir fila
            for(Processo processo : this.processos){
                System.out.println("Nome: " + processo.getNome()+ ". Tempo de execução: " + processo.getTempoRestante());
            }
            finalizados.add(this.processos.get(0)); //colocar o primeiro da fila na lista dos finalizados
            this.processos.remove(0); //remover o processo finalizado da fila
            Collections.sort(this.processos, Comparator.comparing(Processo::getTempoRestante)); //ordenar novamente a fila
            for (Processo processo : this.processos) { //adicionar o tempo de execução do processo finalizado ao tempo de espera dos processos na fila
                processo.setTempoDeEspera(processo.getTempoDeEspera() +
                        finalizados.get((finalizados.size()-1)).getTempoRestante());
            }

            System.out.println("\n\n");
        }

        return finalizados;
    }

    public ArrayList<Processo> executarRoundRobin(int quantum){
        ArrayList<Processo> finalizados = new ArrayList<>(); //arraylist para guardar os processos finalizados
        Processo p;

        while(!this.processos.isEmpty()){ //enquanto fila não estiver vazia
            for(Processo processo : this.processos){ //imprimir fila
                System.out.println("Nome: " + processo.getNome()+ ". Tempo de execução: " + processo.getTempoRestante());
            }
            p = this.processos.get(0);
            if(this.processos.get(0).getTempoRestante() <= quantum){
                finalizados.add(p);
                this.processos.remove(0);
                for (Processo processo : this.processos) { //adicionar o tempo de execução do processo finalizado ao tempo de espera dos processos na fila
                processo.setTempoDeEspera(processo.getTempoDeEspera() +
                        finalizados.get((finalizados.size()-1)).getTempoRestante());
                }
            }
            else {
                p.setTempoRestante(p.getTempoRestante()-quantum);
                this.processos.remove(0);
                for (Processo processo : this.processos) { //adicionar o tempo de execução do processo finalizado ao tempo de espera dos processos na fila
                    processo.setTempoDeEspera(processo.getTempoDeEspera() +
                            quantum);
                }
                this.processos.add(p);
            }

            System.out.println("\n\n");
        }

        return finalizados;
    }

}
