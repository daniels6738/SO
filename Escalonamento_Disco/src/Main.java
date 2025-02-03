import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        int[] filaTemp = {1,36,16,34,9,12};
        Braco braco = new Braco(new Disco(0, 36, 11), true);
        ArrayList<Integer> fila = new ArrayList<>();
        for(int i = 0; i < filaTemp.length; i++){
            fila.add(filaTemp[i]);
        }
        braco.SSF(fila);
        System.out.println(braco.getTempo());
    }
}
