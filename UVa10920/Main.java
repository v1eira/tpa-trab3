import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        long SZ, P;

        for (;;) {
            SZ = read.nextLong();
            P = read.nextLong();
            
            if (SZ == 0 && P == 0)
                break;
            
            double root = Math.floor((Math.sqrt(P)));
            if (root * root == P && root % 2 == 1) {
            } else if (root % 2 == 1)
                root += 2;
            else
                root += 1;
            
            double i = root / 2, j = root / 2;
            if (root * root != 1) {
                double group = (root * root - P) / (root - 1);
                switch((int)group) {
                    case 0:
                        i -= root * root - P;
                        break;
                    case 1:
                        i -= root - 1;
                        j -= (root * root - P - (root - 1));
                        break;
                    case 2:
                        i -= (root - 1) - (root * root - P - (root - 1) * 2);
                        j -= root - 1;
                        break;
                    case 3:
                        j -= (root - 1) - (root * root - P - (root - 1) * 3);
                        break;
                }
            }
            System.out.printf("Line = %d, column = %d.\n", (int) (i + (SZ / 2) + 1), (int) (j + (SZ / 2) + 1));
        }
        read.close();
    }
}