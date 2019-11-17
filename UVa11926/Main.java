/*
UVa 11926
Autores: Ewerson Vieira Nascimento e Icaro Gavazza
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        while (read.hasNext()) {
            int n = read.nextInt();
            int m = read.nextInt();

            int[][] oneTime = new int[100][2];
            int[][] repeating = new int[100][3];

            if (n == 0 && m == 0)
                break;

            for (int i = 0; i < n; i++) {
                oneTime[i][0] = read.nextInt();
                oneTime[i][1] = read.nextInt();
            }

            for (int i = 0; i < m; i++) {
                repeating[i][0] = read.nextInt();
                repeating[i][1] = read.nextInt();
                repeating[i][2] = read.nextInt();
            }

            System.out.println(checkConflict(oneTime, repeating, n, m));
        }

        read.close();
    }

    public static String checkConflict(int[][] ot, int[][] rp, int n, int m) {
        
        // Compara oneTime com oneTime
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (ot[j][0] >= ot[i][0] && ot[j][0] < ot[i][1]) {
                    return "CONFLICT";
                }

                if (ot[i][0] >= ot[j][0] && ot[i][0] < ot[j][1]) {
                    return "CONFLICT";
                }
            }
        }

        // Compara repeating com repeating
        for (int i = 0; i < m; i++) {
            for (int j = i+1; j < m; j++) {
                if (rp[j][0] >= rp[i][0] && rp[j][0] < rp[i][1])
                    return "CONFLICT";

                if (rp[i][0] >= rp[j][0] && rp[i][0] < rp[j][1])
                    return "CONFLICT";
                
                for (int k = 1; k < 500000; k++) {
                    int startA = rp[j][0]+rp[j][2]*k;
                    int startB = rp[i][0];
                    int endA = rp[j][1]+rp[j][2]*k;
                    int endB = rp[i][1];

                    if (startA > endB)
                        break;
                    
                    if (startA >= startB && startA < endB)
                        return "CONFLICT";
                    
                    if (endA >= startB && endA < endB)
                        return "CONFLICT";
                    
                    if (startA >= startB+rp[i][2]*k && startA < endB+rp[i][2]*k)
                        return "CONFLICT";
                    
                    if (endA >= startB+rp[i][2]*k && endA < endB+rp[i][2]*k)
                        return "CONFLICT";
                    
                    if (endB+rp[i][2]*k >= startA && endB+rp[i][2]*k < endA)
                        return "CONFLICT";
                }
            }
        }

        // Compara repeating com oneTime
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rp[j][0] >= ot[i][0] && rp[j][0] < ot[i][1])
                    return "CONFLICT";
                
                if (ot[i][0] >= rp[j][0] && ot[i][0] < rp[j][1])
                    return "CONFLICT";
                
                for (int k = rp[j][2]; k < 1000000; k += rp[j][2]) {
                    if (rp[j][0]+k > ot[i][1])
                        break;
                    
                    if (rp[j][0]+k >= ot[i][0] && rp[j][0]+k < ot[i][1])
                        return "CONFLICT";
                    
                    if (ot[i][0] >= rp[j][0]+k && ot[i][0] < rp[j][1]+k)
                        return "CONFLICT";
                }
            }
        }

        return "NO CONFLICT";
    }
}