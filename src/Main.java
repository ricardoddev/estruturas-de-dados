import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            int n = sc.nextInt(); // número de cartas na pilha
            
            if (n == 0) {
                break;
            }

            FilaDinamica f = new FilaDinamica();

            for (int i = 1; i <= n; i++) {
                f.enqueue(i);
            }
            
            FilaDinamica descartadas = new FilaDinamica();

            while (f.tamanho() >= 2) {
                Integer x = (Integer) f.dequeue(); // descarta a carta do topo
                if (x != null) {
                    descartadas.enqueue(x);
                }
                
                x = (Integer) f.frente(); // move a próxima carta para a base
                f.enqueue(x);
                f.dequeue();
            }
            
            System.out.print("Discarded cards: ");
            descartadas.exibir();
            
            System.out.println();
            
            System.out.println("Remaining card: " + f.frente());
        }
    }
}