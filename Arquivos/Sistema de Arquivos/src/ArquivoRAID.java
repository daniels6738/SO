import java.time.LocalDateTime;

public class ArquivoRAID{
    private String nome;
    private LocalDateTime dataCriacao;
    private Bloco cabeca;

    public ArquivoRAID(String nome, int tamanho, Bloco[] disco1, Bloco[] disco2){
        this.nome = nome;
        this.dataCriacao = LocalDateTime.now();
        this.cabeca = alocaBlocosRAID(disco1, disco2, tamanho);
        int index = -1; //-1 para debug, valor impossivel em array
        for(int i = 0; i < disco1.length;i++){
            if (cabeca == disco1[i]){
                index = i;
                System.out.println("Bloco da cabeça da lista encadeada: " + index + "\nCabeça está no disco 1\n");
            }
        }

        for(int i = 0; i < disco2.length;i++){
            if (cabeca == disco2[i]){
                index = i;
                System.out.println("Bloco da cabeça da lista encadeada: " + index + "\nCabeça está no disco 2\n");
            }
        }
    }

    public Bloco getCabeca() {
        return this.cabeca;
    }

    public void setCabeca(Bloco cabeca) {
        this.cabeca = cabeca;
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

    /* public Bloco achaBlocoLivre(Bloco[] mem){
        for(Bloco b:mem){
            if(b.getOcupado() == false){
                return b; //Definir cabeça da lista do arquivo
            }
        }
        return null;
    } */

    public Bloco achaBlocoLivreRAID(Bloco[] disco1, Bloco[] disco2){
        //assume que ambos os discos tem mesmo espaco para blocos
        for(int i = 0; i < disco1.length;i++){
            if(!disco1[i].isOcupado()){
                return disco1[i];
            } else if(!disco2[i].isOcupado()){
                return disco2[i];
            }
        }
        return null;
    }

    /* public Bloco alocaBlocos(Bloco[] mem, int tamanho){
        Bloco cabeca;
        int rest = tamanho;
        cabeca = achaBlocoLivre(mem);
        Bloco atual = cabeca;
        while(rest > 0){
            rest--;
            atual.setOcupado(true);
            if(rest != 0){
                atual.setNext(achaBlocoLivre(mem));
                atual = atual.getNext();
            }
            else{
                atual.setUltimo(true);
            }
        }
        return cabeca;
    } */

    public Bloco alocaBlocosRAID(Bloco[] disco1, Bloco[] disco2, int tamanho){
        Bloco cabeca = achaBlocoLivreRAID(disco1, disco2);
        int rest = tamanho;
        Bloco atual = cabeca;
        while(rest > 0){
            rest--;
            atual.setOcupado(true);
            if(rest != 0){
                atual.setNext(achaBlocoLivreRAID(disco1, disco2));
                atual = atual.getNext();
            }
            else{
                atual.setUltimo(true);
            }
        }
        return cabeca;
    }
    
    public int calcTamanho(){
        Bloco atual = this.cabeca;
        int tamanho = 0;
        while(atual.isUltimo() == false){
            tamanho++;
            atual = atual.getNext();
        }
        tamanho++; //para contar o tamanho do ultimo bloco :)
        return tamanho;
    }

    public void liberarMem(){
        Bloco atual = this.getCabeca();
        while(atual.isUltimo() == false){
            atual.setOcupado(false);
            atual = atual.getNext();
        }
        atual.setOcupado(false);
        atual.setUltimo(false);
    }

    @Override
    public String toString() {
        return "\nNome do arquivo: " + getNome() + "\nTamanho:" + calcTamanho() + "KB\nData de criação: " + getDataCriacao();
    }

}