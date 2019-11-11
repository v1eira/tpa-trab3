/*
UVa 11581
Autores: Ewerson Vieira Nascimento e Icaro Gavazza
*/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        
        int tests = read.nextInt();
        String line;

        while (tests > 0) {
            int[][] grid = new int[3][3];
            int count = 0;

            for (int i = 0; i < 3; i++) {
                line = read.next();
                for (int j = 0; j < 3; j++) {
                    grid[i][j] = Character.getNumericValue(line.charAt(j));
                    count += grid[i][j];
                }
            }

            if (count == 0)
                System.out.println(-1);
            else {
                int index = -1;

                while (count > 0) {
                    count = 0;
                    index += 1;
                    int[][] grid2 = new int[3][3];

                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            grid2[i][j] = grid[i][j];
                        }
                    }

                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            int sum = 0;
                            if (i - 1 >= 0)
                                sum += grid2[i-1][j];
                            if (j - 1 >= 0)
                                sum += grid2[i][j-1];
                            if (i + 1 < 3)
                                sum += grid2[i+1][j];
                            if (j + 1 < 3)
                                sum += grid2[i][j+1];
                            grid[i][j] = sum%2;
                            count += grid[i][j];
                        }
                    }
                }
                
                System.out.println(index);
            }

            tests -= 1;
        }

        read.close();
    }
}