/*
UVa 11340 - Newspaper
Autores: Ewerson Vieira Nascimento e Icaro Gavazza
*/

import java.util.Scanner;

public class Main {
    static final int max = 128;
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int[] cents = new int[max];

        int n = read.nextInt();

        for (int i = 0; i < n; i++) {
            int payment = 0;
            int k = read.nextInt();

            for (int j = 0; j < max; j++) {
                cents[j] = -1;
            }

            for (int j = 0; j < k; j++) {
                int character = (int) read.next().charAt(0);
                int value = read.nextInt();
                cents[character] = value;
            }

            int m = read.nextInt();
            read.nextLine();
            
            for (int x = 0; x < m; x++) {
                String line = read.nextLine();
                for (int y = 0; y < line.length(); y++) {
                    int character = (int) line.charAt(y);
                    if (character < 0 || character >= max || cents[character] < 0)
                        payment += 0;
                    else
                        payment += cents[character];
                }
            }
            if (payment % 100 < 10)
                System.out.printf("%d.0%d$\n", payment / 100, payment % 100);
            else
                System.out.printf("%d.%d$\n", payment / 100, payment % 100);
        }

        read.close();
    }
}