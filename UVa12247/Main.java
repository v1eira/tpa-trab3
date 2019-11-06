import java.util.Scanner;
import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int A, B, C, X, Y;
        int[] princess = new int[3];
        String[] values = new String[5];
        
        String line = read.nextLine();
        values = line.split(" ");
        
        princess[0] = A = Integer.parseInt(values[0]);
        princess[1] = B = Integer.parseInt(values[1]);
        princess[2] = C = Integer.parseInt(values[2]);
        X = Integer.parseInt(values[3]);
        Y = Integer.parseInt(values[4]);
        
        if (X > Y) {
            int tmp = X;
            X = Y;
            Y = tmp;
        }
        
        while (A != 0 && B != 0 && C != 0 && X != 0 && Y != 0) {
            Arrays.sort(princess);
            
            if (princess[1] > Y) 
                System.out.println("-1");
            else if (princess[2] > Y) {
                if (princess[1] > X)
                    System.out.println("-1");
                else {
                    int card = princess[1] + 1;
                    while (card == X || card == Y || card == princess[2])
                        card++;
                    if (card < 53)
                        System.out.println(card);
                    else
                        System.out.println("-1");
                }
            }
            else {
                if (princess[1] > X) {
                    int card = princess[2] + 1;
                    while (card == X || card == Y)
                        card++;
                    if (card < 53)
                        System.out.println(card);
                    else
                        System.out.println("-1");
                }
                else if (princess[2] > X) {
                    int card = princess[1] + 1;
                    while (card == X || card == Y || card == princess[2])
                        card++;
                    if (card < 53)
                        System.out.println(card);
                    else
                        System.out.println("-1");
                }
                else {
                    int card = 1;
                    while (card == X || card == Y || card == princess[0] || card == princess[1] || card == princess[2])
                        card++;
                    if (card < 53)
                        System.out.println(card);
                    else
                        System.out.println("-1");
                }
            }
            
            line = read.nextLine();
            values = line.split(" ");

            princess[0] = A = Integer.parseInt(values[0]);
            princess[1] = B = Integer.parseInt(values[1]);
            princess[2] = C = Integer.parseInt(values[2]);
            X = Integer.parseInt(values[3]);
            Y = Integer.parseInt(values[4]);
            
            if (X > Y) {
                int tmp = X;
                X = Y;
                Y = tmp;
            }
        }
    }
}