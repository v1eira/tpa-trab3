/*
UVa 10038
Autores: Ewerson Vieira Nascimento e Icaro Gavazza
*/

import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (read.hasNextLine()) {
            ArrayList<Integer> sequence = new ArrayList<Integer>();
            ArrayList<Integer> jollyJumper = new ArrayList<Integer>();
            int number;

            String line = read.nextLine();
            List<String> input = Arrays.asList(line.split(" "));

            int size = Integer.parseInt(input.get(0));

            for (int i = 1; i <= size; i++) {
                number = Integer.parseInt(input.get(i));
                sequence.add(number);
            }

            checkIsJolly(size, sequence, jollyJumper);
        }
        read.close();
    }

    public static boolean checkIsJolly(int size, ArrayList<Integer> sequence, ArrayList<Integer> jollyJumper) {
        for (int i = 0; i < sequence.size() - 1; i++) {
            int absValue = sequence.get(i + 1) - sequence.get(i);
            
            if (absValue < 0)
                absValue = absValue * -1;

            boolean alreadyInserted = false;
                
            for (int j = 0; j < jollyJumper.size() - 1; j++) {
                if (jollyJumper.get(j) == absValue) {
                    alreadyInserted = true;
                    break;
                }
            }
            
            if (alreadyInserted == false)
                jollyJumper.add(absValue);
        }
        
        Collections.sort(jollyJumper);

        if (jollyJumper.size() != sequence.size() - 1) {
            System.out.println("Not jolly");
            return false;
        }

        for (int i = 0; i < jollyJumper.size(); i++) {
            if (jollyJumper.get(i) != i+1) {
                System.out.println("Not jolly");
                return false;
            }
        }

        System.out.println("Jolly");
        return true;
    }
}