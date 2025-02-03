import java.util.ArrayList;

public class Braco {
    private Disco disco;
    private boolean dir; //true para subir, false para descer no elevador
    private int tempo;


    public Braco(Disco disco, boolean dir) {
        this.disco = disco;
        this.dir = dir;
        this.tempo = 0;
    }


    public Disco getDisco() {
        return this.disco;
    }

    public void setDisco(Disco disco) {
        this.disco = disco;
    }

    public boolean getDir() {
        return this.dir;
    }

    public void setDir(boolean dir) {
        this.dir = dir;
    }

    public int getTempo() {
        return this.tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public Integer achaProx (ArrayList<Integer> fila){
        int dif =(int) Math.sqrt(Math.pow(this.getDisco().getMax() - this.getDisco().getMin(), 2));
        Integer a = null;
        for(Integer i:fila){
            if((int) Math.sqrt(Math.pow(this.getDisco().getPos_atual() - i, 2)) < dif){
                dif = (int) Math.sqrt(Math.pow(this.getDisco().getPos_atual() - i, 2));
                a = i;
            }
        }
        fila.remove(a);
        return a;
    }

    public void incrTempo(Integer i){
        this.setTempo(this.getTempo() + (int)Math.sqrt(Math.pow(this.getDisco().getPos_atual() - i, 2)));
        this.getDisco().setPos_atual(i);
        
    }

    public void SSF(ArrayList<Integer> fila){
        while(!fila.isEmpty()){
            incrTempo(achaProx(fila));
        }
    }
}
