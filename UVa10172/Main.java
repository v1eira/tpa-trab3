/*
UVa 10172
Autores: Ewerson Vieira Nascimento e Icaro Gavazza
*/

import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        int SET = read.nextInt();
        int N, S, Q, numberOfCargoes, destination;

        for (int i = 0; i < SET; i++) {
            N = read.nextInt();
            S = read.nextInt();
            Q = read.nextInt();

            ArrayList<ArrayList<Integer>> queue = new ArrayList<ArrayList<Integer>>();
            Stack<Integer> carrier = new Stack<Integer>();

            int pos = 0;
            int minutes = 0;

            boolean empty;

            for (int j = 0; j < 100; j++) {
                ArrayList<Integer> station = new ArrayList<Integer>();
                queue.add(station);
            }

            for (int j = 0; j < N; j++) {
                numberOfCargoes = read.nextInt();
                for (int k = 0; k < numberOfCargoes; k++) {
                    destination = read.nextInt();
                    queue.get(j).add(destination - 1);
                }
            }

            while (true) {
                for (int x = 0; x < queue.size(); x++) {
                    if (queue.get(x).size() == 0) {
                        continue;
                    }
                    for (int y = 0; y < queue.get(x).size(); y++) {
                        System.out.println("QUEUE " + x + " " + queue.get(x).get(y));
                    }
                }
                ArrayList<Integer> qPos = queue.get(pos);
                int carrierTop = -1;

                if (!carrier.empty())
                    carrierTop = carrier.peek();

                while (!carrier.empty() && (carrierTop == pos || qPos.size() < Q)) {
                    if (carrierTop != pos) {
                        qPos.add(carrierTop);
                    }
                    carrier.pop();
                    minutes += 1;
                }

                while ((carrier.size() < S) && !qPos.isEmpty()) {
                    carrier.push(qPos.get(0));
                    qPos.remove(qPos.size() - 1);
                    minutes += 1;
                }

                empty = carrier.empty();
                for (int j = 0; j < N; j++) {
                    if (empty == true && queue.get(j).isEmpty() == true)
                        empty = true;
                }

                if (empty)
                    break;

                pos = (pos + 1) % N;
                minutes += 2;
            }

            System.out.println(minutes);
        }

        read.close();
    }
}