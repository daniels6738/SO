import java.time.LocalDateTime;
import java.util.ArrayList;

public class DiretorioRAID {
    private ArrayList<ArquivoRAID> conteudo;
    private String nome;
    private LocalDateTime dataCriacao;

    public DiretorioRAID(String nome){
        this.nome = nome;
        this.conteudo = new ArrayList<>();
        dataCriacao = LocalDateTime.now();
    }


    public ArrayList<ArquivoRAID> getConteudo() {
        return this.conteudo;
    }

    public void setConteudo(ArrayList<ArquivoRAID> conteudo) {
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
        for(ArquivoRAID a:this.getConteudo()){
            a.liberarMem();
            a = null;
            conteudo.remove(a);
        }
    }

    public int calcTamanho(){
        int tam = 0;
        for(ArquivoRAID arq:this.getConteudo()){
            tam += arq.calcTamanho();
        }
        return tam;
    }

    public void printDir(){
        System.out.println("Nome do diretório: " + this.getNome() + "\nTamanho: " + this.calcTamanho() + "\nData de criação: " + this.getDataCriacao());
        System.out.println("\nArquivos:");
        for(ArquivoRAID a:this.getConteudo()){
            System.out.println(a);
        }
    } 

    public void delArq(int index){ //index do Arquivo no arraylist do diretorio
        this.getConteudo().get(index).liberarMem();
        this.getConteudo().remove(this.getConteudo().get(index));

    }
}
