package Paginacao;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Gerenciador g = new Gerenciador();
        Scanner in = new Scanner(System.in);
        Processo p;
        ArrayList<Processo> procs = new ArrayList<>();
        while(true){
            System.out.println("Gostaria de iniciar um novo processo?\nDigite \"S\" " +
                    "para criar um processo novo\nou \"N\" para parar de criar processos: ");
            String a = in.nextLine();
            if(Objects.equals(a, "N")){
                break;
            }
            else if(Objects.equals(a, "S")){
                p = new Processo();
                procs.add(p);
                g.preencherPag(p);
                for(Pagina pag: p.getPaginas()){
                    g.alocPagMemPri(pag);
                }
            }
            else {System.out.println("Valor inválido, tente novamente: ");}
            g.printFrag(procs);
        }
    }
}