public class Disco {
    private int min;
    private int max;
    private int pos_atual;



    public Disco(int min, int max, int pos_atual) {
        this.min = min;
        this.max = max;
        this.pos_atual = pos_atual;
    }


    public int getMin() {
        return this.min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return this.max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getPos_atual() {
        return this.pos_atual;
    }

    public void setPos_atual(int pos_atual) {
        this.pos_atual = pos_atual;
    }

    

}
