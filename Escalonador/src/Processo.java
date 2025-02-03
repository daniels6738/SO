import java.util.Scanner;

public class Processo {

    public enum Tipo {
        CPU_BOUND,
        IO_BOUND
    }

    private int id;
    private String nome;
    private int prioridade;
    private Tipo tipo;
    private int tempoRestante;
    private int tempoTotal;
    private int tempoDeEspera;

    public Processo(int id, String nome, int prioridade, Tipo tipo, int tempoTotal) {
        this.id = id;
        this.nome = nome;
        this.prioridade = prioridade;
        this.tipo = tipo;
        this.tempoTotal = tempoTotal;
        this.tempoRestante = tempoTotal;
        this.tempoDeEspera = 0;
    }

    public Processo(){
        Scanner in = new Scanner(System.in);
        System.out.println("Digite uma String para ser o nome do processo: ");
        this.nome = in.nextLine();
        System.out.println("Digite um valor inteiro para ser o ID do processo: ");
        this.id = in.nextInt();
        System.out.println("Digite um valor inteiro para ser a prioridade do processo: ");
        this.prioridade = in.nextInt();
        System.out.println("Digite 1 para o processo ser CPU BOUND ou 2 para ser IO BOUND: ");
        while(true){
            int a = in.nextInt();
            if(a == 1){
                this.tipo = Tipo.CPU_BOUND;
                break;
            }
            else if (a == 2){
                this.tipo = Tipo.IO_BOUND;
                break;
            }
            else System.out.println("Valor inválido, tente novamente: ");
        }
        System.out.println("Digite um valor inteiro para ser o tempo de execução do processo: ");
        this.tempoTotal = in.nextInt();
        this.tempoRestante = this.tempoTotal;
        this.tempoDeEspera = 0;
    }

    public int getTempoDeEspera() {
        return tempoDeEspera;
    }

    public void setTempoDeEspera(int tempoDeEspera) {
        this.tempoDeEspera = tempoDeEspera;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public int getTempoRestante() {
        return tempoRestante;
    }

    public void setTempoRestante(int tempo_total) {
        this.tempoRestante = tempo_total;
    }

    public int getTempoTotal() {
        return tempoTotal;
    }

    public void setTempoTotal(int tempoTotal) {
        this.tempoTotal = tempoTotal;
    }

    @Override
    public String toString() {
        return "Processo{" +
                "nome='" + nome + '\'' +
                ", prioridade=" + prioridade +
                '}';
    }
}
