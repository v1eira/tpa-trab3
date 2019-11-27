/*
UVa 10107 - What is the Median?
Autores: Ewerson Vieira Nascimento e Icaro Gavazza
*/

import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        ArrayList<Long> array = new ArrayList<Long>();
        int i = 0, middle;
        long input, median;

        while (read.hasNext()) {
            input = read.nextLong();
            array.add(input);

            if (array.size() > 0 && i > 0 && input < array.get(i-1)) {
                Collections.sort(array);
            }

            if (array.size() > 1) {
                if (array.size() % 2 == 0) {
                    middle = array.size()/2;
                    median = (array.get(middle) + array.get(middle-1)) / 2;
                } else {
                    median = array.get(array.size()/2);
                }
            } else {
                median = array.get(i);
            }

            System.out.println(median);
            i += 1;
        }

        read.close();
    }
}