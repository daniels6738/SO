public class Bloco {
    private boolean ocupado;
    private boolean ultimo;
    private Bloco next;


    public Bloco(boolean ocupado, boolean ultimo, Bloco next) {
        this.ocupado = ocupado;
        this.ultimo = ultimo;
        this.next = next;
    }

    public Bloco(){
        this.ocupado = false;
        this.ultimo = false;
        this.next = null;
    }

    public Bloco getNext() {
        return this.next;
    }

    public void setNext(Bloco next) {
        this.next = next;
    }

    public boolean isOcupado() {
        return this.ocupado;
    }

    public boolean getOcupado() {
        return this.ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public boolean isUltimo() {
        return this.ultimo;
    }

    public boolean getUltimo() {
        return this.ultimo;
    }

    public void setUltimo(boolean ultimo) {
        this.ultimo = ultimo;
    }

}
