/*
UVa 10264
Autores: Ewerson Vieira Nascimento e Icaro Gavazza
*/

import java.util.Scanner;
import java.math.*;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        
        int dimension;
        int[] edges = new int[35000];
        int[] sum = new int[35000];

        while (read.hasNext()) {
            dimension = read.nextInt();
            
            double numberOfEdges = Math.pow(2, dimension);
            int highestSum = 0;

            for (int i = 0; i < numberOfEdges; i++) {
                edges[i] = read.nextInt();
            }

            for (int i = 0; i < numberOfEdges; i++) {
                int sumEdges = 0;
                
                for (int j = 0; j < dimension; j++) {
                    int edgeValue = i ^ (1 << j);
                    sumEdges += edges[edgeValue];
                }
                
                sum[i] = sumEdges;
            }

            for (int i = 0; i < numberOfEdges; i++) {
                for (int j = 0; j < dimension; j++) {
                    int edgeValue = i ^ (1 << j);
                    highestSum = Math.max(highestSum, sum[i] + sum[edgeValue]);
                }
            }

            System.out.println(highestSum);
        }

        read.close();
    }
}