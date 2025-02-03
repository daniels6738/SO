package Particao;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Gerenciador g = new Gerenciador();
        Scanner in = new Scanner(System.in);
        Processo p, ptemp;
        Random rand = new Random();
        while(true){
            System.out.println("Gostaria de iniciar um novo processo?\nDigite \"S\" " +
                    "para criar um processo novo\nou \"N\" para parar de criar processos: ");
            String a = in.nextLine();
            if(Objects.equals(a, "N")){
                break;
            }
            else if(Objects.equals(a, "S")){
                p = new Processo();
                if(p.getTamanho() > g.getTamanhoParticao()){
                    System.out.println("Tamanho inválido.\n");
                    continue;
                }
                if(g.getMemPrincipal().size() + 1 > g.getTamanhoMax()/g.getTamanhoParticao()){
                    ptemp = g.getMemPrincipal().get(rand.nextInt(g.getMemPrincipal().size()));
                    g.getMemSecundaria().add(ptemp);
                    g.getMemPrincipal().remove(ptemp);
                    g.getMemPrincipal().add(p);
                    System.out.println("Aviso: Memória principal cheia! Realizando Swapping...");
                }
                else{
                    g.getMemPrincipal().add(p);
                }
            }
            else {System.out.println("Valor inválido, tente novamente: ");}
            g.printFrag(g);
        }
    }
}