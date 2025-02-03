import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
//        Processo processo1 = new Processo(1, "p1", 6, Processo.Tipo.CPU_BOUND, 9);
//        Processo processo2 = new Processo(2, "p2", 3, Processo.Tipo.CPU_BOUND, 7);
//        Processo processo3 = new Processo(3, "p3", 5, Processo.Tipo.IO_BOUND, 2);
//        Processo processo4 = new Processo(4, "p4", 4, Processo.Tipo.CPU_BOUND, 4);
//        Processo processo5 = new Processo(5, "p5", 1, Processo.Tipo.IO_BOUND, 5);

        ArrayList<Processo> processos = new ArrayList<Processo>();

//        processos.add(processo1);
//        processos.add(processo2);
//        processos.add(processo3);
//        processos.add(processo4);
//        processos.add(processo5);
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("Gostaria de iniciar um novo processo?\nDigite \"S\" " +
                    "para criar um processo novo\nou N para parar de criar processos: ");
            String a = in.nextLine();
            if(Objects.equals(a, "N")){
                break;
            }
            else if(Objects.equals(a, "S")){
                processos.add(new Processo());
            }
            else System.out.println("Valor inválido, tente novamente: ");
        }

        ArrayList<Processo> F;

        Escalonador escalonador = new Escalonador(processos);
        while(true){
            System.out.println("Digite 1 para utilizar o algoritmo Shortest Job" +
                    " First, 2 para \nutilizar First In First Out ou\n3 " +
                    "para utilizar Round-Robin: ");
            int a = in.nextInt();
            if(a==1){
                F = escalonador.executarSJF();
                break;
            }
            else if(a==2){
                F = escalonador.executarFIFO();
                break;
            }
            else if(a==3){
                System.out.println("Digite um valor inteiro para ser o quantum de preempção: ");
                F = escalonador.executarRoundRobin(in.nextInt());
                break;
            }
            else System.out.println("Valor inválido, tente novamente: ");
        }
//        ArrayList<Processo> F = escalonador.executarFIFO();

        System.out.println("Tempo de turnaround de cada processo:");
        for (Processo processo: F){
            System.out.println("Nome do processo: " + processo.getNome() + "\nTempo de turnaround: " + (processo.getTempoDeEspera() + processo.getTempoTotal()) + "\n");
        }
        int a = 0;
        for(Processo processo:F){
            a = a + processo.getTempoDeEspera();
        }
        System.out.println("Média de tempo de espera dos processos: " + a/F.size());
    }
}