import java.time.LocalDateTime;
import java.util.ArrayList;

public class Diretorio {
    private ArrayList<Arquivo> conteudo;
    private String nome;
    private LocalDateTime dataCriacao;

    public Diretorio(String nome){
        this.nome = nome;
        this.conteudo = new ArrayList<>();
        dataCriacao = LocalDateTime.now();
    }


    public ArrayList<Arquivo> getConteudo() {
        return this.conteudo;
    }

    public void setConteudo(ArrayList<Arquivo> conteudo) {
        this.conteudo = conteudo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDataCriacao() {
        return this.dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void excluirDir(){
        for(Arquivo a:this.getConteudo()){
            a.liberarMem();
            a = null;
            conteudo.remove(a);
        }
    }

    public int calcTamanho(){
        int tam = 0;
        for(Arquivo arq:this.getConteudo()){
            tam += arq.calcTamanho();
        }
        return tam;
    }

    public void printDir(){
        System.out.println("Nome do diretório: " + this.getNome() + "\nTamanho: " + this.calcTamanho() + "\nData de criação: " + this.getDataCriacao());
        System.out.println("\nArquivos:");
        for(Arquivo a:this.getConteudo()){
            System.out.println(a);
        }
    } 

    public void delArq(int index){ //index do arquivo no arraylist do diretorio
        this.getConteudo().get(index).liberarMem();
        this.getConteudo().remove(this.getConteudo().get(index));

    }
}
