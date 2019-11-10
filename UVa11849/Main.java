import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        int N = read.nextInt();
        int M = read.nextInt();
        int both = 0;

        while (N + M != 0) {
            int[] jack = new int[N];
            both = 0;

            for (int i = 0; i < N; i++)
                jack[i] = read.nextInt();

            for (int i = 0; i < M; i++) {
                if (Arrays.binarySearch(jack, read.nextInt()) >= 0)
                    both += 1;
            }

            System.out.println(both);
            
            N = read.nextInt();
            M = read.nextInt();
        }
        
        read.close();
    }
}